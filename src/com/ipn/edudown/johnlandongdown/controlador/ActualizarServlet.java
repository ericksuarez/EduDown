package com.ipn.edudown.johnlandongdown.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipn.edudown.johnlandongdown.config.Form_validation;
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
	ProfesorEndpoint pep = new ProfesorEndpoint();
	AlumnoEndpoint aep = new AlumnoEndpoint();
	Helper helper = new Helper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<Profesor> profesores = new ProfesorEndpoint().listProfesor(null);
		List<Alumno> alumnos = new AlumnoEndpoint().listAlumno(null);
		
		String editar = req.getParameter("editar");
		String detalle = req.getParameter("detalle");
		String eliminar = req.getParameter("eliminar");

		if ("alumno".equals(editar) && detalle.length() == 0) {
			req.setAttribute("alumnos", alumnos);
			req.getRequestDispatcher("updateAlumno.jsp").forward(req, resp);
		}
		if ("profesor".equals(editar) && detalle.length() == 0) {
			req.setAttribute("profesores", profesores);
			req.getRequestDispatcher("updateProfesor.jsp").forward(req, resp);
		}

		if ("alumno".equals(editar) && detalle.length() > 0) {
			
			if ("si".equals(eliminar)) {
				eliminarAlumno(detalle);
				List<Alumno> alumnosAct = new AlumnoEndpoint().listAlumno(null);
				req.setAttribute("alumnos", alumnosAct);
				req.setAttribute("acierto", "El alumno se elimino con éxito.");
				req.getRequestDispatcher("updateAlumno.jsp").forward(req, resp);
			}else{
				detalleAlumno(req, resp);
			}
		}
		if ("profesor".equals(editar) && detalle.length() > 0) {
			
			if ("si".equals(eliminar)) {
				eliminarProfesor(detalle);
				List<Profesor> profesoresAct = new ProfesorEndpoint().listProfesor(null);
				req.setAttribute("profesores", profesoresAct);
				req.setAttribute("acierto", "El profesor se elimino con éxito.");
				req.getRequestDispatcher("updateProfesor.jsp").forward(req, resp);
			}else{
				detalleProfesor(req, resp);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Form_validation form_run = new Form_validation();	
		
		String tipoAlta = req.getParameter("alta");

		PerfilesServlet perfil = new PerfilesServlet();
		Alumno alumno = perfil.beanAlumno(req);
		Profesor profesor = perfil.beanProfesor(req);

		if ("alumno".equals(tipoAlta)) {
			
			if (form_run.alumno(alumno) == "null") {
				req.setAttribute("acierto",
						"La información del alumno se actualizo con éxito.");
				actulizarAlumno(req, alumno);
				
				List<Alumno> alumnos = new AlumnoEndpoint().listAlumno(null);
				req.setAttribute("alumnos", alumnos);
				req.getRequestDispatcher("updateAlumno.jsp").forward(req, resp);
				
			} else {
				req.setAttribute("error", "Se han presentado los siguientes errores. <br>" + form_run.alumno(alumno) );
				detalleAlumno(req, resp);				
			}

		}

		if ("profesor".equals(tipoAlta)) {
			
			if (form_run.profesor(profesor) == "null") {
				req.setAttribute("acierto",
						"La información del profesor se actualizo con éxito.");
				actulizarProfesor(req, profesor);
				
				List<Profesor> profesores = new ProfesorEndpoint().listProfesor(null);
				req.setAttribute("profesores", profesores);
				req.getRequestDispatcher("updateProfesor.jsp").forward(req, resp);
				
			} else {
				req.setAttribute("error", "Se han presentado los siguientes errores. <br>" + form_run.profesor(profesor));
				detalleProfesor(req, resp);
			}

		}

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

	public void eliminarAlumno(String id) {
		aep.removeAlumno(helper.limpiaID("Alumno", id));
	}

	public void eliminarProfesor(String id) {
		pep.removeProfesor(helper.limpiaID("Profesor", id));
	}

	public void actulizarAlumno(HttpServletRequest req, Alumno alumno) {

		String idLong = req.getParameter("idLong");
		String grado = req.getParameter("grado");

		Alumno al = aep.getAlumno(helper.limpiaID("Alumno", idLong));
		Grado g = new GradoEndpoint().getGrado(helper.limpiaID("Grado", grado));

		alumno.setIdAlumno(al.getIdAlumno());
		alumno.setGrado_idGrado(g);

		aep.updateAlumno(alumno);
	}

	public void actulizarProfesor(HttpServletRequest req, Profesor profesor) {

		String idLong = req.getParameter("idLong");
		String[] idsmateria = req.getParameterValues("materias[]");
		String[] idsgrado = req.getParameterValues("grados[]");

		List<Grado> grado_idGrado = new ArrayList<Grado>();
		for (int i = 0; i < idsgrado.length; i++) {
			grado_idGrado
					.add(new GradoEndpoint().getGrado(new Helper().limpiaID("Grado",
									idsgrado[i])));
		}
		List<Materia> materia_idMateria = new ArrayList<Materia>();
		for (int i = 0; i < idsmateria.length; i++) {
			materia_idMateria.add(new MateriaEndpoint().getMateria(new Helper().limpiaID("Materia",
							idsmateria[i])));
		}

		Profesor pro = pep.getProfesor(helper.limpiaID("Profesor", idLong));
		profesor.setIdProfesor(pro.getIdProfesor());
		profesor.setGrado_idGrado(grado_idGrado);
		profesor.setMateria_idMateria(materia_idMateria);
		
		pep.updateProfesor(profesor);
	}

}
