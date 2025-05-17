package com.benhamida.wincar.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benhamida.wincar.clientApi.TransverseRestClient;
import com.benhamida.wincar.entities.OrdreReparation;
import com.benhamida.wincar.model.Collaborateur;
import com.benhamida.wincar.repository.OrdreReparationRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/ordresReparation")
public class OrdreReparationRestController {

	private OrdreReparationRepository ordreReparationRepository;

	private TransverseRestClient transverseRestClient;

	@GetMapping
	public List<OrdreReparation> getAll() {

		return ordreReparationRepository.findAll();

	}

	@GetMapping("/{id}")
	public OrdreReparation ordreReparationById(@PathVariable Long id) {

		OrdreReparation or = ordreReparationRepository.findById(id).get();
		
		Collaborateur collab = transverseRestClient.findCollaborateurById(or.getIdCollaborateur());
		
		or.setCollaborateur(collab);
		
		return or;

	}

}
