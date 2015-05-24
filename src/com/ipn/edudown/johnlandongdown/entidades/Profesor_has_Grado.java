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
public class Profesor_has_Grado {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Key id;
	@Persistent 
	@Unowned
	Set<Profesor> profesor;
	@Persistent 
	@Unowned
	Set<Grado> grado;
	
	public Key getIdGrado() {
		return id;
	}
	public void setIdGrado(Key id) {
		this.id = id;
	}
	public Set<Profesor> getProfesor() {
		return profesor;
	}
	public void setProfesor(Set<Profesor> profesor) {
		this.profesor = profesor;
	}
	public Set<Grado> getGrado() {
		return grado;
	}
	public void setGrado(Set<Grado> grado) {
		this.grado = grado;
	}
	
}
