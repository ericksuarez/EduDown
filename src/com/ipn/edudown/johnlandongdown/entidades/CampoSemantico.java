package com.ipn.edudown.johnlandongdown.entidades;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class CampoSemantico {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Key idCampo;
	@Persistent
	String semantico;
	@Persistent
	String imagenIcono;
	@Persistent
	String sonido;

	public Key getIdCampo() {
		return idCampo;
	}

	public void setIdCampo(Key idCampo) {
		this.idCampo = idCampo;
	}

	public String getSemantico() {
		return semantico;
	}

	public void setSemantico(String semantico) {
		this.semantico = semantico;
	}

	public String getImagenIcono() {
		return imagenIcono;
	}

	public void setImagenIcono(String imagenIcono) {
		this.imagenIcono = imagenIcono;
	}

	public String getSonido() {
		return sonido;
	}

	public void setSonido(String sonido) {
		this.sonido = sonido;
	}

}
