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

	public JSONObject jsonWord(String s, int i)
			throws JSONException {
		JSONObject json = new JSONObject();
		
		json.put("id", i);
		json.put("silaba", s);
		json.put("url", "images/" + "fondo-letra.png");
		
		return json;
	}

	public JSONObject jsonImg(Imagenes img, int i) throws JSONException {
			
			JSONObject json = new JSONObject();
			json.put("id", i);
			json.put("silaba", "");
			json.put("url", "images/" + img.getNombre());

		return json;
	}
	
	public JSONObject jsonWordLine(String s, int i)
			throws JSONException {
		JSONObject json = new JSONObject();
		
		String x = null;
		json.put("id", i);
		json.put("silaba", s);
		json.put("linea", x);
		json.put("url", "images/" + "fondo-letra.png");
		
		return json;
	}

	public JSONObject jsonImgLine(Imagenes img, int i) throws JSONException {
			
			String s = null;
			JSONObject json = new JSONObject();
			json.put("id", i);
			json.put("linea", "null");
			json.put("url", "images/" + img.getNombre());

		return json;
	}

	public Integer tiempo(String tiempo, int pos){
		Integer time = 0;
		String[] reloj = tiempo.split(":");
		time = Integer.valueOf(reloj[pos].trim());
		return time;
	}
}
