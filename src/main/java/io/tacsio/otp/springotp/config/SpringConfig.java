package io.tacsio.otp.springotp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;

import java.awt.image.BufferedImage;

@Configuration
public class SpringConfig {

    @Bean
    public HttpMessageConverter<BufferedImage> imageConverter() {
        return new BufferedImageHttpMessageConverter();
    }
}
