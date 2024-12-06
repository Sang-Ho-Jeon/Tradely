package com.sysmatic2.finalbe.strategy.repository;

import com.sysmatic2.finalbe.member.entity.MemberEntity;
import com.sysmatic2.finalbe.strategy.entity.StrategyEntity;
import com.sysmatic2.finalbe.strategy.entity.StrategyReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StrategyReviewRepository extends JpaRepository<StrategyReviewEntity, Long> {
    Page<StrategyReviewEntity> findAllByStrategyOrderByWritedAtDesc(StrategyEntity strategy, Pageable pageable);
    List<StrategyReviewEntity> findAllByStrategy(StrategyEntity strategy);
    void deleteAllByStrategy(StrategyEntity strategy);
    void deleteAllByWriterId(MemberEntity writer);

    @Query("SELECT r FROM StrategyReviewEntity r WHERE r.strategy.strategyId = :strategyId AND r.strategyReviewId = :reviewId")
    Optional<StrategyReviewEntity> findByIdAndStrategyId(@Param("strategyId") Long strategyId, @Param("reviewId") Long reviewId);
}
