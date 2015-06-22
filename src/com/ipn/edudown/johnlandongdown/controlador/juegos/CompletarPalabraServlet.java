package com.ipn.edudown.johnlandongdown.controlador.juegos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.ipn.edudown.johnlandongdown.entidades.Alumno;
import com.ipn.edudown.johnlandongdown.entidades.Avance;
import com.ipn.edudown.johnlandongdown.entidades.AvanceEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.CampoSemantico;
import com.ipn.edudown.johnlandongdown.entidades.Imagenes;
import com.ipn.edudown.johnlandongdown.entidades.Juegos;
import com.ipn.edudown.johnlandongdown.entidades.JuegosEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Palabras;
import com.ipn.edudown.johnlandongdown.entidades.PalabrasEndpoint;
import com.ipn.edudown.johnlandongdown.helper.Helper;

@SuppressWarnings("serial")
public class CompletarPalabraServlet extends HttpServlet {
	JuegosEndpoint jep = new JuegosEndpoint();
	AvanceEndpoint aep = new AvanceEndpoint();
	PalabrasEndpoint pep = new PalabrasEndpoint();
	Helper helper = new Helper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String inicio = req.getParameter("inicio");

		if ("inicio".equals(inicio)) {
			try {
				startJuego(req, resp);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}else{
			try {
				siguienteJuego(req, resp);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

		req.getRequestDispatcher("matchWord.jsp").forward(req, resp);
	}

	public void startJuego(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, JSONException {

		MatchImagenServlet matchimg = new MatchImagenServlet();
		
		String idjuego = req.getParameter("juego");
		String semantico = req.getParameter("semantico");
		req.setAttribute("semantico", semantico);

		Juegos actual = null;
		actual = jep.getJuegos(helper.limpiaID("Juegos", idjuego));

		matchimg.actualizaAvance(req);
		Alumno al = (Alumno) req.getSession().getAttribute("sesionAlumno");

		addjsonPalabra(req,actual);

		matchimg.addjsonAlumnoJuego(req,al,actual);

	}
	
	public void siguienteJuego(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, JSONException {
		
		MatchImagenServlet matchimg = new MatchImagenServlet();
		
		String idjuego = req.getParameter("juego");
		String semantico = req.getParameter("semantico");
		req.setAttribute("semantico", semantico);
		
		Juegos actual = new Juegos();
		Juegos j = null;
		actual = jep.getJuegos(helper.limpiaID("Juegos", idjuego));
		
		matchimg.actualizaAvance(req);
		Alumno al = (Alumno) req.getSession().getAttribute("sesionAlumno");

		j = matchimg.buscaJuego(req,actual,"Completar palabra");
		addjsonPalabra(req,j);

		matchimg.addjsonAlumnoJuego(req,al,j);
			
	}
	
	public void addjsonPalabra(HttpServletRequest req, Juegos j){
		Palabras p = j.getPalabras_idPalabras();
		req.setAttribute("jsonMedia", helper.jsonWord(p.getPrincipal(), 1).toString() + ";"
								+ helper.jsonWord(p.getCorrecta(), 2).toString() + ";"
								+ helper.jsonWord(p.getCorrecta(), 3).toString() + ";"
								+ helper.jsonWord(p.getErronea_2(), 4).toString());
	}
}
