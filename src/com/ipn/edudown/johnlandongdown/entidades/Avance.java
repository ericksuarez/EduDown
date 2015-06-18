package com.ipn.edudown.johnlandongdown.entidades;

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
	String fecha;
	@Persistent
	String tiempoTerminado;
	@Persistent
	Integer errores;
	@Persistent
	Integer puntuacion;
	@Persistent
	@Unowned
	String Juegos_idJuegos;
	@Persistent
	@Unowned
	String Alumno_idAlumno;

	public Key getIdAvance() {
		return idAvance;
	}

	public void setIdAvance(Key idAvance) {
		this.idAvance = idAvance;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTiempoTerminado() {
		return tiempoTerminado;
	}

	public void setTiempoTerminado(String tiempoTerminado) {
		this.tiempoTerminado = tiempoTerminado;
	}

	public Integer getErrores() {
		return errores;
	}

	public void setErrores(Integer errores) {
		this.errores = errores;
	}

	public String getJuegos_idJuegos() {
		return Juegos_idJuegos;
	}

	public void setJuegos_idJuegos(String juegos_idJuegos) {
		Juegos_idJuegos = juegos_idJuegos;
	}

	public String getAlumno_idAlumno() {
		return Alumno_idAlumno;
	}

	public void setAlumno_idAlumno(String alumno_idAlumno) {
		Alumno_idAlumno = alumno_idAlumno;
	}

	public Integer getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}

	



}
