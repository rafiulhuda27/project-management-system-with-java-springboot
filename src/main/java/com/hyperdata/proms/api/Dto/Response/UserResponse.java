package com.hyperdata.proms.api.Dto.Response;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hyperdata.proms.api.Persintance.Entity.User;

public record UserResponse(
    UUID id,
    String email,
    @JsonProperty ("full_name") String fullName,
    @JsonProperty ("avatar_url") String avatarUrl,
    String locale,
    String timezone,
    @JsonProperty ("is_platform_staff") boolean isPlatformStaff,
    @JsonProperty ("platform_role") String PlatformRole
) {
    public static UserResponse from(User u) {
        return new UserResponse(
            u.getId(), u.getEmail(), 
            u.getFullName(), 
            u.getAvatarUrl(), u.getLocale(), 
            u.getTimezone(), u.getIsPlatformStaff(), u.getPlatformRole());
    }   
}
