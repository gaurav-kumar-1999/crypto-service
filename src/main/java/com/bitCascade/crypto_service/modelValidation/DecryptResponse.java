package com.bitCascade.crypto_service.modelValidation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DecryptResponse {
    private String decrypted;
}