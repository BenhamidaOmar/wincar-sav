package com.benhamida.wincar.model;

import lombok.Data;

@Data
public class Collaborateur {

	private Long id;

	private String nom;

	private String prenom;

	private String email;

	private String telephone;
}
