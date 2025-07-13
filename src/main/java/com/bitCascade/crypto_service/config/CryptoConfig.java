package com.bitCascade.crypto_service.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;

@Slf4j
@Getter
@Configuration
public class CryptoConfig {

    @Value("${crypto.secret-key}")
    private String secretKeyEncoded;

    private byte[] secretKey;

    @PostConstruct
    public void init() {
        try {
            this.secretKey = Base64.getDecoder().decode(secretKeyEncoded);
            if (secretKey.length != 32) {
                throw new IllegalArgumentException("Secret key must decode to 32 bytes (256 bits)");
            }
            log.info("Crypto key loaded successfully.");
        } catch (Exception e) {
            log.error("Failed to decode secret key", e);
            throw new IllegalStateException("Invalid crypto key configuration", e);
        }
    }
}
