package com.hyperdata.proms.api.Persintance.Entity.Proms;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.DynamicUpdate;

import com.hyperdata.proms.api.Constant.DomainConstant;
import com.hyperdata.proms.api.Persintance.Entity.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** proms.milestones. health/progress dihitung di luar entity, maka @DynamicUpdate. */
@Entity
@Table(name = "milestones", schema = "proms")
@DynamicUpdate
@Getter
@Setter
@NoArgsConstructor
public class Milestone extends AuditableEntity {

    @Column(name = "tenant_id", nullable = false, updatable = false)
    private UUID tenantId;

    @Column(name = "board_id", nullable = false, updatable = false)
    private UUID boardId;

    @Column(name = "name", columnDefinition = "text", nullable = false)
    private String name;

    @Column(name = "target_date", nullable = false)
    private LocalDate targetDate;

    /** open | completed */
    @Column(name = "status", columnDefinition = "text", nullable = false)
    private String status = DomainConstant.MilestoneStatus.OPEN;

    @Column(name = "completed_at")
    private Instant completedAt;

    /** no_tasks | on_track | at_risk | off_track | done */
    @Column(name = "health", columnDefinition = "text")
    private String health;

    @Column(name = "progress_pct")
    private Short progressPct;

    @Column(name = "health_computed_at")
    private Instant healthComputedAt;

    @Column(name = "position", nullable = false)
    private Integer position = 0;

    @Column(name = "created_by")
    private UUID createdBy;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @Column(name = "deleted_by")
    private UUID deletedBy;
}