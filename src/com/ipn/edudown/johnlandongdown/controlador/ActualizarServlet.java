package com.ipn.edudown.johnlandongdown.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipn.edudown.johnlandongdown.entidades.Alumno;
import com.ipn.edudown.johnlandongdown.entidades.AlumnoEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Grado;
import com.ipn.edudown.johnlandongdown.entidades.GradoEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Materia;
import com.ipn.edudown.johnlandongdown.entidades.MateriaEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Profesor;
import com.ipn.edudown.johnlandongdown.entidades.ProfesorEndpoint;
import com.ipn.edudown.johnlandongdown.helper.Helper;

@SuppressWarnings("serial")
public class ActualizarServlet extends HttpServlet {

	GradoEndpoint gep = new GradoEndpoint();
	MateriaEndpoint mep = new MateriaEndpoint();
	Helper helper = new Helper();
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String editar = req.getParameter("editar");
		String detalle = req.getParameter("detalle");
		String eliminar = req.getParameter("eliminar");

		if ("alumno".equals(editar) && detalle.length() == 0) {
			List<Alumno> alumnos = new AlumnoEndpoint().listAlumno(null);
			req.setAttribute("alumnos", alumnos);
			req.getRequestDispatcher("updateAlumno.jsp").forward(req, resp);
		}
		if ("profesor".equals(editar) && detalle.length() == 0) {
			List<Profesor> profesores = new ProfesorEndpoint()
					.listProfesor(null);
			req.setAttribute("profesores", profesores);
			req.getRequestDispatcher("updateProfesor.jsp").forward(req, resp);
		}

		if ("alumno".equals(editar) && detalle.length() > 0 ) {
			detalleAlumno(req, resp);
			if ("si".equals(eliminar)) {

			}
		}
		if ("profesor".equals(editar) && detalle.length() > 0) {
			detalleProfesor(req, resp);
			if ("si".equals(eliminar)) {

			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	public void detalleAlumno(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<Grado> grados = gep.listGrado(null);
		req.setAttribute("grados", grados);

		String idalumno = req.getParameter("detalle");
		Alumno alumno = new Alumno();
		AlumnoEndpoint aep = new AlumnoEndpoint();

		alumno = aep.getAlumno(new Helper().limpiaID("Alumno", idalumno));
		req.setAttribute("alumno", alumno);
		req.setAttribute("actualizar", "actualizar");
		req.getRequestDispatcher("altaAlumno.jsp").forward(req, resp);

	}

	public void detalleProfesor(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<Grado> grados = gep.listGrado(null);
		List<Materia> materias = mep.listMateria(null);

		req.setAttribute("materias", materias);
		req.setAttribute("grados", grados);

		String idprofesor = req.getParameter("detalle");
		Profesor profesor = new Profesor();
		ProfesorEndpoint pep = new ProfesorEndpoint();

		profesor = pep.getProfesor(helper.limpiaID("Profesor", idprofesor));
		req.setAttribute("profesor", profesor);
		req.setAttribute("actualizar", "actualizar");
		req.getRequestDispatcher("altaProfesor.jsp").forward(req, resp);

	}

}
