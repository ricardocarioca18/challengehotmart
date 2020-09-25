package com.challenge.marketplace.config.security;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.challenge.marketplace.model.Client;
import com.challenge.marketplace.repository.ClientRepository;

@Service
public class AuthenticationService implements UserDetailsService{

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Client> client = clientRepository.findByEmail(username);
		if(client.isPresent()) {
			return client.get();
		}
		throw new UsernameNotFoundException("Invalid data, please check your access data.");
	}

	
}
