# 🔐 URL Encryption/Decryption Microservice

This microservice provides AES-256-GCM based encryption and decryption for URLs. It is designed to be a lightweight, reactive, and stateless component that can be used independently or integrated with a larger URL shortener service.

---

## 🚀 Features

- ✅ AES-256-GCM encryption with secure IV and tag
- ✅ URL-safe Base64 encoding (supports use in short links)
- ✅ Reactive programming with Spring WebFlux
- ✅ Configurable 256-bit secret key via `.env` or environment variables
- ✅ Easily deployable as a stateless microservice

---

## 📦 API Endpoints

### 🔐 Encrypt URL

- **POST** `/api/encrypt`
- **Request Body:**
  ```json
  {
    "data": "https://example.com/secure-link"
  }

- **Response Body:**
{
  "encrypted": "B7vfjIeEyY0cPv65qdNNT47Mx3R1msCslbh1KzrbSWAf0w"
}


- **POST**`/api/decrypt`
- **Request Body:**
  ```json
{
  "data": "B7vfjIeEyY0cPv65qdNNT47Mx3R1msCslbh1KzrbSWAf0w"
}

- **Response Body:**
{
  "decrypted": "https://example.com/secure-link"
}


⚙️ Configuration
The 256-bit AES secret key should be provided as a Base64-encoded environment variable:

Create a .env file in the root directory:
CRYPTO_SECRET_KEY=your_base64_encoded_256bit_key

Generate one using:
openssl rand 32 | base64

📁 Project Structure

src
├── controller/       → REST endpoints
├── modelValidation/  → Request/Response DTOs
├── service/          → Encryption service layer
├── util/             → AESGCMUtil (key logic)



👨‍💻 Author
Developed by Gaurav Kumar
Java | Spring Boot | Microservices | Security | Reactive Systems
