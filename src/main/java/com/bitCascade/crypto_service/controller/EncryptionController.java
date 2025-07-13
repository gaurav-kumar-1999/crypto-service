package com.bitCascade.crypto_service.controller;

import com.bitCascade.crypto_service.modelValidation.DecryptRequest;
import com.bitCascade.crypto_service.modelValidation.DecryptResponse;
import com.bitCascade.crypto_service.modelValidation.EncryptRequest;
import com.bitCascade.crypto_service.modelValidation.EncryptResponse;
import com.bitCascade.crypto_service.service.impl.EncryptionServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/crypto")
@RequiredArgsConstructor
public class EncryptionController {

    private final EncryptionServiceImpl encryptionService;

    @PostMapping(value = "/encrypt", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<EncryptResponse> encrypt(@Valid @RequestBody EncryptRequest request) {
        return encryptionService.encrypt(request.getData());
    }

    @PostMapping(value = "/decrypt", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<DecryptResponse> decrypt(@Valid @RequestBody DecryptRequest request) {
        return encryptionService.decrypt(request.getData());
    }
}