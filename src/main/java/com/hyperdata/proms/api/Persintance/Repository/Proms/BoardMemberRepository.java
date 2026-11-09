package com.hyperdata.proms.api.Persintance.Repository.Proms;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyperdata.proms.api.Persintance.Entity.Proms.BoardMember;

public interface BoardMemberRepository extends JpaRepository<BoardMember, UUID>{
    List<BoardMember> findByBoardIdAndTenantId(UUID boardId, UUID tenantId);
 
    Optional<BoardMember> findByBoardIdAndUserId(UUID boardId, UUID userId);
 
    boolean existsByBoardIdAndUserId(UUID boardId, UUID userId);
 
    /** Keanggotaan seorang user di semua board dalam tenant (untuk hak akses). */
    List<BoardMember> findByUserIdAndTenantId(UUID userId, UUID tenantId);
 
    /** Owner board (maksimal satu, dijaga unique index board_members_one_owner). */
    Optional<BoardMember> findByBoardIdAndOwnerTrue(UUID boardId);
 
    long deleteByBoardIdAndUserId(UUID boardId, UUID userId);
}
