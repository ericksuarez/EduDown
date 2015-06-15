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
public class Palabras {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Key idPalabras;
	@Persistent
	Boolean esSilabas;
	@Persistent
	Boolean esRelacion;
	@Persistent
	String principal;
	@Persistent
	String correcta;
	@Persistent
	String erronea;
	@Persistent
	String erronea_2;

	public Key getIdPalabras() {
		return idPalabras;
	}

	public void setIdPalabras(Key idPalabras) {
		this.idPalabras = idPalabras;
	}

	public Boolean getEsRelacion() {
		return esRelacion;
	}

	public void setEsRelacion(Boolean esRelacion) {
		this.esRelacion = esRelacion;
	}

	public Boolean getEsSilabas() {
		return esSilabas;
	}

	public void setEsSilabas(Boolean esSilabas) {
		this.esSilabas = esSilabas;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getCorrecta() {
		return correcta;
	}

	public void setCorrecta(String correcta) {
		this.correcta = correcta;
	}

	public String getErronea() {
		return erronea;
	}

	public void setErronea(String erronea) {
		this.erronea = erronea;
	}

	public String getErronea_2() {
		return erronea_2;
	}

	public void setErronea_2(String erronea_2) {
		this.erronea_2 = erronea_2;
	}

}
