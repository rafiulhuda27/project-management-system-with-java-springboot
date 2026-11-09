package com.hyperdata.proms.api.Dto.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(@NotBlank (message = "Email wajib diisi") @Email (message = "Format email tidak valid") String email,
                        @NotBlank (message = "Paswword wajib diiisi") String password) {
    
}
