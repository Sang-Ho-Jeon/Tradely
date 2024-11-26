package com.sysmatic2.finalbe.strategy.repository;

import com.sysmatic2.finalbe.strategy.entity.DailyStatisticsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DailyStatisticsRepository extends JpaRepository<DailyStatisticsEntity, Long> {

    /**
     * 특정 전략에서 가장 최근의 일일 통계 데이터 1개를 조회합니다.
     *
     * @param strategyId 조회할 전략의 ID
     * @param pageable   페이징 객체 (최신 1개의 데이터를 조회하도록 설정)
     * @return 최신 일일 통계 데이터 리스트 (크기 1)
     */
    @Query("SELECT d FROM DailyStatisticsEntity d " +
            "WHERE d.strategyEntity.strategyId = :strategyId " +
            "ORDER BY d.date DESC")
    List<DailyStatisticsEntity> findLatestByStrategyId(@Param("strategyId") Long strategyId, Pageable pageable);

    /**
     * 특정 전략의 일손익(dailyProfitLoss) 데이터를 날짜 오름차순으로 조회합니다.
     *
     * @param strategyId 조회할 전략의 ID
     * @return 일손익 데이터 리스트 (날짜 오름차순으로 정렬)
     */
    @Query("SELECT d.dailyProfitLoss FROM DailyStatisticsEntity d " +
            "WHERE d.strategyEntity.strategyId = :strategyId " +
            "ORDER BY d.date ASC")
    List<BigDecimal> findDailyProfitLossesByStrategyId(@Param("strategyId") Long strategyId);

    /**
     * 특정 전략의 최근 1년 전 날짜 기준으로 가장 가까운 잔고(balance)를 조회합니다.
     *
     * @param strategyId 조회할 전략의 ID
     * @param oneYearAgo 1년 전 기준 날짜
     * @return 최근 1년 전의 잔고 (Optional로 반환)
     */
    @Query("SELECT d.balance FROM DailyStatisticsEntity d " +
            "WHERE d.strategyEntity.strategyId = :strategyId " +
            "AND d.date <= :oneYearAgo " +
            "ORDER BY d.date DESC")
    Optional<BigDecimal> findBalanceOneYearAgo(@Param("strategyId") Long strategyId, @Param("oneYearAgo") LocalDate oneYearAgo);

    /**
     * 특정 전략의 모든 기준가(referencePrice)를 날짜 오름차순으로 조회합니다.
     *
     * @param strategyId 조회할 전략의 ID
     * @return 기준가 목록 (날짜 오름차순으로 정렬)
     */
    @Query("SELECT ds.referencePrice FROM DailyStatisticsEntity ds WHERE ds.strategyEntity.strategyId = :strategyId ORDER BY ds.date ASC")
    List<BigDecimal> findAllReferencePricesByStrategyId(@Param("strategyId") Long strategyId);

    /**
     * 특정 전략의 모든 입출금 내역(depWdPrice)을 날짜 오름차순으로 조회합니다.
     *
     * @param strategyId 조회할 전략의 ID
     * @return 입출금 내역 목록 (날짜 오름차순으로 정렬)
     */
    @Query("SELECT ds.depWdPrice FROM DailyStatisticsEntity ds WHERE ds.strategyEntity.strategyId = :strategyId ORDER BY ds.date ASC")
    List<BigDecimal> findDepWdHistoryByStrategyId(@Param("strategyId") Long strategyId);

    /**
     * 특정 전략의 모든 일 손익률 리스트 조회.
     * @param strategyId 전략 ID
     * @return 오늘까지의 모든 일 손익률 리스트 (등록된 순서대로 정렬)
     */
    @Query("SELECT d.dailyPlRate FROM DailyStatisticsEntity d " +
            "WHERE d.strategyEntity.strategyId = :strategyId " +
            "ORDER BY d.date ASC")
    List<BigDecimal> findDailyPlRatesByStrategyId(@Param("strategyId") Long strategyId);

    /**
     * 특정 전략 ID와 날짜에 해당하는 데이터가 존재하는지 확인합니다.
     *
     * @param strategyId 전략 ID
     * @param date       확인할 날짜
     * @return 해당 날짜와 전략 ID에 해당하는 데이터가 존재하면 true, 없으면 false
     */
    @Query("SELECT COUNT(ds) > 0 FROM DailyStatisticsEntity ds WHERE ds.strategyEntity.strategyId = :strategyId AND ds.date = :date")
    boolean existsByStrategyIdAndDate(@Param("strategyId") Long strategyId, @Param("date") LocalDate date);

    /**
     * 특정 전략의 누적손익 리스트를 조회합니다.
     *
     * @param strategyId 전략 ID
     * @return 누적손익(BigDecimal) 리스트 (날짜 오름차순 정렬)
     */
    @Query("SELECT ds.cumulativeProfitLoss FROM DailyStatisticsEntity ds WHERE ds.strategyEntity.strategyId = :strategyId ORDER BY ds.date ASC")
    List<BigDecimal> findCumulativeProfitLossByStrategyId(@Param("strategyId") Long strategyId);

    /**
     * 특정 전략의 누적손익률 리스트를 조회합니다.
     *
     * @param strategyId 전략 ID
     * @return 누적손익률(BigDecimal) 리스트 (날짜 오름차순 정렬)
     */
    @Query("SELECT ds.cumulativeProfitLossRate FROM DailyStatisticsEntity ds WHERE ds.strategyEntity.strategyId = :strategyId ORDER BY ds.date ASC")
    List<BigDecimal> findCumulativeProfitLossRateByStrategyId(@Param("strategyId") Long strategyId);

    /**
     * 특정 전략 ID에 대한 일간 통계 목록을 최신일자순으로 페이징 형태로 조회합니다.
     *
     * @param strategyId 조회할 전략의 ID
     * @param pageable   페이지 정보 (페이지 번호와 크기)
     * @return 주어진 전략 ID와 연관된 {@link DailyStatisticsEntity} 객체의 {@link Page}
     */
    Page<DailyStatisticsEntity> findByStrategyEntityStrategyIdOrderByDateDesc(Long strategyId, Pageable pageable);

    /**
     * 특정 전략 ID에 대한 전략 통계 데이터를 조회합니다.
     *
     * @param strategyId 전략 ID
     * @return 해당 전략의 가장 최신 통계 데이터 (Optional로 반환)
     */
    @Query("SELECT d FROM DailyStatisticsEntity d " +
            "WHERE d.strategyEntity.strategyId = :strategyId " +
            "ORDER BY d.date DESC")
    List<DailyStatisticsEntity> findLatestStatisticsByStrategyId(@Param("strategyId") Long strategyId, Pageable pageable);

    /**
     * 특정 전략의 일간 통계 중 가장 오래된 일자의 데이터를 조회합니다.
     *
     * @param strategyId 전략 ID
     * @return 최초 입력 일자 (Optional 반환)
     */
    @Query("SELECT MIN(d.date) FROM DailyStatisticsEntity d WHERE d.strategyEntity.strategyId = :strategyId")
    Optional<LocalDate> findEarliestDateByStrategyId(@Param("strategyId") Long strategyId);


}