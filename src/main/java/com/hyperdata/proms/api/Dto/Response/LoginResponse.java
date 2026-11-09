package com.hyperdata.proms.api.Dto.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginResponse(
    String token,
    @JsonProperty ("token_type") String tokenType,
    @JsonProperty ("expires_in") long expiresIn,
    UserResponse user
) {
    
}
