package com.ipn.edudown.johnlandongdown.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipn.edudown.johnlandongdown.entidades.AlumnoEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Alumno;

public class SupervisarServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Alumno> alumnos = new AlumnoEndpoint().listAlumno(null);
		req.setAttribute("alumnos", alumnos);
		req.getRequestDispatcher("home.jsp").forward(req, resp);
		
	}

}
