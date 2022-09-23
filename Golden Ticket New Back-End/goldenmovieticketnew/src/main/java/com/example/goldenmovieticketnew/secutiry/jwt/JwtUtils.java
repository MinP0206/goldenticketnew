package com.example.goldenmovieticketnew.secutiry.jwt;


import com.example.goldenmovieticketnew.secutiry.UserDetailsImpl;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${bezkoder.app.jwtSecret}")
	private String jwtSecret;

	@Value("${bezkoder.app.jwtExpirationMs}")
	private int jwtExpirationMs;

//	public String generateJwtToken(Authentication authentication) {
//
//		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
//
//		return Jwts.builder()
//				.setSubject((userPrincipal.getUsername()))
//				.setIssuedAt(new Date())
//				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
//				.signWith(SignatureAlgorithm.HS512, jwtSecret)
//				.compact();
//	}
	public String generateJwtToken(Authentication authentication) {
		//The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		byte[] apiKeySecretBytes = Base64.getDecoder().decode(jwtSecret);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		return Jwts.builder()
				.setSubject((userPrincipal.getId()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(signatureAlgorithm,signingKey)
				.compact();
	}
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
}
