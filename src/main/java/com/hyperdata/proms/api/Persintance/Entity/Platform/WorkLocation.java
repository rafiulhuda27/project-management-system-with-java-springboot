package com.hyperdata.proms.api.Persintance.Entity.Platform;

import java.time.Instant;
import java.util.UUID;

import com.hyperdata.proms.api.Persintance.Entity.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity 
@Table (name = "work_locations", schema = "platform")
@Getter 
@Setter 
@NoArgsConstructor 
public class WorkLocation extends AuditableEntity{
    @Column(name = "tenant_id", nullable = false, updatable = false)
    private UUID tenantId;
 
    @Column(name = "name", columnDefinition = "text", nullable = false)
    private String name;
 
    @Column(name = "position", nullable = false)
    private Integer position = 0;
 
    @Column(name = "deleted_at")
    private Instant deletedAt;
 
    @Column(name = "deleted_by")
    private UUID deletedBy;
}
