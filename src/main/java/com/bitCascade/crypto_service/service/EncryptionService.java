package com.bitCascade.crypto_service.service;

import com.bitCascade.crypto_service.utils.AESGCMUtil;
import com.bitCascade.crypto_service.validation.DecryptResponse;
import com.bitCascade.crypto_service.validation.EncryptResponse;
import reactor.core.publisher.Mono;

public interface EncryptionService {
    public Mono<EncryptResponse> encrypt(String plainText);
    public Mono<DecryptResponse> decrypt(String cipherText);
}
