package com.hyperdata.proms.api.Controller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hyperdata.proms.api.Constant.AuthenticationConstant;
import com.hyperdata.proms.api.Dto.Request.LoginRequest;
import com.hyperdata.proms.api.Dto.Response.LoginResponse;
import com.hyperdata.proms.api.Dto.Response.UserResponse;
import com.hyperdata.proms.api.Persintance.Entity.User;
import com.hyperdata.proms.api.Persintance.Repository.UserRepository;
import com.hyperdata.proms.api.Persintance.Service.JwtService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @RequestMapping(value = AuthenticationConstant.AUTHENTICATION_LOGIN,
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> userLogin(HttpServletRequest request, HttpServletResponse response,
            @RequestBody LoginRequest login) {

        // 1. Validasi input
        if (login == null || !StringUtils.hasText(login.email()))
            return error(HttpStatus.BAD_REQUEST, AuthenticationConstant.VALIDATION_ERROR_CODE,
                    "Email wajib diisi");
        if (!StringUtils.hasText(login.password()))
            return error(HttpStatus.BAD_REQUEST, AuthenticationConstant.VALIDATION_ERROR_CODE,
                    "Password wajib diisi");

        // 2. Cari user berdasarkan email
        String email = login.email().trim().toLowerCase();
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) {
            log.warn("{} FAILED email={} ip={}", AuthenticationConstant.LOGIN, email, request.getRemoteAddr());
            return error(HttpStatus.UNAUTHORIZED, AuthenticationConstant.INVALID_CREDENTIALS_ERROR_CODE,
                    AuthenticationConstant.INVALID_CREDENTIALS_ERROR_DESC);
        }

        // 3. Cek password (BCrypt)
        if (!StringUtils.hasText(user.getPassword())
                || !passwordEncoder.matches(login.password(), user.getPassword())) {
            log.warn("{} FAILED email={} ip={}", AuthenticationConstant.LOGIN, email, request.getRemoteAddr());
            return error(HttpStatus.UNAUTHORIZED, AuthenticationConstant.INVALID_CREDENTIALS_ERROR_CODE,
                    AuthenticationConstant.INVALID_CREDENTIALS_ERROR_DESC);
        }

        // 4. Cek akun aktif
        if (!user.isActive())
            return error(HttpStatus.FORBIDDEN, AuthenticationConstant.ACCOUNT_INACTIVE_ERROR_CODE,
                    AuthenticationConstant.ACCOUNT_INACTIVE_ERROR_DESC);

        // 5. Generate token & kirim response
        String token = jwtService.generateToken(user);
        log.info("{} {} userid={} ip={}", AuthenticationConstant.LOGIN, AuthenticationConstant.SUCCESS,
                user.getId(), request.getRemoteAddr());

        return ResponseEntity.ok(new LoginResponse(
                token,
                AuthenticationConstant.BEARER,
                jwtService.getExpiresInSeconds(),
                UserResponse.from(user)));
    }

    // ===================== PROFILE (token) =====================
    @RequestMapping(value = AuthenticationConstant.AUTHENTICATION_PROFILE,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> userProfile(HttpServletRequest request, HttpServletResponse response,
            @AuthenticationPrincipal Jwt jwt) {

        UUID userId;
        try {
            userId = UUID.fromString(jwt.getSubject());
        } catch (Exception e) {
            return error(HttpStatus.UNAUTHORIZED, AuthenticationConstant.USER_NOT_FOUND_ERROR_CODE,
                    AuthenticationConstant.UNAUTHORIZED_MESSAGE);
        }

        User user = userRepository.findById(userId).filter(User::isActive).orElse(null);
        if (user == null)
            return error(HttpStatus.UNAUTHORIZED, AuthenticationConstant.USER_NOT_FOUND_ERROR_CODE,
                    AuthenticationConstant.USER_NOT_FOUND_ERROR_DESC);

        return ResponseEntity.ok(UserResponse.from(user));
    }

    // ===================== HELPER =====================
    // Format sama dengan GlobalExceptionHandler: status, code, message
    private ResponseEntity<Map<String, Object>> error(HttpStatus status, String code, String message) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", status.value());
        body.put("code", code);
        body.put("message", message);
        return ResponseEntity.status(status).body(body);
    }

    // Logout
    @RequestMapping(value = AuthenticationConstant.AUTHENTICATION_LOGOUT,
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> userLogout(HttpServletRequest request, HttpServletResponse response,
            @AuthenticationPrincipal Jwt jwt) {

        if (jwt == null)
            return error(HttpStatus.UNAUTHORIZED, AuthenticationConstant.USER_NOT_FOUND_ERROR_CODE,
                    AuthenticationConstant.UNAUTHORIZED_MESSAGE);

        log.info("{} {} userid={} ip={}", AuthenticationConstant.LOGOUT, AuthenticationConstant.SUCCESS,
                jwt.getSubject(), request.getRemoteAddr());

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", AuthenticationConstant.HTTP_OK);
        body.put("code", AuthenticationConstant.SUCCESS);
        body.put("message", "Logout berhasil");
        return ResponseEntity.ok(body);
    }
}