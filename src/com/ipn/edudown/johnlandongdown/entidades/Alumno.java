package com.ipn.edudown.johnlandongdown.entidades;

import java.io.Serializable;
import java.sql.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Alumno implements Serializable{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Key idAlumno;
	@Persistent
	String nombre;
	@Persistent
	String apaterno;
	@Persistent
	String amaterno;
	@Persistent
	String usuario;
	@Persistent
	Date fecha_alta;
	@Persistent 
	@Unowned
	Grado Grado_idGrado;
	 

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Grado getGrado_idGrado() {
		return Grado_idGrado;
	}

	public void setGrado_idGrado(Grado grado_idGrado) {
		Grado_idGrado = grado_idGrado;
	}

	public Key getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Key idAlumno) {
		this.idAlumno = idAlumno;
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

	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
}

