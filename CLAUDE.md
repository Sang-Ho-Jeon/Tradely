# Tradely Backend

## Project Overview
투자 전략 공유 소셜 플랫폼 백엔드 API 서버.
트레이더가 투자 전략을 등록하고, 투자자가 이를 팔로우하여 활용하는 서비스.

## Tech Stack
- Java 17, Spring Boot 3.3.5, Maven
- MySQL 8.4, Spring Data JPA, MyBatis, QueryDSL
- Spring Security + JWT (jjwt 0.12.3)
- AWS S3 (파일 업로드)
- SpringDoc OpenAPI 2.6.0 (Swagger)

## Build & Run

```bash
# 로컬 Maven 빌드
./mvnw clean package -DskipTests

# Docker 로컬 실행 (MySQL + App + Nginx)
docker compose -f docker-compose.yml -f docker-compose.local.yml up --build -d

# Docker 중지
docker compose -f docker-compose.yml -f docker-compose.local.yml down

# 로그 확인
docker logs tradely-app -f
```

## Project Structure
```
src/main/java/com/sysmatic2/finalbe/
├── config/          # Spring 설정 (Security, Swagger, S3, JPA)
├── jwt/             # JWT 인증/인가
├── member/          # 회원 관리
├── admin/           # 관리자 기능
├── strategy/        # 투자 전략
├── cs/              # 고객센터/커뮤니티
├── attachment/      # 파일 첨부
└── util/            # 유틸리티
```

## Configuration
- 모든 설정값은 환경변수로 관리 (`application.properties` → `${ENV_VAR}`)
- 로컬 개발 시 프로젝트 루트의 `.env` 파일 사용 (gitignore 대상)
- SSL은 Nginx에서 처리, Spring Boot 앱에서는 비활성화

## Deployment
- GCP Compute Engine에 Docker로 배포
- 도메인: tradely.online (가비아)
- Nginx → Spring Boot (8080) 리버스 프록시
- Let's Encrypt SSL (Certbot)

## Conventions
- 기능별 패키지 구조: controller → service → repository → entity → dto
- API 문서는 Swagger 어노테이션 사용
- 민감 정보(비밀번호, API 키)는 절대 코드에 하드코딩하지 않음
