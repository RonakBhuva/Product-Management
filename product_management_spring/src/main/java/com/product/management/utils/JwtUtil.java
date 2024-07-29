package com.product.management.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.MacAlgorithm;

@Component
public class JwtUtil {

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		try {
			MacAlgorithm alg = Jwts.SIG.HS512; // or HS384 or HS256
			SecretKey key = alg.key().build();
			System.out.println(key.getFormat());
			return Jwts.parser().build().parseSignedClaims(token).getPayload();
		} catch (Exception e) {
			throw new RuntimeException("Failed to parse JWT token", e);
		}
	}

	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	private String createToken(Map<String, Object> claims, String subject) {
		MacAlgorithm alg = Jwts.SIG.HS512;
		SecretKey key = alg.key().build();
		System.out.println(key.getFormat());
		return Jwts.builder().claims(claims).subject(subject).issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)).signWith(key).compact();
	}

	public String generateToken(String name) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, name);
	}

	public Boolean validateToken(String token, String name) {
		final String username = extractUsername(token);
		return (username.equals(name) && !isTokenExpired(token));
	}

}
