package io.tacsio.otp.springotp.infra;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * https://github.com/google/google-authenticator/wiki/Key-Uri-Format
 */
@Service
public class GoogleAuthenticator {

    private final QRCodeGenerator qrCodeGenerator;

    public GoogleAuthenticator(QRCodeGenerator qrCodeGenerator) {
        this.qrCodeGenerator = qrCodeGenerator;
    }

    public BufferedImage generateConfigQRCode(GoogleAuthenticatorParams params) throws IOException {
        String qrCodeText = generateQRCodeText(params);
        return qrCodeGenerator.generate(qrCodeText);
    }

    private String generateQRCodeText(GoogleAuthenticatorParams params) {
        return UriComponentsBuilder.fromUriString("otpauth://{type}/{label}?secret={secret}&issuer={issuer}")
                .build()
                .expand(params.type(), params.label(), params.secret(), params.issuer())
                .toUri()
                .toASCIIString();
    }
}
