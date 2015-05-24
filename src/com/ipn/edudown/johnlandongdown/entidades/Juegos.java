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
public class Juegos {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Key idJuegos;
	@Persistent
	String nombre;
	@Persistent
	String tiempo;
	@Persistent
	String iconJuego;
	@Persistent
	@Unowned
	Set<Materia> Materia_idMateria;
	@Persistent
	@Unowned
	CampoSemantico CampoSemantico_idCampoSemantico;
	@Persistent
	@Unowned
	Set<Palabras> Palabras_idPalabras;
	@Persistent
	@Unowned
	Set<Imagenes> Imagenes_idImagenes;

	public Key getIdJuegos() {
		return idJuegos;
	}

	public void setIdJuegos(Key idJuegos) {
		this.idJuegos = idJuegos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public Set<Materia> getMateria_idMateria() {
		return Materia_idMateria;
	}
	
	public String getIconJuego() {
		return iconJuego;
	}

	public void setIconJuego(String iconJuego) {
		this.iconJuego = iconJuego;
	}

	public void setMateria_idMateria(Set<Materia> materia_idMateria) {
		Materia_idMateria = materia_idMateria;
	}

	public CampoSemantico getCampoSemantico_idCampoSemantico() {
		return CampoSemantico_idCampoSemantico;
	}

	public void setCampoSemantico_idCampoSemantico(
			CampoSemantico campoSemantico_idCampoSemantico) {
		CampoSemantico_idCampoSemantico = campoSemantico_idCampoSemantico;
	}

	public Set<Palabras> getPalabras_idPalabras() {
		return Palabras_idPalabras;
	}

	public void setPalabras_idPalabras(Set<Palabras> palabras_idPalabras) {
		Palabras_idPalabras = palabras_idPalabras;
	}

	public Set<Imagenes> getImagenes_idImagenes() {
		return Imagenes_idImagenes;
	}

	public void setImagenes_idImagenes(Set<Imagenes> imagenes_idImagenes) {
		Imagenes_idImagenes = imagenes_idImagenes;
	}

}
