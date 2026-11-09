package com.hyperdata.proms.api.Persintance.Service;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperdata.proms.api.Dto.Request.LoginRequest;
import com.hyperdata.proms.api.Dto.Response.LoginResponse;
import com.hyperdata.proms.api.Dto.Response.UserResponse;
import com.hyperdata.proms.api.Exception.ApiException;
import com.hyperdata.proms.api.Persintance.Entity.User;
import com.hyperdata.proms.api.Persintance.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Transactional(readOnly = true)
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email().trim().toLowerCase())
                .orElseThrow(AuthService::invalidCredentials);

        if (user.getPassword() == null || user.getPassword().isBlank()
                || !passwordEncoder.matches(request.password(), user.getPassword())) {
            throw invalidCredentials();
        }

        if (!user.isActive()) {
            throw new ApiException(HttpStatus.FORBIDDEN, "ACCOUNT_INACTIVE",
                    "Akun telah dinonaktifkan oleh administrator");
        }

        return new LoginResponse(
                jwtService.generateToken(user),
                "Bearer",
                jwtService.getExpiresInSeconds(),
                UserResponse.from(user));
    }

    @Transactional(readOnly = true)
    public UserResponse me(UUID userId) {
        User user = userRepository.findById(userId)
                .filter(User::isActive)
                .orElseThrow(() -> new ApiException(HttpStatus.UNAUTHORIZED, "USER_NOT_FOUND",
                        "User tidak ditemukan atau tidak aktif"));
        return UserResponse.from(user);
    }

    private static ApiException invalidCredentials() {
        return new ApiException(HttpStatus.UNAUTHORIZED, "INVALID_CREDENTIALS",
                "Email atau password salah");
    }
}