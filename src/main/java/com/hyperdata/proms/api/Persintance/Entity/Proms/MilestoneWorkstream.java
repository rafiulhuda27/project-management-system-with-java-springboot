package com.hyperdata.proms.api.Persintance.Entity.Proms;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** proms.milestone_workstreams: pivot milestone <-> workstream. */
@Entity
@Table(name = "milestone_workstreams", schema = "proms")
@Getter
@Setter
@NoArgsConstructor
public class MilestoneWorkstream {

    @EmbeddedId
    private MilestoneWorkstreamId id;

    @Column(name = "tenant_id", nullable = false, updatable = false)
    private UUID tenantId;
}