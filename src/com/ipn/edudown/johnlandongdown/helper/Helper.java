package com.ipn.edudown.johnlandongdown.helper;

public class Helper {
	
	public Long limpiaID(String clase, String classID) {
		
		String ID = null;
		char letras[] = clase.toCharArray();

		for (int i = 0; i < letras.length; i++) {
			classID = classID.replace(letras[i], ' ');
		}
		classID = classID.replace('(', ' ');
		classID = classID.replace(')', ' ');
		
		ID = classID.trim();
		
		return Long	.parseLong(ID);
	}
}
