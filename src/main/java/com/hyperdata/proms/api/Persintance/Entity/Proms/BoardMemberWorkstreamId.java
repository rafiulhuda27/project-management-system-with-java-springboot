package com.hyperdata.proms.api.Persintance.Entity.Proms;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BoardMemberWorkstreamId implements Serializable {

    @Column(name = "board_member_id", nullable = false)
    private UUID boardMemberId;

    @Column(name = "workstream_id", nullable = false)
    private UUID workstreamId;
}