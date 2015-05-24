package com.ipn.edudown.johnlandongdown.entidades;

import java.io.Serializable;
import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Grado implements Serializable{

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Key idGrado;
	@Persistent
	String grado;
	@Persistent
	String grupo;
	@Persistent
	@Unowned
	Set<Profesor> Profesor_idProfesor;
	@Persistent
	@Unowned
	Set<Materia> Materia_idMateria;

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Key getIdGrado() {
		return idGrado;
	}

	public void setIdGrado(Key idGrado) {
		this.idGrado = idGrado;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public Set<Profesor> getProfesor_idProfesor() {
		return Profesor_idProfesor;
	}

	public void setProfesor_idProfesor(Set<Profesor> profesor_idProfesor) {
		Profesor_idProfesor = profesor_idProfesor;
	}

	public Set<Materia> getMateria_idMateria() {
		return Materia_idMateria;
	}

	public void setMateria_idMateria(Set<Materia> materia_idMateria) {
		Materia_idMateria = materia_idMateria;
	}

	@Override
	public String toString() {
		return getGrado() + " - " + getGrupo();
	}
	
	
}
