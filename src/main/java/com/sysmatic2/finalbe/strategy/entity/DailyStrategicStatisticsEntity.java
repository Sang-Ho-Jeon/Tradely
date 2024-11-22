package com.sysmatic2.finalbe.strategy.entity;

import com.sysmatic2.finalbe.common.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "daily_strategic_statistics")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DailyStrategicStatisticsEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "daily_strategic_statistics_id", nullable = false)
    private Long dailyStrategicStatisticsId; // 전략 일간 통계 ID

    @ManyToOne
    @JoinColumn(name = "strategy_id", nullable = false)
    private StrategyEntity strategyId; // 전략 FK

    @Column(name = "date", nullable = false)
    private LocalDate date; // 일자

    @Column(name = "daily_profit_loss", nullable = false, precision = 19, scale = 4)
    private BigDecimal dailyProfitLoss; // 일손익

    @Column(name = "dep_wd_price", nullable = false, precision = 19, scale = 4)
    private BigDecimal depWdPrice; // 입출금

    @Column(name = "trading_days", nullable = false)
    private Integer tradingDays; // 거래일수

    @Column(name = "principal", nullable = false, precision = 19, scale = 4)
    private BigDecimal principal; // 원금

    @Column(name = "balance", nullable = false, precision = 19, scale = 4)
    private BigDecimal balance; // 잔고

    @Column(name = "unrealized_profit_loss", nullable = false, precision = 19, scale = 4)
    private BigDecimal unrealizedProfitLoss; // 평가손익

    @Column(name = "kp_ratio", nullable = true, precision = 19, scale = 4)
    private BigDecimal kpRatio; // KP-Ratio

    @Column(name = "sm_score", nullable = true, precision = 10, scale = 2)
    private BigDecimal smScore; // SM-Score

    @Column(name = "reference_price", nullable = false, precision = 19, scale = 4)
    private BigDecimal referencePrice; // 기준가

    @Column(name = "cumulative_dep_wd_price", nullable = false, precision = 19, scale = 4)
    private BigDecimal cumulativeDepWdPrice; // 누적입출금액

    @Column(name = "deposit_amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal depositAmount; // 입금

    @Column(name = "cumulative_deposit_amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal cumulativeDepositAmount; // 누적입금

    @Column(name = "withdraw_amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal withdrawAmount; // 출금

    @Column(name = "cumulative_withdraw_amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal cumulativeWithdrawAmount; // 누적출금

    @Column(name = "daily_pl_rate", nullable = false, precision = 10, scale = 4)
    private BigDecimal dailyPlRate; // 일손익률

    @Column(name = "max_daily_profit", precision = 19, scale = 4)
    private BigDecimal maxDailyProfit; // 최대일이익

    @Column(name = "max_daily_profit_rate", precision = 10, scale = 4)
    private BigDecimal maxDailyProfitRate; // 최대일이익률(%)

    @Column(name = "max_daily_loss", precision = 19, scale = 4)
    private BigDecimal maxDailyLoss; // 최대일손실

    @Column(name = "max_daily_loss_rate", precision = 10, scale = 4)
    private BigDecimal maxDailyLossRate; // 최대일손실률(%)

    @Column(name = "total_profit", precision = 19, scale = 4)
    private BigDecimal totalProfit; // 총이익

    @Column(name = "total_profit_days")
    private Integer totalProfitDays; // 총이익일수

    @Column(name = "average_profit", precision = 19, scale = 4)
    private BigDecimal averageProfit; // 평균이익

    @Column(name = "total_loss", precision = 19, scale = 4)
    private BigDecimal totalLoss; // 총손실

    @Column(name = "total_loss_days")
    private Integer totalLossDays; // 총손실일수

    @Column(name = "average_loss", precision = 19, scale = 4)
    private BigDecimal averageLoss; // 평균손실

    @Column(name = "cumulative_profit_loss", precision = 19, scale = 4)
    private BigDecimal cumulativeProfitLoss; // 누적손익

    @Column(name = "cumulative_profit_loss_rate", precision = 10, scale = 4)
    private BigDecimal cumulativeProfitLossRate; // 누적손익률(%)

    @Column(name = "max_cumulative_profit_loss", precision = 19, scale = 4)
    private BigDecimal maxCumulativeProfitLoss; // 최대누적손익

    @Column(name = "max_cumulative_profit_loss_rate", precision = 10, scale = 4)
    private BigDecimal maxCumulativeProfitLossRate; // 최대누적손익률(%)

    @Column(name = "average_profit_loss", precision = 19, scale = 4)
    private BigDecimal averageProfitLoss; // 평균손익

    @Column(name = "average_profit_loss_rate", precision = 10, scale = 4)
    private BigDecimal averageProfitLossRate; // 평균손익률(%)

    @Column(name = "peak", precision = 19, scale = 4)
    private BigDecimal peak; // Peak

    @Column(name = "peak_rate", precision = 10, scale = 4)
    private BigDecimal peakRate; // Peak(%)

    @Column(name = "days_since_peak")
    private Integer daysSincePeak; // 고점후경과일

    @Column(name = "current_drawdown_amount", precision = 19, scale = 4)
    private BigDecimal currentDrawdownAmount; // 현재자본인하금액

    @Column(name = "current_drawdown_rate", precision = 10, scale = 4)
    private BigDecimal currentDrawdownRate; // 현재자본인하율(%)

    @Column(name = "max_drawdown_amount", precision = 19, scale = 4)
    private BigDecimal maxDrawdownAmount; // 최대자본인하금액

    @Column(name = "max_drawdown_rate", precision = 10, scale = 4)
    private BigDecimal maxDrawdownRate; // 최대자본인하율(%)

    @Column(name = "win_rate", precision = 10, scale = 4)
    private BigDecimal winRate; // 승률

    @Column(name = "profit_factor", precision = 10, scale = 4)
    private BigDecimal profitFactor; // Profit Factor

    @Column(name = "roa", precision = 10, scale = 4)
    private BigDecimal roa; // ROA

    @Column(name = "average_profit_loss_ratio", precision = 10, scale = 4)
    private BigDecimal averageProfitLossRatio; // 평균손익비

    @Column(name = "coefficient_of_variation", precision = 10, scale = 4)
    private BigDecimal coefficientOfVariation; // 변동계수

    @Column(name = "sharp_ratio", precision = 10, scale = 4)
    private BigDecimal sharpRatio; // Sharp Ratio

    @Column(name = "current_consecutive_pl_days")
    private Integer currentConsecutivePlDays; // 현재 연속 손익일수

    @Column(name = "max_consecutive_profit_days")
    private Integer maxConsecutiveProfitDays; // 최대 연속 수익일수

    @Column(name = "max_consecutive_loss_days")
    private Integer maxConsecutiveLossDays; // 최대 연속 손실일수

    @Column(name = "recent_one_year_return", precision = 10, scale = 4)
    private BigDecimal recentOneYearReturn; // 최근 1년 수익률

    @Column(name = "strategy_operation_days", nullable = false)
    private Integer strategyOperationDays; // 총전략운용일수
}