package com.bitCascade.crypto_service.modelValidation;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EncryptRequest {
    @NotBlank
    private String data;
}