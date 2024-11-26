package com.sysmatic2.finalbe.strategy.repository;

import com.sysmatic2.finalbe.strategy.entity.DailyStatisticsHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface DailyStatisticsHistoryRepository extends JpaRepository<DailyStatisticsHistoryEntity, Long> {
    //시작일과 종료일 사이의 엔티티 갯수 반환
    Long countByDateBetween(LocalDate startDate, LocalDate endDate);
}