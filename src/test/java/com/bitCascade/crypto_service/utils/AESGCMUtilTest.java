package com.bitCascade.crypto_service.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

class AESGCMUtilTest {

    private static final String TEST_SECRET_KEY = Base64.getEncoder()
            .encodeToString("tIlCJbr6F5Uo54b6nhmg+Ls7n0jBqJcUoZkqbFqt2A0=".getBytes()); // 32 bytes

    @BeforeAll
    static void overrideKeyForTesting() throws Exception {
        // Override the private static field "key" using reflection
        Field keyField = AESGCMUtil.class.getDeclaredField("key");
        keyField.setAccessible(true);
        byte[] decodedKey = Base64.getDecoder().decode(TEST_SECRET_KEY);
//        keyField.set(null, decodedKey); // null because it's static
    }

    @Test
    void testEncryptDecrypt_validInput_shouldReturnOriginalText() {
        String originalText = "https://bitcascade.com/secure/gaurav";

        String encrypted = AESGCMUtil.encrypt(originalText);
        assertNotNull(encrypted, "Encrypted string should not be null");
        assertFalse(encrypted.isEmpty(), "Encrypted string should not be empty");

        String decrypted = AESGCMUtil.decrypt(encrypted);
        assertEquals(originalText, decrypted, "Decrypted string should match the original");
    }

    @Test
    void testDecrypt_withInvalidBase64_shouldThrowException() {
        String invalidBase64 = "!!not-valid-base64!!";

        Exception exception = assertThrows(RuntimeException.class, () -> {
            AESGCMUtil.decrypt(invalidBase64);
        });

        assertTrue(exception.getMessage().contains("Decryption failed"));
    }

    @Test
    void testEncrypt_withNullInput_shouldThrowException() {
        assertThrows(RuntimeException.class, () -> {
            AESGCMUtil.encrypt(null);
        });
    }

    @Test
    void testDecrypt_withTamperedCipher_shouldThrowException() {
        String originalText = "Sensitive URL";
        String encrypted = AESGCMUtil.encrypt(originalText);

        // Tamper the encrypted text
        String tampered = encrypted.substring(0, encrypted.length() - 1) + "A";

        Exception exception = assertThrows(RuntimeException.class, () -> {
            AESGCMUtil.decrypt(tampered);
        });

        assertTrue(exception.getMessage().contains("Decryption failed"));
    }
}