package com.hyperdata.proms.api.Persintance.Entity.Platform;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** platform.team_members, PK komposit (team_id, user_id), tanpa updated_at. */
@Entity
@Table(name = "team_members", schema = "platform")
@Getter
@Setter
@NoArgsConstructor
public class TeamMember {

    @EmbeddedId
    private TeamMemberId id;

    @Column(name = "tenant_id", nullable = false, updatable = false)
    private UUID tenantId;

    @Column(name = "is_lead", nullable = false)
    private boolean lead = false;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;
}