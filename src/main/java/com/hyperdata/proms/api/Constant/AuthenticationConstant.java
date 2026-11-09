package com.hyperdata.proms.api.Constant;

/**
 * Konstanta khusus keamanan dan autentikasi.
 */
public final class AuthenticationConstant {

    private AuthenticationConstant() {
        // Utility class
    }

    // Authorization messages
    public static final String UNAUTHORIZED_MESSAGE = "Anda tidak memiliki otorisasi";
    public static final String FORBIDDEN_MESSAGE = "Anda tidak memiliki akses";

    // Authentication methods
    public static final String AUTHENTICATION_METHOD_JWT = "JWT";
    public static final String AUTHENTICATION_METHOD_DB = "DB";

    // JWT configuration and claims
    public static final String JWT_AUTHORIZATION_HEADER = "Authorization";
    public static final String JWT_SUBJECT_CLAIM = "sub";
    public static final String JWT_EMAIL_CLAIM = "email";
    public static final String JWT_NAME_CLAIM = "name";
    public static final String JWT_ROLE_CLAIM = "role";
    public static final String JWT_TOKEN_TYPE = "Bearer";

    // Login errors
    public static final String INVALID_CREDENTIALS_ERROR_CODE = "INVALID_CREDENTIALS";
    public static final String INVALID_CREDENTIALS_ERROR_DESC = "Email atau password salah";

    public static final String USER_NOT_FOUND_ERROR_CODE = "USER_NOT_FOUND";
    public static final String USER_NOT_FOUND_ERROR_DESC = "User tidak ditemukan atau tidak aktif";

    public static final String ACCOUNT_INACTIVE_ERROR_CODE = "ACCOUNT_INACTIVE";
    public static final String ACCOUNT_INACTIVE_ERROR_DESC = "Akun telah dinonaktifkan oleh administrator";

    public static final String VALIDATION_ERROR_CODE = "VALIDATION_ERROR";
    public static final String VALIDATION_ERROR_DESC = "Data yang dikirim tidak valid";

    // HTTP status codes
    public static final int HTTP_BAD_REQUEST = 400;
    public static final int HTTP_UNAUTHORIZED = 401;
    public static final int HTTP_FORBIDDEN = 403;
    public static final int HTTP_OK = 200;

    // Common values
    public static final String SYSTEM = "SYSTEM";
    public static final String LOGIN = "LOGIN";
    public static final String LOGOUT = "LOGOUT";
    public static final String SUCCESS = "SUCCESS";
    public static final String BEARER = "Bearer";

    // Authentication routes
    public static final String API = "/api/";
    public static final String VERSION = "v1/";
    public static final String AUTH = "auth/";
    public static final String AUTHENTICATION = API + VERSION + AUTH;
    public static final String AUTHENTICATION_LOGIN = AUTHENTICATION + "login";
    public static final String AUTHENTICATION_MOCK_USERS = AUTHENTICATION + "mock-user";
    public static final String AUTHENTICATION_LOGOUT = AUTHENTICATION + "logout";
    public static final String AUTHENTICATION_PROFILE = AUTHENTICATION + "profile";
}
