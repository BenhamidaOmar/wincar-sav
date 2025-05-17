package com.benhamida.wincar.entities;

import com.benhamida.wincar.model.Collaborateur;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */

@Entity
@Table(name = "ordre_reparation")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrdreReparation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ordre_reparation")
	private Long id;

	@Column(name = "libelle")
	private String libelle;
	
	@Transient
	private Collaborateur collaborateur;
	
	private Long idCollaborateur;
	

}
