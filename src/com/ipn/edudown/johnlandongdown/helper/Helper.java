package com.ipn.edudown.johnlandongdown.helper;

import org.json.*;

import com.ipn.edudown.johnlandongdown.entidades.Imagenes;

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

	public JSONObject jsonWord(String s, int i, String opc)
			throws JSONException {
		JSONObject json = new JSONObject();

		json.put("id", i);
		json.put("silaba", s);
		json.put("url", "images/" + opc);

		return json;
	}

	public JSONObject jsonImg(Imagenes img, int i) throws JSONException {

		JSONObject json = new JSONObject();
		json.put("id", i);
		json.put("silaba", "");
		json.put("url", "images/" + img.getNombre());

		return json;
	}

	public JSONObject jsonWordLine(String s, int i) throws JSONException {

		JSONObject json = new JSONObject();

		json.put("id", i);
		json.put("silaba", s);
		json.put("linea", "null");
		json.put("url", "images/" + "fondo-letra.png");

		return json;
	}

	public JSONObject jsonImgLine(Imagenes img, int i) throws JSONException {

		JSONObject json = new JSONObject();

		json.put("id", i);
		json.put("silaba", "");
		json.put("linea", "null");
		json.put("url", "images/" + img.getNombre());

		return json;
	}

	public Integer tiempo(String tiempo, int pos) {
		Integer time = 0;
		String[] reloj = tiempo.split(":");
		time = Integer.valueOf(reloj[pos].trim());
		return time;
	}

	public JSONObject jsonEstadistica(String semantico, Integer scoreideal,
			Integer scoreavacne) throws JSONException {

		JSONObject json = new JSONObject();

		json.put("semantico", semantico);
		json.put("ideal", scoreideal);
		json.put("avance", scoreavacne);

		return json;
	}

	public String completaWord(String palabra) {
		String complete = "";
		char letras[] = palabra.toCharArray();

		for (int i = 0; i < letras.length; i++) {
			if (letras[i] != '-') {
				complete += Character.toString(letras[i]);
			}
		}
		return complete + ".png";
	}

	public String sinvocal(String palabra) {
		String complete = "";
		char letras[] = palabra.toCharArray();
		boolean quitar = false;
		
		for (int i = 0; i < letras.length; i++) {
			if (letras[i] != '-' && !quitar) {
				complete += Character.toString(letras[i]);
			}else{
				quitar = true;
				complete += "_";
			}
		}
		return complete;
	}

}
