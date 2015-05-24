package com.ipn.edudown.johnlandongdown.entidades;

import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Materia {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Key idMateria;
	@Persistent
	String nombreMateria;
	@Persistent
	String descripcion;
	@Persistent
	@Unowned
	Set<Profesor> Profesor_idProfesor;

	public Key getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Key idMateria) {
		this.idMateria = idMateria;
	}

	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Profesor> getProfesor_idProfesor() {
		return Profesor_idProfesor;
	}

	public void setProfesor_idProfesor(Set<Profesor> profesor_idProfesor) {
		Profesor_idProfesor = profesor_idProfesor;
	}

}
