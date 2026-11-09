package com.hyperdata.proms.api.Persintance.Entity.Proms;

import java.time.Instant;

import com.hyperdata.proms.api.Persintance.Entity.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table (name = "boards_groups", schema = "proms")
@Getter 
@Setter 
@NoArgsConstructor 
public class BoardGroup extends AuditableEntity{
    @Column (name = "tenand_id")
    private String tenandId;

    @Column (name = "name")
    private String name;

    @Column (name = "position")
    private Integer position = 0;

    @Column (name = "deleted_at")
    private Instant deletedAt;

    @Column (name ="deleted_by")
    private Instant deletedBy;
}
