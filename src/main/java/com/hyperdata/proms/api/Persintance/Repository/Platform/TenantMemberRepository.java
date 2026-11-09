package com.hyperdata.proms.api.Persintance.Repository.Platform;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hyperdata.proms.api.Persintance.Entity.Platform.Tenantmember;

/** platform.tenant_members ber-RLS: query entity di bawah ini butuh tenant context aktif. */
public interface TenantMemberRepository extends JpaRepository<Tenantmember, UUID> {

    Optional<Tenantmember> findByTenantIdAndUserId(UUID tenantId, UUID userId);

    boolean existsByTenantIdAndUserId(UUID tenantId, UUID userId);

    List<Tenantmember> findByTenantId(UUID tenantId);

    List<Tenantmember> findByTenantIdAndStatus(UUID tenantId, String status);

    List<Tenantmember> findByTenantIdAndUserIdIn(UUID tenantId, Collection<UUID> userIds);

    /**
     * Hitung anggota internal untuk kuota max_users.
     * Pakai role IN (owner, admin, finance, member) dan status active; guest tidak dihitung.
     */
    long countByTenantIdAndStatusAndRoleIn(UUID tenantId, String status, Collection<String> roles);

    /**
     * Daftar workspace milik satu user, lewat fungsi security definer sehingga TIDAK terkena RLS.
     * Alias dikutip agar nama kolom tidak di-lowercase oleh PostgreSQL (dibutuhkan projection).
     * tenant_slug (citext) di-cast ke text supaya terbaca sebagai String.
     */
    @Query(value = """
            select m.user_id                    as "userId",
                   m.tenant_id                  as "tenantId",
                   cast(m.tenant_slug as text)  as "tenantSlug",
                   m.tenant_name                as "tenantName",
                   m.role                       as "role",
                   m.status                     as "status"
            from platform.user_memberships(array[cast(:userId as uuid)]) m
            """, nativeQuery = true)
    List<MembershipView> findMembershipsByUserId(@Param("userId") UUID userId);
}