package com.ipn.edudown.johnlandongdown.config;

import com.ipn.edudown.johnlandongdown.entidades.Alumno;
import com.ipn.edudown.johnlandongdown.entidades.Profesor;

public class Form_validation {
private static final String iconError = "<i class='fa fa-question-circle'></i>";
	
	public String alumno(Alumno al) {

		int cnt = 0;
		String resp = "";
		resp += (al.getNombre().length() > 0) ? cnt++ : iconError + " El campo Nombre es requerido <br>";
		resp += (al.getApaterno().length() > 0) ? cnt++ : iconError + " El campo Apellido Paterno es requerido <br>";
		resp += (al.getAmaterno().length() > 0) ? cnt++ : iconError + " El campo Apellido Materno es requerido <br>";
		resp += (al.getUsuario().length() > 0) ? cnt++ : iconError + " El campo Usuario es requerido <br>";
		
		return (cnt > 0) ? null : resp;
	}

	public String profesor(Profesor prof) {

		int cnt = 0;
		String resp = "";
		resp += (prof.getNombre().length() > 0) ? cnt++ : iconError + " El campo Nombre es requerido <br>";
		resp += (prof.getApaterno().length() > 0) ? cnt++ : iconError + " El campo Apellido Paterno es requerido <br>";
		resp += (prof.getAmaterno().length() > 0) ? cnt++ : iconError + " El campo Apellido Materno es requerido <br>";
		resp += (prof.getEspecialidad().length() > 0) ? cnt++ : iconError + " El campo Especialidad es requerido <br>";
		resp += (prof.getEmail().length() > 0) ? cnt++ : iconError + " El campo Email es requerido <br>";
		
		return (cnt > 0) ? null : resp;
	}
}
