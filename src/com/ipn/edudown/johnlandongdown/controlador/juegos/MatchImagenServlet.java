package com.ipn.edudown.johnlandongdown.controlador.juegos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

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
public class MatchImagenServlet extends HttpServlet {

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

		req.getRequestDispatcher("matchImg.jsp").forward(req, resp);
	}

	public void startJuego(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, JSONException {

		String idjuego = req.getParameter("juego");
		String semantico = req.getParameter("semantico");
		req.setAttribute("semantico", semantico);

		Juegos actual = null;
		actual = jep.getJuegos(helper.limpiaID("Juegos", idjuego));

		actualizaAvance(req);
		Alumno al = (Alumno) req.getSession().getAttribute("sesionAlumno");

		try {
			addjsonPalabra(req,actual);
		} catch (NullPointerException e) {
			addjsonImagenes(req,actual);
		}

		addjsonAlumnoJuego(req,al,actual);

	}
	
	public void siguienteJuego(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, JSONException {
		
		String idjuego = req.getParameter("juego");
		String semantico = req.getParameter("semantico");
		req.setAttribute("semantico", semantico);
		
		Juegos actual = new Juegos();
		Juegos j = null;
		actual = jep.getJuegos(helper.limpiaID("Juegos", idjuego));
		
		actualizaAvance(req);
		Alumno al = (Alumno) req.getSession().getAttribute("sesionAlumno");

		try {
			j = buscaJuego(req,actual,"Relacionar palabra");
			addjsonPalabra(req,j);
		} catch (NullPointerException e) {
			j = buscaJuego(req,actual,"Relacionar imagen");
			addjsonImagenes(req,j);
		}

		addjsonAlumnoJuego(req,al,j);
			
	}

	public Juegos buscaJuego(HttpServletRequest req,Juegos actual, String tipoJuego) throws IOException {

		String semantico = req.getParameter("semantico");
		req.setAttribute("semantico", semantico);

		Juegos j = new Juegos();
		List<Juegos> juegos = jep.listJuegos(null);
		List<Juegos> tmp = new ArrayList<Juegos>();

		for (Juegos ju : juegos) {
			CampoSemantico cs = ju.getCampoSemantico_idCampoSemantico();
			if (semantico.equals(cs.getSemantico())) {
				tmp.add(ju);
			}
		}
		
		for (Juegos ju : tmp) {
			if (tipoJuego.equals(ju.getTipoJuego())) {
				if (ju.getIdJuegos() != actual.getIdJuegos()) {
					j = ju;
				} else {
					j = actual;
				}
			}
		}

		return j;
	}
	
	public void actualizaAvance(HttpServletRequest req){
		String idjuego = req.getParameter("juego");
		String avance = req.getParameter("avance");
		
		if (!avance.isEmpty()) {
			Alumno alu = (Alumno) req.getSession().getAttribute("sesionAlumno");
			Avance avanc = new Avance();
			avanc = aep.getAvance(helper.limpiaID("Avance", avance));
			avanc.setAlumno_idAlumno(String.valueOf(alu.getIdAlumno()));
			avanc.setJuegos_idJuegos("Juegos(" + idjuego + ")");
			aep.updateAvance(avanc);
		}
	}
	
	public void addjsonPalabra(HttpServletRequest req, Juegos j){
		Palabras p = j.getPalabras_idPalabras();
		req.setAttribute("jsonMedia", helper.jsonWord(p.getPrincipal(), 1, "fondo-letra.png").toString() + ";"
								+ helper.jsonWord(p.getCorrecta(), 2, "fondo-letra.png").toString() + ";"
								+ helper.jsonWord(p.getErronea(), 3, "fondo-letra.png").toString());
	}
	
	public void addjsonImagenes(HttpServletRequest req, Juegos actual){
		String jsons = "";
		int i = 0;
		Juegos j = null;
		j = actual;
		List<Imagenes> img = j.getImagenes_idImagenes();
		for (Imagenes im : img) {
			i++;
			JSONObject jsonImg = helper.jsonImg(im, i);
			jsons += jsonImg.toString() + ";";
		}
		req.setAttribute("jsonMedia", jsons);
	}
	
	public void addjsonAlumnoJuego(HttpServletRequest req,Alumno al, Juegos j){
		JSONObject jsonAlumno = new JSONObject(al);
		req.setAttribute("alumno", jsonAlumno.toString());

		JSONObject juego = new JSONObject(j);
		req.setAttribute("juego", juego.toString());
	}
}
