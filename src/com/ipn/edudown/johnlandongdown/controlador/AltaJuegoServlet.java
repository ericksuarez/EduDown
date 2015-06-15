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
import com.ipn.edudown.johnlandongdown.entidades.CampoSemantico;
import com.ipn.edudown.johnlandongdown.entidades.CampoSemanticoEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Juegos;
import com.ipn.edudown.johnlandongdown.entidades.JuegosEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Materia;
import com.ipn.edudown.johnlandongdown.entidades.MateriaEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Palabras;
import com.ipn.edudown.johnlandongdown.entidades.Profesor;
import com.ipn.edudown.johnlandongdown.helper.Helper;

@SuppressWarnings("serial")
public class AltaJuegoServlet extends HttpServlet {

	JuegosEndpoint jep = new JuegosEndpoint();
	MateriaEndpoint mep = new MateriaEndpoint();
	CampoSemanticoEndpoint csep = new CampoSemanticoEndpoint();
	Helper helper = new Helper();

	List<CampoSemantico> camposemantico = csep.listCampoSemantico(null);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setAttribute("camposemantico", camposemantico);

		String accion = req.getParameter("accion");

		if ("alta".equals(accion)) {
			req.getRequestDispatcher("altaWordJuegos.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Form_validation form_validation = new Form_validation();
		req.setAttribute("camposemantico", camposemantico);
		
		Juegos juego = beanJuego(req);

		if (form_validation.juegos(juego) == "null") {
			guardarJuego(req, juego);
			req.setAttribute("acierto",
					"Las palabras del juego se han guardado correctamente.");
		} else {
			req.setAttribute("error",
					"Se han presentado los siguientes errores.<br>"
							+ form_validation.juegos(juego));
		}
		
		req.getRequestDispatcher("altaWordJuegos.jsp").forward(req, resp);
	}

	public Juegos beanJuego(HttpServletRequest req) {
		Juegos juego = new Juegos();

		String nombre = req.getParameter("nombre");
		String tiempo = req.getParameter("tiempo");
		String iconJuego = req.getParameter("iconjuego");
		String camposemantico = req.getParameter("camposemantico");

		CampoSemantico cs = csep.getCampoSemantico(helper.limpiaID(
				"CampoSemantico", camposemantico));
		
		juego.setNombre(nombre);
		juego.setTiempo(tiempo);
		juego.setIconJuego(iconJuego);
		juego.setCampoSemantico_idCampoSemantico(cs);

		return juego;
	}

	public void guardarJuego(HttpServletRequest req, Juegos juego) {
		
		String isSilabas = req.getParameter("isSilabas");
		String isRelacion = req.getParameter("isRelacion");			

		if ("activo".equals(isSilabas) && "inactivo".equals(isRelacion)) {
			Palabras palabra = beanPalabra(req, true);
			juego.setPalabras_idPalabras(palabra);
			juego.setTipoJuego("Completar palabra");
			palabra.setEsRelacion(false);
			palabra.setEsSilabas(true);
		}
		if ("inactivo".equals(isSilabas) && "activo".equals(isRelacion)) {
			Palabras palabra = beanPalabra(req, false);
			juego.setPalabras_idPalabras(palabra);	
			juego.setTipoJuego("Relacionar palabra");
			palabra.setEsRelacion(true);
			palabra.setEsSilabas(false);
		}
		
		jep.insertJuegos(juego);
	}

	public Palabras beanPalabra(HttpServletRequest req, boolean tipo) {
		String[] palabras = req.getParameterValues("palabras[]");
		Palabras palabra = new Palabras();

		if (tipo == true) {
			palabra.setPrincipal(palabras[0]);
			palabra.setCorrecta(palabras[1]);
			palabra.setErronea(palabras[2]);
			palabra.setErronea_2(palabras[3]);
		} else {
			palabra.setPrincipal(palabras[4]);
			palabra.setCorrecta(palabras[5]);
			palabra.setErronea(palabras[6]);
			palabra.setErronea_2("---");
		}
		return palabra;
	}
}
