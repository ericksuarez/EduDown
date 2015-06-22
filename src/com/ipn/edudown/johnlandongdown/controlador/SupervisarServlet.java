package com.ipn.edudown.johnlandongdown.controlador;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipn.edudown.johnlandongdown.entidades.AlumnoEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Alumno;
import com.ipn.edudown.johnlandongdown.entidades.RegistroEvaluacion;
import com.ipn.edudown.johnlandongdown.entidades.RegistroEvaluacionEndpoint;

@SuppressWarnings("serial")
public class SupervisarServlet extends HttpServlet {

	RegistroEvaluacionEndpoint reep = new RegistroEvaluacionEndpoint();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Alumno> alumnos = new AlumnoEndpoint().listAlumno(null);
		req.setAttribute("alumnos", alumnos);
		req.getRequestDispatcher("home.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String alumno = req.getParameter("alumno");
		
		RegistroEvaluacion evaluacion = beanReEvaluacion(req);
		reep.insertRegistroEvaluacion(evaluacion);

		resp.sendRedirect("/evaluar?alumno=" + alumno);
	}

	public RegistroEvaluacion beanReEvaluacion(HttpServletRequest req){
		
		long time = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(time);
		
		String tiempoPromedio = req.getParameter("tiempoPromedio");
		String intentosPromedio = req.getParameter("intentosPromedio");
		String aprovado = req.getParameter("aprovado");
		String Juegos_idJuegos = req.getParameter("regGame");
		String alumno = req.getParameter("alumno");
		
		RegistroEvaluacion evaluacion = new RegistroEvaluacion();
		evaluacion.setFecha(date);
		evaluacion.setAprovado(aprovado);
		evaluacion.setIntentosPromedio(intentosPromedio);
		evaluacion.setTiempoPromedio(tiempoPromedio);
		evaluacion.setAlumno_idAlumno(alumno);
		
		String[] games = Juegos_idJuegos.split(",");
		List<String> idJuegos = new ArrayList<String>();
		for(int i = 0; i < games.length; i++){
			idJuegos.add(games[i]);
		}
		evaluacion.setJuegos_idJuegos(idJuegos);
		
		return evaluacion;
	}
	
}
