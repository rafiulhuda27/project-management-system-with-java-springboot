package com.hyperdata.proms.api.Persintance.Repository.Proms;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hyperdata.proms.api.Persintance.Entity.Proms.Board;

public interface BoardRepository extends JpaRepository<Board, UUID>{
    Optional<Board> findByIdAndTenantIdAndDeletedAtIsNull(UUID id, UUID tenantId);
 
    Optional<Board> findByTenantIdAndBoardKeyAndDeletedAtIsNull(UUID tenantId, String boardKey);
 
    /**
     * BR-TK-02: key unik per tenant TERMASUK board di Trash (unique index DB tidak
     * mengecualikan deleted_at), jadi sengaja TIDAK memfilter deletedAt.
     */
    boolean existsByTenantIdAndBoardKey(UUID tenantId, String boardKey);
 
    /** Kuota max_boards: semua board yang belum dihapus (termasuk yang diarsipkan). */
    long countByTenantIdAndDeletedAtIsNull(UUID tenantId);
 
    /** Semua board milik user, termasuk yang diarsipkan (tab tidak diisi). */
    @Query("""
            select b from Board b
            where b.tenantId = :tenantId and b.deletedAt is null
              and exists (select 1 from BoardMember bm
                          where bm.boardId = b.id and bm.userId = :userId)
            """)
    Page<Board> findAllByMember(@Param("tenantId") UUID tenantId, @Param("userId") UUID userId, Pageable pageable);
 
    /** Tab "all": board aktif (belum diarsipkan). */
    @Query("""
            select b from Board b
            where b.tenantId = :tenantId and b.deletedAt is null and b.archivedAt is null
              and exists (select 1 from BoardMember bm
                          where bm.boardId = b.id and bm.userId = :userId)
            """)
    Page<Board> findActiveByMember(@Param("tenantId") UUID tenantId, @Param("userId") UUID userId, Pageable pageable);
 
    /** Tab "mine": aktif, user adalah owner atau admin board. */
    @Query("""
            select b from Board b
            where b.tenantId = :tenantId and b.deletedAt is null and b.archivedAt is null
              and exists (select 1 from BoardMember bm
                          where bm.boardId = b.id and bm.userId = :userId
                            and (bm.owner = true or bm.role = 'admin'))
            """)
    Page<Board> findMineByMember(@Param("tenantId") UUID tenantId, @Param("userId") UUID userId, Pageable pageable);
 
    /** Tab "shared": aktif, user bukan owner dan bukan admin board. */
    @Query("""
            select b from Board b
            where b.tenantId = :tenantId and b.deletedAt is null and b.archivedAt is null
              and exists (select 1 from BoardMember bm
                          where bm.boardId = b.id and bm.userId = :userId
                            and bm.owner = false and bm.role <> 'admin')
            """)
    Page<Board> findSharedByMember(@Param("tenantId") UUID tenantId, @Param("userId") UUID userId, Pageable pageable);
 
    /** Tab "archived". */
    @Query("""
            select b from Board b
            where b.tenantId = :tenantId and b.deletedAt is null and b.archivedAt is not null
              and exists (select 1 from BoardMember bm
                          where bm.boardId = b.id and bm.userId = :userId)
            """)
    Page<Board> findArchivedByMember(@Param("tenantId") UUID tenantId, @Param("userId") UUID userId, Pageable pageable);
    
}
