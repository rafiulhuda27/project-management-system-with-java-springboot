package com.hyperdata.proms.api.Persintance.Repository.Proms;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hyperdata.proms.api.Persintance.Entity.Proms.Milestone;

public interface MilestoneRepository extends JpaRepository<Milestone, UUID>{
    List<Milestone> findByBoardIdAndTenantIdAndDeletedAtIsNullOrderByPositionAscTargetDateAsc(UUID boardId, UUID tenantId);
 
    Optional<Milestone> findByIdAndTenantIdAndDeletedAtIsNull(UUID id, UUID tenantId);
 
    @Query("select coalesce(max(m.position), -1) from Milestone m where m.boardId = :boardId and m.deletedAt is null")
    Integer findMaxPosition(@Param("boardId") UUID boardId);
}
