package io.tacsio.otp.springotp.infra;

import net.glxn.qrgen.javase.QRCode;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class QRCodeGenerator {

    public BufferedImage generate(String text) throws IOException {
        ByteArrayOutputStream stream = QRCode
                .from(text)
                .withSize(250, 250)
                .stream();

        ByteArrayInputStream is = new ByteArrayInputStream(stream.toByteArray());

        return ImageIO.read(is);
    }
}
