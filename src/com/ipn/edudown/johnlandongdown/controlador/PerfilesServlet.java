package com.ipn.edudown.johnlandongdown.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
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
import com.ipn.edudown.johnlandongdown.entidades.PMF;
import com.ipn.edudown.johnlandongdown.entidades.Profesor;
import com.ipn.edudown.johnlandongdown.entidades.ProfesorEndpoint;
import com.ipn.edudown.johnlandongdown.helper.Helper;

/**
 * @author erick
 */
@SuppressWarnings("serial")
public class PerfilesServlet extends HttpServlet {

	GradoEndpoint gep = new GradoEndpoint();
	MateriaEndpoint mep = new MateriaEndpoint();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String tipoAlta = req.getParameter("alta");
		req.setAttribute("alta","alta");
		
		List<Grado> grados = gep.listGrado(null);
		req.setAttribute("grados", grados);

		if ("alumno".equals(tipoAlta)) {
			req.getRequestDispatcher("altaAlumno.jsp").forward(req, resp);
		} else {
			List<Materia> materias = mep.listMateria(null);
			req.setAttribute("materias", materias);
			req.getRequestDispatcher("altaProfesor.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<Grado> grados = gep.listGrado(null);
		req.setAttribute("grados", grados);
		req.setAttribute("alta","alta");

		Form_validation validarDatos = new Form_validation();

		String tipoAlta = req.getParameter("alta");
		String grado = req.getParameter("grado");

		if ("alumno".equals(tipoAlta)) {

			Alumno alumno = beanAlumno(req);
			Grado grado_idGrado = new GradoEndpoint().getGrado(new Helper().limpiaID("Grado", grado));
			alumno.setGrado_idGrado(grado_idGrado);

			if (existeUsuario(alumno) == false
					&& validarDatos.alumno(alumno) == null) {

				new AlumnoEndpoint().insertAlumno(alumno);
				req.setAttribute("acierto", "El alumno se ingreso con èxito.");
			} else {
				req.setAttribute(
						"error",
						(validarDatos.alumno(alumno) == null) ? "El alumno ya esta registrado."
								: validarDatos.alumno(alumno));
			}
			req.getRequestDispatcher("altaAlumno.jsp").forward(req, resp);

		} else {

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

			Profesor profesor = beanProfesor(req);
			profesor.setGrado_idGrado(grado_idGrado);
			profesor.setMateria_idMateria(materia_idMateria);

			if (existeUsuario(profesor) == false
					&& validarDatos.profesor(profesor) == null) {

				new ProfesorEndpoint().insertProfesor(profesor);
				req.setAttribute("acierto", "El profesor se ingreso con èxito.");
			} else {
				req.setAttribute(
						"error",
						(validarDatos.profesor(profesor) == null) ? "El profesor ya esta registrado."
								: validarDatos.profesor(profesor));
			}

			List<Materia> materias = mep.listMateria(null);
			req.setAttribute("materias", materias);

			req.getRequestDispatcher("altaProfesor.jsp").forward(req, resp);

		}

	}

	protected boolean existeUsuario(Object obj) {

		PersistenceManager mgr = PMF.get().getPersistenceManager();
		List<Object> list = null;

		if (obj instanceof Alumno) {
			Alumno al = (Alumno) obj;
			Query q = mgr.newQuery(Alumno.class,
					"usuario == '" + al.getUsuario() + "'");

			list = (List<Object>) q.execute();
		} else {
			Profesor pro = (Profesor) obj;
			Query q = mgr.newQuery(Profesor.class,
					"email == '" + pro.getEmail() + "'");

			list = (List<Object>) q.execute();
		}
		mgr.close();

		return (list.size() == 0) ? false : true;
	}

	protected Alumno beanAlumno(HttpServletRequest req) {

		long time = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(time);

		String nombre = req.getParameter("nombre");
		String apaterno = req.getParameter("apaterno");
		String amaterno = req.getParameter("amaterno");
		String usuario = req.getParameter("usuario");

		Alumno alumno = new Alumno();

		alumno.setNombre(nombre);
		alumno.setApaterno(apaterno);
		alumno.setAmaterno(amaterno);
		alumno.setUsuario(usuario);
		alumno.setFecha_alta(date);

		return alumno;
	}

	protected Profesor beanProfesor(HttpServletRequest req) {

		long time = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(time);

		String nombre = req.getParameter("nombre");
		String apaterno = req.getParameter("apaterno");
		String amaterno = req.getParameter("amaterno");
		String email = req.getParameter("email");
		String especialidad = req.getParameter("especialidad");

		Profesor profesor = new Profesor();
		profesor.setNombre(nombre);
		profesor.setApaterno(apaterno);
		profesor.setAmaterno(amaterno);
		profesor.setEmail(email);
		profesor.setEspecialidad(especialidad);
		profesor.setFecha_alta(date);

		return profesor;
	}
}
