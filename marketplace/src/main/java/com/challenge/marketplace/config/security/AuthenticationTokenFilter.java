package com.challenge.marketplace.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.challenge.marketplace.model.Client;
import com.challenge.marketplace.repository.ClientRepository;

public class AuthenticationTokenFilter extends OncePerRequestFilter{

	private TokenService tokenService;
	private ClientRepository clientRepository;
	
	public AuthenticationTokenFilter(TokenService tokenService, ClientRepository clientRepository) {
		this.tokenService = tokenService;
		this.clientRepository = clientRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
		throws ServletException, IOException {
			String token = getToken(request);
			//System.out.println("TOken retornado: "+token);
			boolean valid = tokenService.isTokenValid(token);
			if(valid) {
				autenticateClient(token);
			}
			
			
			filterChain.doFilter(request, response);
		}

	private void autenticateClient(String token) {
		Long idClient = tokenService.getIdClient(token);
		Client client = clientRepository.findById(idClient).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(client, null, client.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);		
	}

	private String getToken(HttpServletRequest request) {		
		String token = request.getHeader("Authorization");
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		return token.substring(7, token.length());
	}

}
