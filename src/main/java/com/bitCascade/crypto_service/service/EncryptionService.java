package com.bitCascade.crypto_service.service;

import com.bitCascade.crypto_service.modelValidation.DecryptResponse;
import com.bitCascade.crypto_service.modelValidation.EncryptResponse;
import reactor.core.publisher.Mono;

public interface EncryptionService {
    public Mono<EncryptResponse> encrypt(String plainText);
    public Mono<DecryptResponse> decrypt(String cipherText);
}
