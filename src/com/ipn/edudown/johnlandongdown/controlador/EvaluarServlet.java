package com.ipn.edudown.johnlandongdown.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipn.edudown.johnlandongdown.entidades.Alumno;
import com.ipn.edudown.johnlandongdown.entidades.AlumnoEndpoint;
import com.ipn.edudown.johnlandongdown.helper.Helper;

public class EvaluarServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String alu = req.getParameter("alumno");
		
		Alumno alumno = new AlumnoEndpoint().getAlumno(Long
					.parseLong(new Helper().limpiaID("Alumno", alu)));
		
		req.setAttribute("alumno", alumno);
		req.getRequestDispatcher("detalle.jsp").forward(req, resp);
	}

}
