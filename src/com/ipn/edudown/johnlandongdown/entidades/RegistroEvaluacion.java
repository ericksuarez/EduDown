package com.ipn.edudown.johnlandongdown.entidades;

import java.sql.Date;
import java.util.List;
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
	String Alumno_idAlumno;
	@Persistent
	@Unowned
	List<String> Juegos_idJuegos;

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

	public String getAlumno_idAlumno() {
		return Alumno_idAlumno;
	}

	public void setAlumno_idAlumno(String alumno_idAlumno) {
		Alumno_idAlumno = alumno_idAlumno;
	}

	public List<String> getJuegos_idJuegos() {
		return Juegos_idJuegos;
	}

	public void setJuegos_idJuegos(List<String> juegos_idJuegos) {
		Juegos_idJuegos = juegos_idJuegos;
	}

}
