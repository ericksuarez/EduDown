package com.ipn.edudown.johnlandongdown.config;

import com.ipn.edudown.johnlandongdown.entidades.Alumno;
import com.ipn.edudown.johnlandongdown.entidades.Profesor;

public class Form_validation {
private static final String iconError = "<i class='fa fa-question-circle'></i>";
	
	public String alumno(Alumno al) {

		String resp = "";
		resp += (al.getNombre().length() > 0) ? null : iconError + " El campo Nombre es requerido <br>";
		resp += (al.getApaterno().length() > 0) ? null : iconError + " El campo Apellido paterno es requerido <br>";
		resp += (al.getAmaterno().length() > 0) ? null : iconError + " El campo Apellido materno es requerido <br>";
		
		return resp;
	}

	public String profesor(Profesor prof) {

		String resp = "";
		resp += (prof.getNombre().length() > 0) ? null : iconError + " El campo Nombre es requerido <br>";
		resp += (prof.getApaterno().length() > 0) ? null : iconError + " El campo Nombre es requerido <br>";
		resp += (prof.getAmaterno().length() > 0) ? null : iconError + " El campo Nombre es requerido <br>";
		resp += (prof.getEspecialidad().length() > 0) ? null : iconError + " El campo Nombre es requerido <br>";
		
		return resp;
	}
}
