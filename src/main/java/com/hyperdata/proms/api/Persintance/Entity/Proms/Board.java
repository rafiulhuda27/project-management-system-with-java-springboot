package com.hyperdata.proms.api.Persintance.Entity.Proms;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.hyperdata.proms.api.Constant.DomainConstant;
import com.hyperdata.proms.api.Persintance.Entity.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity 
@Table (name = "boards", schema="proms")
@DynamicUpdate 
@Getter 
@Setter 
@NoArgsConstructor 
public class Board extends AuditableEntity{
    public static final String DEFAULT_SETTINGS_JSON =
            "{\"allCanSeeAll\":true,\"onlyPmDone\":false,\"blockedReason\":true,"
            + "\"wipBlock\":false,\"msAutoComplete\":true,\"msDraftInvoice\":true,\"msRequired\":false}";
 
    @Column(name = "tenant_id")
    private UUID tenantId;
 
    /** Kode board, 2-5 huruf kapital (^[A-Z]{2,5}$), unik per tenant. Dipakai untuk nomor task. */
    @Column(name = "\"key\"" )
    private String boardKey;
 
    @Column(name = "name" )
    private String name;
 
    @Column(name = "description")
    private String description;
 
    @Column(name = "client_name")
    private String clientName;
 
    /** Teks lama; relasi sebenarnya lewat boardGroupId. */
    @Column(name = "group_name")
    private String groupName;
 
    @Column(name = "board_group_id")
    private UUID boardGroupId;
 
    @Column(name = "owner_id")
    private UUID ownerId;
 
    @Column(name = "pm_id")
    private UUID pmId;
 
    /** active | finished | archived */
    @Column(name = "status" )
    private String status = DomainConstant.BoardStatus.ACTIVE;
 
    @Column(name = "start_date")
    private LocalDate startDate;
 
    @Column(name = "due_date")
    private LocalDate dueDate;
 
    @Column(name = "shared_columns")
    private boolean sharedColumns = true;
 
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "settings", columnDefinition = "jsonb")
    private String settings = DEFAULT_SETTINGS_JSON;
 
    /** Counter nomor task, dinaikkan oleh trigger DB. READ-ONLY dari sisi Java. */
    @Column(name = "task_seq", insertable = false)
    private Integer taskSeq;
 
    @Column(name = "health")
    private String health;
 
    @Column(name = "health_reason")
    private String healthReason;
 
    @Column(name = "progress_pct")
    private Short progressPct;
 
    @Column(name = "health_computed_at")
    private Instant healthComputedAt;
 
    @Column(name = "archived_at")
    private Instant archivedAt;
 
    @Column(name = "archived_by")
    private UUID archivedBy;
 
    @Column(name = "created_by")
    private UUID createdBy;
 
    @Column(name = "deleted_at")
    private Instant deletedAt;
 
    @Column(name = "deleted_by")
    private UUID deletedBy;
}
