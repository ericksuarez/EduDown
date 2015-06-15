package com.ipn.edudown.johnlandongdown.controlador.juegos;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipn.edudown.johnlandongdown.entidades.Juegos;
import com.ipn.edudown.johnlandongdown.entidades.JuegosEndpoint;
import com.ipn.edudown.johnlandongdown.helper.Helper;

@SuppressWarnings("serial")
public class MatchImagenServlet extends HttpServlet {

	JuegosEndpoint jep = new JuegosEndpoint();
	Helper helper = new Helper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String idjuego = req.getParameter("juego");
		String next = req.getParameter("next");

		Juegos juegoNext;
		Juegos juego = jep.getJuegos(helper.limpiaID("Juegos", idjuego));
		req.setAttribute("juego", juego);

		if ("next".equals(next)) {
			List<Juegos> juegosAll = jep.listJuegos(null);
			int i = juegosAll.indexOf(juego);
			juegoNext = juegosAll.get(++i);
			
			req.setAttribute("idLong", juegoNext.getIdJuegos());
			req.setAttribute("juego", juegoNext);
		}
		req.getRequestDispatcher("matchImg.jsp").forward(req, resp);

	}
}
