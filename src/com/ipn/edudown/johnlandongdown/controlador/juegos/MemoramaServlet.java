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
import com.ipn.edudown.johnlandongdown.entidades.AvanceEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.CampoSemantico;
import com.ipn.edudown.johnlandongdown.entidades.Imagenes;
import com.ipn.edudown.johnlandongdown.entidades.Juegos;
import com.ipn.edudown.johnlandongdown.entidades.JuegosEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Palabras;
import com.ipn.edudown.johnlandongdown.entidades.PalabrasEndpoint;
import com.ipn.edudown.johnlandongdown.helper.Helper;

@SuppressWarnings("serial")
public class MemoramaServlet extends HttpServlet {

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
		} else {
			try {
				startJuegoPalabra(req, resp);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

		req.getRequestDispatcher("memorama.jsp").forward(req, resp);
		;
	}

	public void startJuego(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, JSONException {

		MatchImagenServlet matImg = new MatchImagenServlet();

		String idjuego = req.getParameter("juego");
		String semantico = req.getParameter("semantico");
		req.setAttribute("semantico", semantico);

		Juegos actual = null;
		actual = jep.getJuegos(helper.limpiaID("Juegos", idjuego));

		matImg.actualizaAvance(req);
		Alumno al = (Alumno) req.getSession().getAttribute("sesionAlumno");

		List<Imagenes> imagenes = actual.getImagenes_idImagenes();
		addjsonImagenes(req, imagenes);

		matImg.addjsonAlumnoJuego(req, al, actual);

	}

	public void startJuegoPalabra(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException,
			JSONException {

		MatchImagenServlet matImg = new MatchImagenServlet();

		String idjuego = req.getParameter("juego");
		String semantico = req.getParameter("semantico");
		req.setAttribute("semantico", semantico);

		Juegos actual = null;
		actual = jep.getJuegos(helper.limpiaID("Juegos", idjuego));

		matImg.actualizaAvance(req);
		Alumno al = (Alumno) req.getSession().getAttribute("sesionAlumno");

		List<Imagenes> imagenes = actual.getImagenes_idImagenes();
		addjsonPalabra(req, imagenes);

		matImg.addjsonAlumnoJuego(req, al, actual);

	}

	public void addjsonPalabra(HttpServletRequest req, List<Imagenes> img) {

		String jsons = "";
		int i = 0;
		for (Imagenes im : img) {
			i++;
			JSONObject jsonPala = helper.jsonWordLine(im.getNombre(), i);
			jsons += jsonPala.toString() + ";";
		}
			
		req.setAttribute("jsonMedia", jsons);
	}

	public void addjsonImagenes(HttpServletRequest req, List<Imagenes> img) {
		String jsons = "";
		int i = 0;
		for (Imagenes im : img) {
			i++;
			JSONObject jsonImg = helper.jsonImgLine(im, i);
			jsons += jsonImg.toString() + ";";
		}
		req.setAttribute("jsonMedia", jsons);
	}

	public List<Juegos> separaJuegos(HttpServletRequest req) {

		String semantico = req.getParameter("semantico");
		req.setAttribute("semantico", semantico);

		List<Juegos> juegos = jep.listJuegos(null);
		List<Juegos> porSemantico = new ArrayList<Juegos>();
		List<Juegos> porTipo = new ArrayList<Juegos>();

		for (Juegos ju : juegos) {
			CampoSemantico cs = ju.getCampoSemantico_idCampoSemantico();
			if (semantico.equals(cs.getSemantico())) {
				porSemantico.add(ju);
			}
		}

		for (Juegos ju : porSemantico) {
			if ("Relacionar palabra".equals(ju.getTipoJuego())) {
				porTipo.add(ju);
			}
		}
		return porTipo;
	}
}
