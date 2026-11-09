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
@Table (name = "member_groups", schema = "platform")
@Getter 
@Setter
@NoArgsConstructor  
public class MemberGroup extends AuditableEntity{
    @Column (name = "tenand_id")
    private UUID tenandId;

    @Column (name = "name")
    private String name;
    
    @Column (name = "position")
    private Integer position;

    @Column (name = "deleted_at")
    private Instant deletedAt;

    @Column(name = "deleted_by")
    private Instant deletedBy;
}
