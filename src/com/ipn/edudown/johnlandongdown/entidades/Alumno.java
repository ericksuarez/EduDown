package com.ipn.edudown.johnlandongdown.entidades;

import java.sql.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Alumno {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Long idAlumno;
	@Persistent
	String nombre;
	@Persistent
	String apaterno;
	@Persistent
	String amaterno;
	@Persistent
	Date fecha_alta;
	@Persistent 
	int Grado_idGrado;
	@Persistent 
	String Grupo_idGrupo;
	 

	public int getGrado_idGrado() {
		return Grado_idGrado;
	}

	public void setGrado_idGrado(int grado_idGrado) {
		Grado_idGrado = grado_idGrado;
	}

	public String getGrupo_idGrupo() {
		return Grupo_idGrupo;
	}

	public void setGrupo_idGrupo(String grupo_idGrupo) {
		Grupo_idGrupo = grupo_idGrupo;
	}

	public Long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Long idAlumno) {
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

