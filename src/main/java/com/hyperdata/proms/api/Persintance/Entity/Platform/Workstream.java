package com.hyperdata.proms.api.Persintance.Entity.Platform;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.hyperdata.proms.api.Persintance.Entity.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table (name = "workstreams", schema = "proms")
@Getter 
@Setter 
@NoArgsConstructor 
public class Workstream extends AuditableEntity{
     @Column(name = "tenant_id", nullable = false, updatable = false)
    private UUID tenantId;
 
    @Column(name = "board_id", nullable = false, updatable = false)
    private UUID boardId;
 
    @Column(name = "name", columnDefinition = "text", nullable = false)
    private String name;
 
    /** FK ke platform.teams */
    @Column(name = "team_id")
    private UUID teamId;
 
    /** FK ke platform.users */
    @Column(name = "lead_id")
    private UUID leadId;
 
    @Column(name = "color", columnDefinition = "text")
    private String color;
 
    /** FK ke proms.workflow_templates */
    @Column(name = "template_id")
    private UUID templateId;
 
    @JdbcTypeCode (SqlTypes.JSON)
    @Column(name = "custom_fields", columnDefinition = "jsonb", nullable = false)
    private String customFields = "[]";
 
    @Column(name = "position", nullable = false)
    private Integer position = 0;
 
    @Column(name = "deleted_at")
    private Instant deletedAt;
 
    @Column(name = "deleted_by")
    private UUID deletedBy;
}
