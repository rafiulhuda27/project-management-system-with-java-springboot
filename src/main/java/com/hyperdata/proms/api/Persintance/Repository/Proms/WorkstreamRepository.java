package com.hyperdata.proms.api.Persintance.Repository.Proms;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hyperdata.proms.api.Persintance.Entity.Platform.Workstream;

public interface WorkstreamRepository extends JpaRepository<Workstream, UUID>{
    List<Workstream> findByBoardIdAndTenantIdAndDeletedAtIsNullOrderByPositionAsc(UUID boardId, UUID tenantId);
 
    Optional<Workstream> findByIdAndTenantIdAndDeletedAtIsNull(UUID id, UUID tenantId);
 
    /** Nama workstream unik per board (case-insensitive) di antara yang belum dihapus. */
    boolean existsByBoardIdAndNameIgnoreCaseAndDeletedAtIsNull(UUID boardId, String name);
 
    boolean existsByBoardIdAndNameIgnoreCaseAndDeletedAtIsNullAndIdNot(UUID boardId, String name, UUID id);
 
    @Query("select coalesce(max(w.position), -1) from Workstream w where w.boardId = :boardId and w.deletedAt is null")
    Integer findMaxPosition(@Param("boardId") UUID boardId);    
}
