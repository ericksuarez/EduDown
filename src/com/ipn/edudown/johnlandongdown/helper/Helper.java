package com.ipn.edudown.johnlandongdown.helper;

import java.util.Set;

import org.json.*;
import com.ipn.edudown.johnlandongdown.entidades.Imagenes;
import com.ipn.edudown.johnlandongdown.entidades.Juegos;

public class Helper {

	public Long limpiaID(String clase, String classID) {

		Long idLong = 0L;
		String ID = null;
		char letras[] = clase.toCharArray();

		for (int i = 0; i < letras.length; i++) {
			classID = classID.replace(letras[i], ' ');
		}
		classID = classID.replace('(', ' ');
		classID = classID.replace(')', ' ');

		ID = classID.trim();

		try {
			idLong = Long.parseLong(ID);
		} catch (NumberFormatException e) {
			String s = quitarObject(classID);
			idLong = Long.parseLong(s);
		}

		return idLong;
	}

	protected String quitarObject(String classID) {
		String id = null;
		int pos = classID.indexOf('/');
		id = classID.substring(++pos);
		return id.trim();
	}

	public JSONObject jsonWord(JSONObject json, String s, int i)
			throws JSONException {
		json.put("id", i);
		json.put("silaba",  s);
		json.put("url", "images/" + "fondo-letra.png");
		return json;
	}

	public JSONObject jsonImg(JSONObject json, Juegos j) throws JSONException {

		Set<Imagenes> imgs = j.getImagenes_idImagenes();
		int cnt = 1;
		
		for (Imagenes img : imgs) {
			json.put("id", cnt++);
			json.put("silaba", "");
			json.put("url", "images/" + img.getNombre());
		}

		return json;
	}
}
