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
public class RegistroEvaluacion {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Key idRegistroEvaluacion;
	@Persistent
	Date fecha;
	@Persistent
	String aprovado;
	@Persistent
	String tiempoPromedio;
	@Persistent
	String intentosPromedio;
	@Persistent
	@Unowned
	Set<Alumno> Alumno_idAlumno;
	@Persistent
	@Unowned
	Set<Juegos> Juegos_idJuegos;

	public Key getIdRegistroEvaluacion() {
		return idRegistroEvaluacion;
	}

	public void setIdRegistroEvaluacion(Key idRegistroEvaluacion) {
		this.idRegistroEvaluacion = idRegistroEvaluacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getAprovado() {
		return aprovado;
	}

	public void setAprovado(String aprovado) {
		this.aprovado = aprovado;
	}

	public String getTiempoPromedio() {
		return tiempoPromedio;
	}

	public void setTiempoPromedio(String tiempoPromedio) {
		this.tiempoPromedio = tiempoPromedio;
	}

	public String getIntentosPromedio() {
		return intentosPromedio;
	}

	public void setIntentosPromedio(String intentosPromedio) {
		this.intentosPromedio = intentosPromedio;
	}

	public Set<Alumno> getAlumno_idAlumno() {
		return Alumno_idAlumno;
	}

	public void setAlumno_idAlumno(Set<Alumno> alumno_idAlumno) {
		Alumno_idAlumno = alumno_idAlumno;
	}

	public Set<Juegos> getJuegos_idJuegos() {
		return Juegos_idJuegos;
	}

	public void setJuegos_idJuegos(Set<Juegos> juegos_idJuegos) {
		Juegos_idJuegos = juegos_idJuegos;
	}

}
