package com.benhamida.wincar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.benhamida.wincar.clientApi.TransverseRestClient;
import com.benhamida.wincar.entities.OrdreReparation;
import com.benhamida.wincar.repository.OrdreReparationRepository;

@SpringBootApplication
@EnableFeignClients
public class WincarSavApplication {

	public static void main(String[] args) {
		SpringApplication.run(WincarSavApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(OrdreReparationRepository ordreReparationRepository,
			TransverseRestClient collaborateur) {

		return args -> {

			collaborateur.getAllCollaborateur().forEach(c -> {
				OrdreReparation or1 = OrdreReparation.builder()
						.id(null)
						.libelle("Ford")
						.idCollaborateur(c.getId())
						.build();
				
				OrdreReparation or2 = OrdreReparation.builder()
						.id(null)
						.libelle("Mercedes")
						.idCollaborateur(c.getId())
						.build();
				
				OrdreReparation or3 = OrdreReparation.builder()
						.id(null)
						.libelle("BMW")
						.idCollaborateur(c.getId())
						.build();
				
				ordreReparationRepository.save(or1);
				ordreReparationRepository.save(or2);
				ordreReparationRepository.save(or3);


			});

			
		

		};
	}

}
