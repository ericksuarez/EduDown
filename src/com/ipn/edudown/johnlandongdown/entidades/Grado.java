package com.ipn.edudown.johnlandongdown.entidades;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Grado {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Long idGrado;
	@Persistent
	int grado;
	
	public Long getIdGrado() {
		return idGrado;
	}
	public void setIdGrado(Long idGrado) {
		this.idGrado = idGrado;
	}
	public int getGrado() {
		return grado;
	}
	public void setGrado(int grado) {
		this.grado = grado;
	}
}
