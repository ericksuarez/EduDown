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
	private String tipoJuego = "";
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
		}

		req.getRequestDispatcher("matchWord.jsp").forward(req, resp);
	}

	public void startJuego(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, JSONException {

		String idjuego = req.getParameter("juego");
		String avance = req.getParameter("avance");
		Juegos actual = new Juegos();
		Juegos j = null;
		actual = jep.getJuegos(helper.limpiaID("Juegos", idjuego));

		if (!avance.isEmpty()) {
			Alumno alu = (Alumno) req.getSession().getAttribute("sesionAlumno");
			Avance avanc = new Avance();
			avanc = aep.getAvance(helper.limpiaID("Avance", avance));
			avanc.setAlumno_idAlumno(String.valueOf(alu.getIdAlumno()));
			avanc.setJuegos_idJuegos("Juegos(" + idjuego + ")");
			aep.updateAvance(avanc);
		}
		tipoJuego = "Completar palabra";
		j = (!avance.isEmpty()) ? buscaJuego(req, actual) : actual;
		Alumno al = (Alumno) req.getSession().getAttribute("sesionAlumno");

		Palabras p = j.getPalabras_idPalabras();
		req.setAttribute("jsonMedia", helper.jsonWord(p.getPrincipal(), 1).toString() + ";"
									+ helper.jsonWord(p.getCorrecta(), 2).toString() + ";"
									+ helper.jsonWord(p.getErronea(), 3).toString() + ";"
									+ helper.jsonWord(p.getErronea_2(), 4).toString());

		JSONObject jsonAlumno = new JSONObject(al);
		req.setAttribute("alumno", jsonAlumno.toString());

		JSONObject juego = new JSONObject(j);
		req.setAttribute("juego", juego.toString());

	}

	public Juegos buscaJuego(HttpServletRequest req, Juegos actual) {

		String semantico = req.getParameter("semantico");
		req.setAttribute("semantico", semantico);

		Juegos j = new Juegos();
		List<Juegos> juegos = jep.listJuegos(null);
		List<Juegos> tmp = new ArrayList<Juegos>();

		for (Juegos ju : juegos) {
			CampoSemantico cs = ju.getCampoSemantico_idCampoSemantico();
			if (cs.getSemantico().equals(semantico)) {
				tmp.add(ju);
			}
		}

		for (Juegos ju : tmp) {
			if (tipoJuego.equals(ju.getTipoJuego())) {
				if (ju.getIdJuegos() != actual.getIdJuegos()) {
					j = ju;
					break;
				} else {
					j = actual;
				}
			}
		}

		return j;
	}
}
