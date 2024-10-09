package com.daou.reviewer.common.auth;

import com.daou.reviewer.domain.entity.Users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtGenerator {
    //TODO: env
    @Value("${jwt.access.secret-key}")
    private String accessSecretKey;
    @Value("${jwt.access.expired}")
    private long accessExpiration;
    @Value("${jwt.refresh.secret-key}")
    private String refreshSecretKey;
    @Value("${jwt.refresh.expired}")
    private long refreshExpiration;

    public String generateAccessToken(Users user) {
        long now = System.currentTimeMillis();
        byte[] keyBytes = Decoders.BASE64.decode(accessSecretKey);

        return Jwts.builder()
                   .setHeader(createHeader())
                   .setClaims(createClaims(user))
                   .setSubject(user.getLoginId())
                   .setIssuedAt(new Date(now))
                   .setExpiration(new Date(now + accessExpiration))
                   .signWith(Keys.hmacShaKeyFor(keyBytes), SignatureAlgorithm.HS256)
                   .compact();
    }

    public String generateRefreshToken(Users user) {
        long now = System.currentTimeMillis();
        byte[] keyBytes = Decoders.BASE64.decode(refreshSecretKey);

        return Jwts.builder()
                   .setHeader(createHeader())
                   .setSubject(user.getLoginId())
                   .setIssuedAt(new Date(now))
                   .setExpiration(new Date(now + refreshExpiration))
                   .signWith(Keys.hmacShaKeyFor(keyBytes), SignatureAlgorithm.HS256)
                   .compact();
    }

    private Map<String, Object> createHeader(){
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");

        return header;
    }

    private Map<String, Object> createClaims(Users user){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getUserId());

        return claims;
    }
}
