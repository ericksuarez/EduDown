package com.ipn.edudown.johnlandongdown.controlador.juegos;

import java.io.IOException;
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
		} 

		req.getRequestDispatcher("matchImg.jsp").forward(req, resp);
	}

	public void startJuego(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, JSONException {

		
		String idjuego = req.getParameter("juego");
		String avance = req.getParameter("avance");
		Juegos actual = new Juegos();
		actual = jep.getJuegos(helper.limpiaID("Juegos", idjuego));
		
		if (!avance.isEmpty()) {
			Alumno alu = (Alumno) req.getSession().getAttribute("sesionAlumno");
			Avance avanc = new Avance();
			avanc = aep.getAvance(helper.limpiaID("Avance", avance));
			avanc.setAlumno_idAlumno(String.valueOf(alu.getIdAlumno()));
			avanc.setJuegos_idJuegos("Juegos("+idjuego+")");
			aep.updateAvance(avanc);
		}
		
		Juegos j = buscaJuego(req,actual);
		Alumno al = (Alumno) req.getSession().getAttribute("sesionAlumno");

		try {		
			Palabras p = j.getPalabras_idPalabras();
			req.setAttribute("jsonMedia", helper.jsonWord(p.getPrincipal(),1).toString() + ";" +
										  helper.jsonWord(p.getCorrecta(),2).toString() + ";" +
										  helper.jsonWord(p.getErronea(),3).toString());
		} catch (NullPointerException e) {
			String jsons = "";
			int i = 0;
			Juegos jc = buscaJuego(req,actual);
			List<Imagenes> img = jc.getImagenes_idImagenes();
			for (Imagenes im : img) {
				i++;
				JSONObject jsonImg = helper.jsonImg(im, i); 
				jsons += jsonImg.toString() + ";";
			}
			req.setAttribute("jsonMedia", jsons);
		}

		JSONObject jsonAlumno = new JSONObject(al);
		req.setAttribute("alumno", jsonAlumno.toString());
		
		JSONObject juego = new JSONObject(j);
		req.setAttribute("juego", juego.toString());

	}

	public Juegos buscaJuego(HttpServletRequest req, Juegos actual){
		
		String semantico = req.getParameter("semantico");
		req.setAttribute("semantico", semantico);
		
		Juegos j = new Juegos();
		List<Juegos> juegos = jep.listJuegos(null);
		
		for (Juegos ju : juegos) {
			CampoSemantico cs = ju.getCampoSemantico_idCampoSemantico();
			if (cs.getSemantico().equals(semantico)) {
				if(ju.getIdJuegos() != actual.getIdJuegos() && ju.getPalabras_idPalabras().getEsRelacion() == true){
					j = ju;
				}else{
					j = actual;
				}
			}
			
		}
		return j;
	}
	/*public void continuaJuego(HttpServletRequest req, HttpServletResponse resp) throws JSONException, IOException {

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

	}*/
}
