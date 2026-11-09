package com.hyperdata.proms.api.Persintance.Entity.Proms;

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
@Table (name = "board_columns", schema = "proms")
@Getter 
@Setter 
@NoArgsConstructor 
public class BoardColumn extends AuditableEntity{
    @Column (name = "tenand_id")
    private UUID tenandId;

    @Column (name = "board_id")
    private String boardId;

    @Column(name = "workstream_id")
    private UUID workstreamId;

    @Column(name = "name")
    private String name;
 
    /** not_started | in_progress | blocked | done  (lihat DomainConstant.ColumnCategory) */
    @Column(name = "category")
    private String category;
 
    @Column(name = "color")
    private String color;
 
    /** Batas WIP, harus > 0 bila diisi. */
    @Column(name = "wip_limit")
    private Integer wipLimit;
 
    /** Fractional index (string), diurutkan secara leksikografis. */
    @Column(name = "position")
    private String position;
 
    @Column(name = "deleted_at")
    private Instant deletedAt;
}
