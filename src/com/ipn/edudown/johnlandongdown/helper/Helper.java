package com.ipn.edudown.johnlandongdown.helper;

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
		
		try{
			idLong = Long.parseLong(ID);
		}catch(NumberFormatException e){
			String s = quitarObject(classID);
			idLong = Long.parseLong(s);
		}
		
		return idLong;
	}
	
	protected String quitarObject(String classID){
		String id = null;
		int pos = classID.indexOf('/');
		id = classID.substring(++pos);
		return id.trim();
	}
}
