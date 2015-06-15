package com.ipn.edudown.johnlandongdown.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipn.edudown.johnlandongdown.config.Form_validation;
import com.ipn.edudown.johnlandongdown.entidades.CampoSemantico;
import com.ipn.edudown.johnlandongdown.entidades.CampoSemanticoEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Juegos;
import com.ipn.edudown.johnlandongdown.entidades.JuegosEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Palabras;
import com.ipn.edudown.johnlandongdown.helper.Helper;

@SuppressWarnings("serial")
public class ActualizarJuegoServlet extends HttpServlet {

	JuegosEndpoint jep = new JuegosEndpoint();
	CampoSemanticoEndpoint csep = new CampoSemanticoEndpoint();
	Helper helper = new Helper();
	
	List<CampoSemantico> camposemantico = csep.listCampoSemantico(null);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setAttribute("camposemantico", camposemantico);
		
		List<Juegos> juegos = jep.listJuegos(null);
		req.setAttribute("juegos", juegos);
		req.getRequestDispatcher("actualizarjuego.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Form_validation form_validation = new Form_validation();
		
		List<Juegos> juegos = jep.listJuegos(null);
		req.setAttribute("juegos", juegos);
		req.setAttribute("camposemantico", camposemantico);
		
		Juegos juego = new AltaJuegoServlet().beanJuego(req);

		if (form_validation.juegos(juego) == "null") {
			actualizarJuego(req, juego);
			req.setAttribute("acierto",
					"Las palabras del juego se han actualizado correctamente.");
		} else {
			req.setAttribute("error",
					"Se han presentado los siguientes errores.<br>"
							+ form_validation.juegos(juego));
		}
		
		req.getRequestDispatcher("actualizarjuego.jsp").forward(req, resp);
		
	}
	
	private void actualizarJuego(HttpServletRequest req, Juegos juego){
		String isSilabas = req.getParameter("isSilabas");
		String isRelacion = req.getParameter("isRelacion");	
		String idLong = req.getParameter("idLong");

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
		
		Juegos j = jep.getJuegos(helper.limpiaID("Juegos", idLong));
		juego.setIdJuegos(j.getIdJuegos());
		jep.updateJuegos(juego);
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
			palabra.setPrincipal(palabras[0]);
			palabra.setCorrecta(palabras[1]);
			palabra.setErronea(palabras[2]);
			palabra.setErronea_2("---");
		}
		return palabra;
	}
}
