package com.challenge.marketplace.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.marketplace.model.Client;


public interface ClientRepository extends JpaRepository<Client, Long>{

	Optional<Client> findByEmail(String email);
}
