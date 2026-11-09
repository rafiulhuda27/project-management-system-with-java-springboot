package com.hyperdata.proms.api.Persintance.Repository.Proms;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyperdata.proms.api.Persintance.Entity.Proms.BoardMemberWorkstream;
import com.hyperdata.proms.api.Persintance.Entity.Proms.BoardMemberWorkstreamId;

public interface BoardMemberWorkstreamRepository extends JpaRepository<BoardMemberWorkstream, BoardMemberWorkstreamId>{
    List<BoardMemberWorkstream> findById_BoardMemberId(UUID boardMemberId);
 
    List<BoardMemberWorkstream> findById_WorkstreamId(UUID workstreamId);
 
    long deleteById_BoardMemberId(UUID boardMemberId);
 
    /** Dipanggil saat workstream di-soft-delete (FK cascade hanya berlaku untuk hard delete). */
    long deleteById_WorkstreamId(UUID workstreamId);
}
