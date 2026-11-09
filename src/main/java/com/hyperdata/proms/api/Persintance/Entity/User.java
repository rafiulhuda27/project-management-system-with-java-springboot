package com.hyperdata.proms.api.Persintance.Entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table (name = "users", schema = "platform")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
public class User {
    @Id 
    @Column (columnDefinition = "uuid")
    private UUID id;

    @Column (name = "idp_subject", columnDefinition = "text")
    private String idpSubject;

    @Column (name = "email", columnDefinition = "citext")
    private String email;

    @Column (name = "full_name", columnDefinition = "text")
    private String fullName;

    @Column (name = "avatar_url", columnDefinition = "text")
    private String avatarUrl;

    @Column (name = "locale", columnDefinition = "text")
    private String locale;

    @Column (name = "timezone", columnDefinition = "text")
    private String timezone;

    @Column (name = "is_platform_staff")
    private Boolean isPlatformStaff;

    @Column (name = "platform_role", columnDefinition = "text")
    private String platformRole;

    @Column (name = "password", columnDefinition = "text")
    private String password;

    @Column (name = "is_active")
    private boolean isActive;
}
