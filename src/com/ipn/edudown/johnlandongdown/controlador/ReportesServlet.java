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
public class ReportesServlet extends HttpServlet {

	AvanceEndpoint avep = new AvanceEndpoint();
	CampoSemanticoEndpoint csep = new CampoSemanticoEndpoint();
	JuegosEndpoint jep = new JuegosEndpoint();
	Helper helper = new Helper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String json = "";
		String alu = req.getParameter("alumno");

		Alumno alumno = new AlumnoEndpoint().getAlumno(helper.limpiaID(
				"Alumno", alu));

		String[] semanticos = etiquetasSemanticos();

		req.setAttribute("alumno", alumno);

		for (int i = 0; i < semanticos.length; i++) {
			json += helper.jsonEstadistica(semanticos[i],
					scoreIdeal(semanticos[i]), scoreAlumno(alu))
					+ ";";
			req.setAttribute("semanticos", json);
		}
		// req.setAttribute("ideal", ideal);
		req.getRequestDispatcher("estadistica.jsp").forward(req, resp);
	}

	public String[] etiquetasSemanticos() {

		int index = 0;

		List<CampoSemantico> semanticos = csep.listCampoSemantico(null);
		String[] label = new String[semanticos.size()];

		for (CampoSemantico cs : semanticos) {
			label[index++] = cs.getSemantico();
		}

		return label;
	}

	public Integer scoreIdeal(String semantico) {
		Integer score = 0;

		List<Juegos> games = jep.listJuegos(null);
		for (Juegos game : games) {
			if (game.getCampoSemantico_idCampoSemantico().getSemantico()
					.equals(semantico)) {
				score++;
			}
		}
		return score;
	}

	public Integer scoreAlumno(String alu) {
		Integer score = 0;
		List<CampoSemantico> semanticos = csep.listCampoSemantico(null);
		List<Juegos> games = jep.listJuegos(null);

		List<Juegos> tmp = new ArrayList<Juegos>();
		
		for (CampoSemantico campo : semanticos) {
			for (Juegos ju : games) {
				if (ju.getCampoSemantico_idCampoSemantico().getIdCampo() == campo.getIdCampo()) {
					tmp.add(ju);
				}
			}
		}

		List<Avance> avances = avep.listAvance(null);
		for (Avance av : avances) {
			for (Juegos game : tmp) {
				if (av.getJuegos_idJuegos().equals(game.getIdJuegos())) {
					score += av.getPuntuacion();
				}
			}
		}

		return score;
	}

}
