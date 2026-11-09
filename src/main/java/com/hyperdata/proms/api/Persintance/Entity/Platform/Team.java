package com.hyperdata.proms.api.Persintance.Entity.Platform;

import java.time.Instant;

import com.hyperdata.proms.api.Persintance.Entity.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table (name = "teams", schema = "platform")
@Getter 
@Setter 
@NoArgsConstructor 
public class Team extends AuditableEntity{
    @Column (name = "tenant_id")
    private String tenantId;

    @Column (name = "name")
    private String name;

    @Column (name = "deleted_at")
    private Instant deleteAt;

    @Column (name = "deactivated_at")
    private Instant deactivatedAt;

    @Column (name = "deactivated_by")
    private Instant deactivatedBy;
}
