package com.ipn.edudown.johnlandongdown.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipn.edudown.johnlandongdown.entidades.Alumno;
import com.ipn.edudown.johnlandongdown.entidades.AlumnoEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Avance;
import com.ipn.edudown.johnlandongdown.entidades.AvanceEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.CampoSemantico;
import com.ipn.edudown.johnlandongdown.entidades.CampoSemanticoEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Juegos;
import com.ipn.edudown.johnlandongdown.entidades.JuegosEndpoint;
import com.ipn.edudown.johnlandongdown.helper.Helper;

@SuppressWarnings("serial")
public class ReporteGeneralServlet extends HttpServlet {

	AvanceEndpoint avep = new AvanceEndpoint();
	CampoSemanticoEndpoint csep = new CampoSemanticoEndpoint();
	JuegosEndpoint jep = new JuegosEndpoint();
	Helper helper = new Helper();
	private int max = 0;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String json = "";
		ReportesServlet reporte = new ReportesServlet();

		String[] semanticos = reporte.etiquetasSemanticos();	

		for (int i = 0; i < semanticos.length; i++) {
			json += helper.jsonEstadistica(semanticos[i],scoreIdealGral(semanticos[i]), scoreGeneral(semanticos[i])) + ";";
			req.setAttribute("semanticos", json);
		}
		
		req.setAttribute("max", max);
		req.getRequestDispatcher("estadisticaGeneral.jsp").forward(req, resp);
	}

	public Integer scoreIdealGral(String semantico) {
		Integer score = 0;

		List<Juegos> games = jep.listJuegos(null);
		for (Juegos game : games) {
			if (game.getCampoSemantico_idCampoSemantico().getSemantico()
					.equals(semantico)) {
				score++;
			}
		}
		
		if((score * 10) > max){
			max = score * 10;
		}
		
		return score * 10;
	}
	
	public Integer scoreGeneral(String semantico) {
		Integer score = 0;
		List<Juegos> games = jep.listJuegos(null);
		List<Juegos> tmp = new ArrayList<Juegos>();
		
			for (Juegos ju : games) {
				if (ju.getCampoSemantico_idCampoSemantico().getSemantico().equals(semantico)) {
					tmp.add(ju);
				}
			}

		List<Avance> avances = avep.listAvance(null);
		for (Avance av : avances) {
			for (Juegos game : tmp) {
				Juegos j = jep.getJuegos(helper.limpiaID("Juegos", av.getJuegos_idJuegos()));
				if (j.getIdJuegos() == game.getIdJuegos()) {
					score += av.getPuntuacion();
				}
			}
		}

		if(score > max){
			max = score;
		}
		
		return Math.round((score * (tmp.size() * 10)) / 100);
	}


}
