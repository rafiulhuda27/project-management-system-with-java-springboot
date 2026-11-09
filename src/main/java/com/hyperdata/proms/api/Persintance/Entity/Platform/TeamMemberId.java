package com.hyperdata.proms.api.Persintance.Entity.Platform;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@EqualsAndHashCode 
public class TeamMemberId implements Serializable{
    @Column (name = "team_id")
    private UUID teamId;

    @Column (name = "user_id")
    private UUID userId;
}
