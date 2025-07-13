package com.bitCascade.crypto_service.service.impl;

import com.bitCascade.crypto_service.service.EncryptionService;
import com.bitCascade.crypto_service.modelValidation.DecryptResponse;
import com.bitCascade.crypto_service.modelValidation.EncryptResponse;
import com.bitCascade.crypto_service.utils.AESGCMUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class EncryptionServiceImpl implements EncryptionService {

    public Mono<EncryptResponse> encrypt(String plainText) {
        return Mono.fromCallable(() -> new EncryptResponse(AESGCMUtil.encrypt(plainText)));
    }

    public Mono<DecryptResponse> decrypt(String cipherText) {
        return Mono.fromCallable(() -> new DecryptResponse(AESGCMUtil.decrypt(cipherText)));
    }
}