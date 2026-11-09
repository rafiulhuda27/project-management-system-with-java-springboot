package com.hyperdata.proms.api.Persintance.Entity.Platform;

import java.util.UUID;

import com.hyperdata.proms.api.Constant.DomainConstant;
import com.hyperdata.proms.api.Persintance.Entity.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table (name = "tenand_members", schema = "")
@Getter 
@Setter 
@NoArgsConstructor 
public class Tenantmember extends AuditableEntity{
    @Column (name = "tenant_id")
    private UUID tenandId;

    @Column (name = "user_id")
    private UUID userId;

    @Column (name = "role")
    private String role = DomainConstant.WorkspaceRole.MEMBER;

    @Column (name = "status")
    private String status = DomainConstant.MemberStatus.ACTIVE;

    @Column (name = "weekly_capacity_min")
    private Integer weeklyCapacityMin = 2400;

    @Column (name = "hourly_cost")
    private Long hourlyCost;

    @Column (name = "location_id")
    private UUID locationId;

    @Column (name = "member_group_id")
    private UUID memberGroupId;
}
