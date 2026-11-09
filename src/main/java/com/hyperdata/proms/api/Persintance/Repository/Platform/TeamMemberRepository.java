package com.hyperdata.proms.api.Persintance.Repository.Platform;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyperdata.proms.api.Persintance.Entity.Platform.TeamMember;
import com.hyperdata.proms.api.Persintance.Entity.Platform.TeamMemberId;

public interface TeamMemberRepository extends JpaRepository<TeamMember, TeamMemberId>{
    List<TeamMember> findById_TeamId(UUID teamId);
    
    List<TeamMember> findById_UserId(UUID userId);
 
    long countById_TeamId(UUID teamId);
 
    long deleteById_TeamId(UUID teamId);
}
