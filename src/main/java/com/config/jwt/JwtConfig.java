package com.config.jwt;

import com.google.common.net.HttpHeaders;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

@Configuration
@NoArgsConstructor
@Getter
@Setter
public class JwtConfig {

    @Value("${jwt.token.secret}")
    private String secretKey;

    @Value("${jwt.token.expired}")
    private Long expirationDate;

    @Value("${jwt.token.prefix}")
    private String prefix;

    @Bean
    public SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String getAuthorizationHeader() {
        return HttpHeaders.AUTHORIZATION;
    }
}
