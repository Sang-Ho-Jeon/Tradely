package com.sysmatic2.finalbe.strategy.entity;

import com.sysmatic2.finalbe.common.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "daily_statistics_history")
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DailyStatisticsHistoryEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "daily_statistics_history_id", nullable = false)
    private Long dailyStatisticsHistoryId; // 전략 일간 통계 이력 ID

    @ManyToOne
    @JoinColumn(name = "strategy_id", nullable = false)
    private StrategyEntity strategyEntity; // 전략 FK

    @ManyToOne
    @JoinColumn(name = "daily_statistics_id", nullable = false)
    private DailyStatisticsEntity dailyStatistics; // 일간 통계 FK

    @Column(name = "date", nullable = false)
    private LocalDate date; // 일자

    @Column(name = "daily_profit_loss", nullable = false, precision = 25, scale = 10)
    private BigDecimal dailyProfitLoss; // 일손익 - 입력

    @Column(name = "dep_wd_price", nullable = false, precision = 25, scale = 10)
    private BigDecimal depWdPrice; // 입출금 - 입력

    @Column(name = "trading_days", nullable = false)
    private Integer tradingDays; // 거래일수 - 일손익이 0이 아닌 날 누적(상세 사용)

    @Column(name = "principal", nullable = false, precision = 25, scale = 10)
    private BigDecimal principal; // 원금 - 직전 원금 + 현재 입출금액(상세 사용)

    @Column(name = "balance", nullable = false, precision = 25, scale = 10)
    private BigDecimal balance; // 잔고 - 직전 잔고 + 입출금 + 일손익(상세 사용)

    @Column(name = "unrealized_profit_loss", nullable = false, precision = 25, scale = 10)
    private BigDecimal unrealizedProfitLoss; // 평가손익 - 원금 - 잔고

    @Column(name = "kp_ratio", nullable = false, precision = 25, scale = 10, columnDefinition = "DECIMAL(19,4) DEFAULT 0.0000")
    private BigDecimal kpRatio = BigDecimal.ZERO; // KP-Ratio

    @Builder.Default
    @Column(name = "sm_score", nullable = false, precision = 25, scale = 10, columnDefinition = "DECIMAL(19,4) DEFAULT 0.0000")
    private BigDecimal smScore = BigDecimal.ZERO; // SM-Score

    @Column(name = "reference_price", nullable = false, precision = 25, scale = 10)
    private BigDecimal referencePrice; // 기준가 - 잔고 / 원금 * 1000

    @Column(name = "cumulative_dep_wd_price", nullable = false, precision = 25, scale = 10)
    private BigDecimal cumulativeDepWdPrice; // 누적입출금액 - 두번째 입력일 ~ 오늘까지의 입출금액 합계(상세 사용)

    @Column(name = "deposit_amount", nullable = false, precision = 25, scale = 10)
    private BigDecimal depositAmount; // 입금 - 입출금 양수인 경우 입출금액, 입출금 음수인 경우 0

    @Column(name = "cumulative_deposit_amount", nullable = false, precision = 25, scale = 10)
    private BigDecimal cumulativeDepositAmount; // 누적입금 - 두번째 입력일 ~ 오늘까지의 출금액 합계

    @Column(name = "withdraw_amount", nullable = false, precision = 25, scale = 10)
    private BigDecimal withdrawAmount; // 출금 - 입출금 음수인 경우 입출금액, 입출금 양수인 경우 0

    @Column(name = "cumulative_withdraw_amount", nullable = false, precision = 25, scale = 10)
    private BigDecimal cumulativeWithdrawAmount; // 누적출금두번째 - 두번째 입력일 ~ 오늘까지의 출금액 합계

    @Column(name = "daily_pl_rate", nullable = false, precision = 25, scale = 10)
    private BigDecimal dailyPlRate; // 일손익률 - (오늘 기준가 - 직전 기준가) / 직전 기준가

    @Column(name = "max_daily_profit", nullable = false, precision = 25, scale = 10)
    private BigDecimal maxDailyProfit; // 최대일이익 - 오늘까지의 일손익 중 최대값(양수 or 0)(상세 사용)

    @Column(name = "max_daily_profit_rate", nullable = false, precision = 25, scale = 10)
    private BigDecimal maxDailyProfitRate; // 최대일이익률(%) - 오늘까지의 일손익률 중 최대값(양수 or 0)(상세 사용)

    @Column(name = "max_daily_loss", nullable = false, precision = 25, scale = 10)
    private BigDecimal maxDailyLoss; // 최대일손실 - 오늘까지의 일손익중 최저값(음수 or 0)(상세 사용)

    @Column(name = "max_daily_loss_rate", nullable = false, precision = 25, scale = 10)
    private BigDecimal maxDailyLossRate; // 최대일손실률(%) - 오늘까지의 일손익률 중 최저값,(음수 or 0)(상세 사용)

    @Column(name = "total_profit", nullable = false, precision = 25, scale = 10)
    private BigDecimal totalProfit; // 총이익 - 양수인 일손익 합산(상세 사용)

    @Column(name = "total_profit_days", nullable = false)
    private Integer totalProfitDays; // 총이익일수 - 일손익 양수일때의 일수(상세 사용)

    @Column(name = "average_profit", nullable = false, precision = 25, scale = 10)
    private BigDecimal averageProfit; // 평균이익 - 총이익 / 이익일수, 이익일수 0이거나 없으면 값도 0

    @Column(name = "total_loss", nullable = false, precision = 25, scale = 10)
    private BigDecimal totalLoss; // 총손실 - 음수인 일손익 합산

    @Column(name = "total_loss_days", nullable = false)
    private Integer totalLossDays; // 총손실일수 - 일손익 음수일때의 일수(상세 사용)

    @Column(name = "average_loss", nullable = false, precision = 25, scale = 10)
    private BigDecimal averageLoss; // 평균손실 - 총 손실 / 손실일수, 손실일수 0이거나 없으면 값도 0

    @Column(name = "cumulative_profit_loss", nullable = false, precision = 25, scale = 10)
    private BigDecimal cumulativeProfitLoss; // 누적손익 - 오늘까지의 일손익 합산

    @Column(name = "cumulative_profit_loss_rate", nullable = false, precision = 25, scale = 10)
    private BigDecimal cumulativeProfitLossRate; // 누적손익률(%) - 기준가 / 1000 - 1(상세사용)

    @Column(name = "max_cumulative_profit_loss", nullable = false, precision = 25, scale = 10)
    private BigDecimal maxCumulativeProfitLoss; // 최대누적손익 - 오늘까지의 누적손익 최대값(양수 or 0)(상세 사용)

    @Column(name = "max_cumulative_profit_loss_rate", nullable = false, precision = 25, scale = 10)
    private BigDecimal maxCumulativeProfitLossRate; // 최대누적손익률(%) - 오늘까지의 누적손익률 최대값(양수 or 0)(상세 사용)

    @Column(name = "average_profit_loss", nullable = false, precision = 25, scale = 10)
    private BigDecimal averageProfitLoss; // 평균손익 - 누적손익 / 거래일수(상세 사용)

    @Column(name = "average_profit_loss_rate", nullable = false, precision = 25, scale = 10)
    private BigDecimal averageProfitLossRate; // 평균손익률(%) - 누적손익률 / 거래일수(상세사용)

    @Column(name = "peak", nullable = false, precision = 25, scale = 10)
    private BigDecimal peak; // Peak - 누적손익 최대값(양수 or 0)

    @Column(name = "peak_rate", nullable = false, precision = 25, scale = 10)
    private BigDecimal peakRate; // Peak(%) - 누적손익률 최대값(양수 or 0)

    @Column(name = "days_since_peak", nullable = false)
    private Integer daysSincePeak; // // 고점후경과일 - 직전거래일 Peak값, 오늘 Peak값 동일하고 양수이면 직전 고점후 경과일 +1, 아니면 0(상세사용)

    @Column(name = "current_drawdown_amount", nullable = false, precision = 25, scale = 10)
    private BigDecimal currentDrawdownAmount; // 현재자본인하금액 - 누적손익 - 최대누적손익, 누적손익 0보다 큰 값(상세 사용)

    @Column(name = "current_drawdown_rate", nullable = false, precision = 25, scale = 10)
    private BigDecimal currentDrawdownRate; // 현재자본인하율(%) - 기준일자 기준가에서 최대 기준가(양수)를 뺀 값을 기준일자 기준가로 나눈 값(상세 사용)

    @Column(name = "max_drawdown_amount", nullable = false, precision = 25, scale = 10)
    private BigDecimal maxDrawdownAmount; // 최대자본인하금액 - 현재 자본인하금액의 최저값, 음수(상세사용)

    @Column(name = "max_drawdown_rate", nullable = false, precision = 25, scale = 10)
    private BigDecimal maxDrawdownRate; // 최대자본인하율(%) - 현재 자본 인하율의 최저값, 음수(상세사용)

    @Column(name = "win_rate", nullable = false, precision = 25, scale = 10)
    private BigDecimal winRate; // 승률 - 이익일수 / 거래일수(상세 사용)

    @Column(name = "profit_factor", nullable = false, precision = 25, scale = 10)
    private BigDecimal profitFactor; // Profit Factor - 총손실이 음수인 경우 총이익/총손실(절대값), 총손실이 양수인 경우 0(상세 사용)

    @Column(name = "roa", nullable = false, precision = 25, scale = 10)
    private BigDecimal roa; // ROA - 누적손익금액 / 최대자본인하금액 * -1, 최대 자본인하금액이 0이거나 없으면 값은 0(상세 사용)

    @Column(name = "average_profit_loss_ratio", nullable = false, precision = 25, scale = 10)
    private BigDecimal averageProfitLossRatio; // 평균손익비 - 평균이익 / 평균손실(절대값)

    @Column(name = "coefficient_of_variation", nullable = false, precision = 25, scale = 10)
    private BigDecimal coefficientOfVariation; // 변동계수 - 기준일까지의 일손익 표준편차 / 기준일 평균손익 * 100

    @Column(name = "sharp_ratio", nullable = false, precision = 25, scale = 10)
    private BigDecimal sharpRatio; // Sharp Ratio - 평균 손익 / 기준일까지의 일손익 표준 편차

    @Column(name = "current_consecutive_pl_days", nullable = false)
    private Integer currentConsecutivePlDays; // 현재 연속 손익일수

    @Column(name = "max_consecutive_profit_days", nullable = false)
    private Integer maxConsecutiveProfitDays; // 최대 연속 수익일수

    @Column(name = "max_consecutive_loss_days", nullable = false)
    private Integer maxConsecutiveLossDays; // 최대 연속 손실일수

    @Column(name = "recent_one_year_return", nullable = false, precision = 25, scale = 10)
    private BigDecimal recentOneYearReturn; // 최근 1년 수익률

    @Column(name = "strategy_operation_days", nullable = false)
    private Integer strategyOperationDays; // 총전략운용일수

    @Column(name = "daily_statistics_status_code", nullable = false, precision = 10, scale = 4)
    private String dailyStatisticsStatusCode; // 일간 통계 상태코드

    @Column(name = "dd_day", nullable = false)
    private Integer ddDay; // DD 기간

    @Column(name = "max_dd_in_rate", nullable = false)
    private BigDecimal maxDDInRate; // DD기간 내 최대 자본인하율

    @Column(name = "change_start_date", nullable = false)
    private LocalDateTime changeStartDate; // 변경시작일시

    @Column(name = "change_end_date", nullable = true)
    private LocalDateTime changeEndDate; // 변경종료일시
}