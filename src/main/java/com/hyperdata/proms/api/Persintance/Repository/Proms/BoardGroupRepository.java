package com.hyperdata.proms.api.Persintance.Repository.Proms;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hyperdata.proms.api.Persintance.Entity.Proms.BoardGroup;

public interface BoardGroupRepository extends JpaRepository<BoardGroup, UUID>{
    List<BoardGroup> findByTenantIdAndDeletedAtIsNullOrderByPositionAscNameAsc(UUID tenantId);
 
    Optional<BoardGroup> findByIdAndTenantIdAndDeletedAtIsNull(UUID id, UUID tenantId);
 
    boolean existsByTenantIdAndNameIgnoreCaseAndDeletedAtIsNull(UUID tenantId, String name);
 
    boolean existsByTenantIdAndNameIgnoreCaseAndDeletedAtIsNullAndIdNot(UUID tenantId, String name, UUID id);
 
    @Query("select coalesce(max(g.position), -1) from BoardGroup g where g.tenantId = :tenantId and g.deletedAt is null")
    Integer findMaxPosition(@Param("tenantId") UUID tenantId);
}
