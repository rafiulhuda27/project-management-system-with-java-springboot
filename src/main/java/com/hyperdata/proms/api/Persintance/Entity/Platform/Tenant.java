package com.hyperdata.proms.api.Persintance.Entity.Platform;

import java.time.Instant;

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

/** platform.tenants (workspace). Tabel ini TIDAK ber-RLS, dibaca langsung saat resolve tenant. */
@Entity
@Table(name = "tenants", schema = "platform")
@Getter
@Setter
@NoArgsConstructor
public class Tenant extends AuditableEntity {

    @Column(name = "name", columnDefinition = "text", nullable = false)
    private String name;

    @Column(name = "slug", columnDefinition = "citext", nullable = false)
    private String slug;

    @Column(name = "status", columnDefinition = "text", nullable = false)
    private String status = DomainConstant.TenantStatus.TRIAL;

    @Column(name = "timezone", columnDefinition = "text", nullable = false)
    private String timezone = "Asia/Jakarta";

    /** JSON (jsonb) disimpan sebagai teks JSON; parse dengan ObjectMapper di service/DTO. */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "branding", columnDefinition = "jsonb", nullable = false)
    private String branding = "{}";

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "settings", columnDefinition = "jsonb", nullable = false)
    private String settings = "{}";

    @Column(name = "trial_ends_at")
    private Instant trialEndsAt;

    @Column(name = "max_boards")
    private Integer maxBoards;

    @Column(name = "max_users")
    private Integer maxUsers;
}