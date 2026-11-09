package com.hyperdata.proms.api.Persintance.Entity.Proms;

import java.util.UUID;

import com.hyperdata.proms.api.Persintance.Entity.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table (name = "boards_member", schema = "proms")
@Getter 
@Setter 
@NoArgsConstructor 
public class BoardMember extends AuditableEntity{
    @Column (name = "tenand_id")
    private UUID tenandId;

    @Column (name = "board_id")
    private UUID boardId;

    @Column (name = "user_id")
    private UUID userId;

    @Column (name = "role")
    private String role;

    @Column (name = "is_onwer")
    private boolean owner = false;
}
