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
import com.ipn.edudown.johnlandongdown.entidades.CampoSemantico;
import com.ipn.edudown.johnlandongdown.entidades.Juegos;
import com.ipn.edudown.johnlandongdown.entidades.JuegosEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Palabras;
import com.ipn.edudown.johnlandongdown.helper.Helper;

@SuppressWarnings("serial")
public class MatchImagenServlet extends HttpServlet {

	JuegosEndpoint jep = new JuegosEndpoint();
	Helper helper = new Helper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String inicio = req.getParameter("inicio");

		if ("inicio".equals(inicio)) {
			try {
				startJuego(req, resp);
				List<Juegos> lista = (List) req.getSession().getAttribute("listajuegos");
				lista.remove(0);
				req.getSession().setAttribute("listajuegos", lista);

			} catch (JSONException e) {
				e.printStackTrace();
			}
		} else {
			try {
				continuaJuego(req, resp);
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

		List<Juegos> juegos = jep.listJuegos(null);
		List<Juegos> tmp = new ArrayList<Juegos>();
		for (Juegos j : juegos) {
			CampoSemantico cs = j.getCampoSemantico_idCampoSemantico();
			if (cs.getSemantico().equals(semantico)) {
				tmp.add(j);
			}
		}
		req.getSession().setAttribute("listajuegos", tmp);

		Juegos j = jep.getJuegos(helper.limpiaID("Juegos", idjuego));
		Alumno al = (Alumno) req.getSession().getAttribute("sesionAlumno");

		if (j.getPalabras_idPalabras() != null) {
			
			Palabras p = j.getPalabras_idPalabras();

			req.setAttribute("jsonMedia", helper.jsonWord(p.getPrincipal(),1).toString() + ";" +
										  helper.jsonWord(p.getCorrecta(),2).toString() + ";" +
										  helper.jsonWord(p.getErronea(),3).toString());

		} else if (j.getImagenes_idImagenes().size() > 0) {

			req.setAttribute("jsonMedia", helper.jsonImg(j));
		}

		JSONObject jsonAlumno = new JSONObject(al);
		req.setAttribute("alumno", jsonAlumno.toString());
		
		JSONObject juego = new JSONObject(j);
		req.setAttribute("juego", juego.toString());

	}

	public void continuaJuego(HttpServletRequest req, HttpServletResponse resp) throws JSONException, IOException {

		String semantico = req.getParameter("semantico");
		req.setAttribute("semantico", semantico);
		Juegos j = null;
		
		List<Juegos> lista = (List) req.getSession().getAttribute("listajuegos");
		
		if(lista.size() > 0){
		 j = lista.get(0);
		}else{
			resp.sendRedirect("juego?seccion=semanticos");
		}

		Alumno al = (Alumno) req.getSession().getAttribute("sesionAlumno");

		if (j.getPalabras_idPalabras() == null) {
			
			Palabras p = j.getPalabras_idPalabras();

			req.setAttribute("jsonMedia", helper.jsonWord(p.getPrincipal(),1).toString() + ";" +
										  helper.jsonWord(p.getCorrecta(),2).toString() + ";" +
										  helper.jsonWord(p.getErronea(),3).toString());

		} else if (j.getImagenes_idImagenes().size() > 0) {

			req.setAttribute("jsonMedia", helper.jsonImg(j));
		}

		JSONObject jsonAlumno = new JSONObject(al);
		req.setAttribute("alumno", jsonAlumno);

		JSONObject juego = new JSONObject(al);
		req.setAttribute("juego", j);
		
		lista.remove(0);
		req.getSession().setAttribute("listajuegos", lista);

	}
}
