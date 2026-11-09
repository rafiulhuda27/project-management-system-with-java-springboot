package com.hyperdata.proms.api.Persintance.Repository.Proms;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyperdata.proms.api.Persintance.Entity.Proms.MilestoneWorkstream;
import com.hyperdata.proms.api.Persintance.Entity.Proms.MilestoneWorkstreamId;

public interface MilestoneWorkstreamRepository extends JpaRepository<MilestoneWorkstream, MilestoneWorkstreamId>{
    List<MilestoneWorkstream> findById_MilestoneId(UUID milestoneId);
    List<MilestoneWorkstream> findById_workstreamId(UUID workstreamId);
    long deleteById_milestoneId(UUID milestoneId);
    long deleteById_workstreamId(UUID worsktreamId);
}
