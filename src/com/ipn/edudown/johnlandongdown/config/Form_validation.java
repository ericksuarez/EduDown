package com.ipn.edudown.johnlandongdown.config;

import com.ipn.edudown.johnlandongdown.entidades.Alumno;
import com.ipn.edudown.johnlandongdown.entidades.Profesor;

public class Form_validation {
	private static final String iconError = "<i class='fa fa-question-circle'></i>";

	public String alumno(Alumno al) {

		int cnt = 0;
		int campos = 4; //numero de campos que se van a validar
		String resp = "";
		resp += req(al.getNombre()) ? iconError + " El campo Nombre es requerido <br>" : cnt++;
		resp += req(al.getApaterno()) ?  iconError + " El campo Apellido Paterno es requerido <br>" : cnt++;
		resp += req(al.getAmaterno()) ?  iconError + " El campo Apellido Materno es requerido <br>" : cnt++;
		resp += req(al.getUsuario()) ? iconError + " El campo Usuario es requerido <br>" : cnt++;
		
		return (cnt == campos) ? "null" : resp;
	}

	public String profesor(Profesor prof) {

		int cnt = 0;
		int campos = 5; //numero de campos que se van a validar
		String resp = "";
		resp += req(prof.getNombre()) ?  iconError + " El campo Nombre es requerido <br>" : cnt++ ;
		resp += req(prof.getApaterno()) ?  iconError	+ " El campo Apellido Paterno es requerido <br>" : cnt++;
		resp += req(prof.getAmaterno()) ? iconError	+ " El campo Apellido Materno es requerido <br>" : cnt++;
		resp += req(prof.getEspecialidad()) ? iconError	+ " El campo Especialidad es requerido <br>" : cnt++;
		resp += req(prof.getEmail()) ?  iconError + " El campo Email es requerido <br>" : cnt++;

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

}
