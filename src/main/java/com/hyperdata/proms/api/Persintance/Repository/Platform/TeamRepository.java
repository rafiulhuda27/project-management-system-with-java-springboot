package com.hyperdata.proms.api.Persintance.Repository.Platform;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyperdata.proms.api.Persintance.Entity.Platform.Team;

public interface TeamRepository extends JpaRepository<Team, UUID>{
    List<Team> findByTenantIdAndDeletedAtIsNullOrderByNameAsc(UUID tenantId);
 
    Optional<Team> findByIdAndTenantIdAndDeletedAtIsNull(UUID id, UUID tenantId);
 
    /** Nama tim unik per tenant (case-insensitive) di antara yang belum dihapus. */
    boolean existsByTenantIdAndNameIgnoreCaseAndDeletedAtIsNull(UUID tenantId, String name);
 
    /** Versi untuk rename: abaikan tim itu sendiri. */
    boolean existsByTenantIdAndNameIgnoreCaseAndDeletedAtIsNullAndIdNot(UUID tenantId, String name, UUID id);
}