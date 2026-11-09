package com.hyperdata.proms.api.Persintance.Repository.Platform;

import java.util.UUID;

public interface MembershipView {
    UUID getUserId();
    UUID getTenantId();
    String getTenantSlug();
    String getTenantName();
    String getRole();
    String getStatus();
}
