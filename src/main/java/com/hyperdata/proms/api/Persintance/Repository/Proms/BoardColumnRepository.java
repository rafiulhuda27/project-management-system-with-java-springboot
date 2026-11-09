package com.hyperdata.proms.api.Persintance.Repository.Proms;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hyperdata.proms.api.Persintance.Entity.Proms.BoardColumn;

public interface BoardColumnRepository extends JpaRepository<BoardColumn, UUID>{
    Optional<BoardColumn> findByIdAndTenantIdAndDeletedAtIsNull(UUID id, UUID tenantId);
 
    /** Semua kolom aktif sebuah board (kolom bersama + kolom per-workstream). */
    @Query("""
            select c from BoardColumn c
            where c.tenantId = :tenantId and c.boardId = :boardId and c.deletedAt is null
            order by c.position asc 
            """)
    List<BoardColumn> findActiveByBoard(@Param("tenantId") UUID tenantId, @Param("boardId") UUID boardId);
 
    /** Kolom bersama (workstream_id null), dipakai saat board.shared_columns = true. */
    @Query("""
            select c from BoardColumn c
            where c.tenantId = :tenantId and c.boardId = :boardId
              and c.workstreamId is null and c.deletedAt is null
            order by c.position asc
            """)
    List<BoardColumn> findSharedByBoard(@Param("tenantId") UUID tenantId, @Param("boardId") UUID boardId);
 
    /** Kolom milik satu workstream. */
    @Query("""
            select c from BoardColumn c
            where c.tenantId = :tenantId and c.boardId = :boardId
              and c.workstreamId = :workstreamId and c.deletedAt is null
            order by c.position asc
            """)
    List<BoardColumn> findByWorkstream(@Param("tenantId") UUID tenantId,
                                       @Param("boardId") UUID boardId,
                                       @Param("workstreamId") UUID workstreamId);
}
