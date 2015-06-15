package com.ipn.edudown.johnlandongdown.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipn.edudown.johnlandongdown.entidades.Alumno;
import com.ipn.edudown.johnlandongdown.entidades.Juegos;
import com.ipn.edudown.johnlandongdown.entidades.JuegosEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Profesor;

@SuppressWarnings("serial")
public class UpdateJuegoServlet extends HttpServlet {

	JuegosEndpoint jep = new JuegosEndpoint();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String accion = req.getParameter("accion");

		if ("alta".equals(accion)) {
			req.setAttribute("alta", "alta");
			req.getRequestDispatcher("altaWordJuegos.jsp").forward(req, resp);
		}
		
		/*List<Juegos> juegos = jep.listJuegos(null);
		req.setAttribute("juegos", juegos);
		req.getRequestDispatcher("alta.jsp").forward(req, resp);*/
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
