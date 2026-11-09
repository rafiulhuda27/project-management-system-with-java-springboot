package com.hyperdata.proms.api.Persintance.Repository.Platform;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyperdata.proms.api.Persintance.Entity.Platform.Tenant;

public interface  TenantRepository extends JpaRepository<Tenant, UUID>{
    Optional<Tenant> findBySlugIgnoreCase(String Slug);
    boolean existsBySlugIgnoreCase(String Slug);
}
