#!/bin/bash
# GCP 최초 배포 시 SSL 인증서 발급 스크립트
# 사용법: ./init-ssl.sh api.tradely.online your-email@gmail.com

set -e

DOMAIN=${1:?도메인을 입력하세요 (예: api.tradely.online)}
EMAIL=${2:?이메일을 입력하세요 (예: your-email@gmail.com)}

NGINX_CONF="nginx/default.conf"

echo "[1/4] SSL 없이 Nginx 시작 (HTTP only)..."

# 원본 설정 백업
cp "${NGINX_CONF}" "${NGINX_CONF}.bak"

# SSL 없는 임시 nginx 설정으로 교체 (호스트 파일 직접 수정 → 볼륨 마운트로 반영)
cat > "${NGINX_CONF}" << EOF
server {
    listen 80;
    server_name ${DOMAIN};

    location /.well-known/acme-challenge/ {
        root /var/www/certbot;
    }

    location / {
        proxy_pass http://app:8080;
        proxy_set_header Host \$host;
        proxy_set_header X-Real-IP \$remote_addr;
    }
}
EOF

# 전체 컨테이너 시작
docker compose up -d db
echo "DB 초기화 대기 중..."
sleep 15

docker compose up -d app
echo "앱 시작 대기 중..."
sleep 10

docker compose up -d nginx
sleep 3

echo "[2/4] Let's Encrypt 인증서 발급 중..."
docker compose run --rm certbot certonly \
    --webroot \
    -w /var/www/certbot \
    -d "${DOMAIN}" \
    --email "${EMAIL}" \
    --agree-tos \
    --no-eff-email

echo "[3/4] SSL Nginx 설정 복원..."
# 원본 SSL 설정으로 복원
cp "${NGINX_CONF}.bak" "${NGINX_CONF}"
rm "${NGINX_CONF}.bak"

# Nginx 설정 리로드
docker exec tradely-nginx nginx -s reload

echo "[4/4] 완료!"
echo "https://${DOMAIN} 에서 접속 확인하세요."
