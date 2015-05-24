package com.ipn.edudown.johnlandongdown.entidades;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Profesor {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Key idProfesor;
	@Persistent
	String nombre;
	@Persistent
	String apaterno;
	@Persistent
	String amaterno;
	@Persistent
	String especialidad;
	@Persistent
	String email;
	@Persistent
	Date fecha_alta;
	@Persistent
	@Unowned
	List<Grado> Grado_idGrado;
	@Persistent
	@Unowned
	List<Materia> Materia_idMateria;

	public Key getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Key idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApaterno() {
		return apaterno;
	}

	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}

	public String getAmaterno() {
		return amaterno;
	}

	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Grado> getGrado_idGrado() {
		return Grado_idGrado;
	}

	public void setGrado_idGrado(List<Grado> grado_idGrado) {
		Grado_idGrado = grado_idGrado;
	}

	public List<Materia> getMateria_idMateria() {
		return Materia_idMateria;
	}

	public void setMateria_idMateria(List<Materia> materia_idMateria) {
		Materia_idMateria = materia_idMateria;
	}

}
