package com.ipn.edudown.johnlandongdown.config;

import com.ipn.edudown.johnlandongdown.entidades.Alumno;
import com.ipn.edudown.johnlandongdown.entidades.Juegos;
import com.ipn.edudown.johnlandongdown.entidades.Profesor;

public class Form_validation {
	private static final String iconError = "<i class='fa fa-question-circle'></i>";

	public String alumno(Alumno al) {

		int cnt = 0;
		int campos = 4; //numero de campos que se van a validar
		String resp = "";
		resp += req(al.getNombre()) ? requerido("Nombre") : cnt++;
		resp += req(al.getApaterno()) ? requerido("Apellido Paterno") : cnt++;
		resp += req(al.getAmaterno()) ? requerido("Apellido Materno") : cnt++;
		resp += req(al.getUsuario()) ? requerido("Apellido Usuario") : cnt++;
		
		return (cnt == campos) ? "null" : resp;
	}

	public String profesor(Profesor prof) {

		int cnt = 0;
		int campos = 5; //numero de campos que se van a validar
		String resp = "";
		resp += req(prof.getNombre()) ? requerido("Nombre") : cnt++ ;
		resp += req(prof.getApaterno()) ? requerido("Apellido Paterno") : cnt++;
		resp += req(prof.getAmaterno()) ? requerido("Apellido Materno") : cnt++;
		resp += req(prof.getEspecialidad()) ? requerido("Especialidad"): cnt++;
		resp += req(prof.getEmail()) ? requerido("Email") : cnt++;

		return (cnt == campos) ? "null" : resp;
	}
	
	public String juegos(Juegos juego) {

		int cnt = 0;
		int campos = 4; //numero de campos que se van a validar
		String resp = "";
		resp += req(juego.getNombre()) ? requerido("Nombre") : cnt++ ;
		resp += req(juego.getTiempo()) ? requerido("Tiempo") : cnt++;
		resp += req(juego.getIconJuego()) ? requerido("Tipo de juego") : cnt++;
		resp += req(juego.getCampoSemantico_idCampoSemantico().getSemantico()) ? requerido("Campo Semantico") : cnt++;

		return (cnt == campos) ? "null" : resp;
	}
	
	//Validaro de campo Requerido
	public boolean req(String s){
		if(s.isEmpty() || s.equals(" ") || s.equals("")){
			return true;
		}else{
			return false;
		}
	}
	
	public String requerido(String campo){
		return  iconError + "El campo " + campo + " es requerido. <br>";
	}

}
