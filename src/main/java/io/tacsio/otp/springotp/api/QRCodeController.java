package io.tacsio.otp.springotp.api;

import io.tacsio.otp.springotp.infra.GoogleAuthenticator;
import io.tacsio.otp.springotp.infra.GoogleAuthenticatorParams;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class QRCodeController {

    private final GoogleAuthenticator googleAuthenticator;

    public QRCodeController(GoogleAuthenticator googleAuthenticator) {
        this.googleAuthenticator = googleAuthenticator;
    }

    @GetMapping(value = "/", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<?> generateQRCode() {
        GoogleAuthenticatorParams params = new GoogleAuthenticatorParams("tacsio:user", "123456", "tacsio.io");

        try {
            BufferedImage qrCodeImage = googleAuthenticator.generateConfigQRCode(params);
            return ResponseEntity.ok(qrCodeImage);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
