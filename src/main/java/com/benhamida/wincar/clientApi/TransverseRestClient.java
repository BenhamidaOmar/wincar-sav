package com.benhamida.wincar.clientApi;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.benhamida.wincar.model.Collaborateur;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name="TRANSVERSE-SERVICE")
public interface TransverseRestClient {
	
	@GetMapping("/collaborateurs/{id}")
	@CircuitBreaker(name="collaborateurService", fallbackMethod = "getDefaultCustumer")
	Collaborateur findCollaborateurById(@PathVariable Long id);
	
	@GetMapping("/collaborateurs")
	@CircuitBreaker(name="collaborateurService", fallbackMethod = "getDefaultAllCustumer")
	List<Collaborateur> getAllCollaborateur();
	
	default Collaborateur getDefaultCustumer(Long id,Exception exception) {
		Collaborateur colab = new Collaborateur();
		colab.setId(id);
		colab.setNom("Pas disponible");
		colab.setPrenom("Pas disponible");
		colab.setEmail("Pas disponible");
		colab.setTelephone("Pas disponible");
		return colab;
	}
	
	default List<Collaborateur> getDefaultAllCustumer(Exception exception) {
		
		return List.of();
	}

}
