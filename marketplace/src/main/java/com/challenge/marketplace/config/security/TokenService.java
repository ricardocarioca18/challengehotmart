package com.challenge.marketplace.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.challenge.marketplace.model.Client;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${marketplace.jwt.expiration}")
	private String expiration;

	@Value("${marketplace.jwt.expiration}")
	private String secret;
	
	public String generateToken(Authentication authentication) {
		Client client = (Client) authentication.getPrincipal();
		
		return Jwts.builder()
				.setIssuer("API Marketplace Challenge Hotmart")
				.setSubject(client.getId().toString())
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + Long.parseLong(expiration)))
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	public boolean isTokenValid(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	public Long getIdClient(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
		
	}
	
	

}
