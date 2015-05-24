package com.ipn.edudown.johnlandongdown.entidades;

import java.sql.Date;
import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Avance {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Key idAvance;
	@Persistent
	Date fecha;
	@Persistent
	String tiempoTerminado;
	@Persistent
	Boolean termiando;
	@Persistent
	Integer errores;
	@Persistent
	@Unowned
	Juegos Juegos_idJuegos;
	@Persistent
	@Unowned
	Alumno Alumno_idAlumno;

	public Key getIdAvance() {
		return idAvance;
	}

	public void setIdAvance(Key idAvance) {
		this.idAvance = idAvance;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTiempoTerminado() {
		return tiempoTerminado;
	}

	public void setTiempoTerminado(String tiempoTerminado) {
		this.tiempoTerminado = tiempoTerminado;
	}

	public Boolean getTermiando() {
		return termiando;
	}

	public void setTermiando(Boolean termiando) {
		this.termiando = termiando;
	}

	public Integer getErrores() {
		return errores;
	}

	public void setErrores(Integer errores) {
		this.errores = errores;
	}

	public Juegos getJuegos_idJuegos() {
		return Juegos_idJuegos;
	}

	public void setJuegos_idJuegos(Juegos juegos_idJuegos) {
		Juegos_idJuegos = juegos_idJuegos;
	}

	public Alumno getAlumno_idAlumno() {
		return Alumno_idAlumno;
	}

	public void setAlumno_idAlumno(Alumno alumno_idAlumno) {
		Alumno_idAlumno = alumno_idAlumno;
	}

	



}
