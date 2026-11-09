package com.hyperdata.proms.api.Persintance.Repository.Platform;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hyperdata.proms.api.Persintance.Entity.Platform.WorkLocation;

public interface MemberGroupRepository extends JpaRepository<WorkLocation, UUID>{
    List<WorkLocation> findByTenantIdAndDeletedAtIsNullOrderByPositionAscNameAsc(UUID tenantId);
 
    Optional<WorkLocation> findByIdAndTenantIdAndDeletedAtIsNull(UUID id, UUID tenantId);
 
    boolean existsByTenantIdAndNameIgnoreCaseAndDeletedAtIsNull(UUID tenantId, String name);
 
    boolean existsByTenantIdAndNameIgnoreCaseAndDeletedAtIsNullAndIdNot(UUID tenantId, String name, UUID id);
 
    /** Posisi terbesar saat ini (-1 bila kosong), untuk menentukan posisi item baru. */
    @Query("select coalesce(max(e.position), -1) from WorkLocation e where e.tenantId = :tenantId and e.deletedAt is null")
    Integer findMaxPosition(@Param("tenantId") UUID tenantId);
}
