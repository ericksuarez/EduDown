package com.ipn.edudown.johnlandongdown.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipn.edudown.johnlandongdown.entidades.CampoSemantico;
import com.ipn.edudown.johnlandongdown.entidades.CampoSemanticoEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Juegos;
import com.ipn.edudown.johnlandongdown.entidades.JuegosEndpoint;


@SuppressWarnings("serial")
public class JuegoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String seccion = req.getParameter("seccion");
		String semantico = req.getParameter("semantico");

		if ("semanticos".equals(seccion)) {
			List<CampoSemantico> campossemanticos = new CampoSemanticoEndpoint()
					.listCampoSemantico(null);
			req.setAttribute("campossemanticos", campossemanticos);
			req.getRequestDispatcher("campoSemantico.jsp").forward(req, resp);
		} else {
			
			List<Juegos> juegos = new JuegosEndpoint().listJuegos(null);
			List<Juegos> tmp = new ArrayList<Juegos>();
			for(Juegos j : juegos){
				CampoSemantico cs = j.getCampoSemantico_idCampoSemantico();
				if(cs.getSemantico().equals(semantico)){
					tmp.add(j);
				}
			}
			req.setAttribute("semantico", semantico);
			req.setAttribute("juegos", tmp);
			req.getRequestDispatcher("menuJuegos.jsp").forward(req, resp);
		}
	}

}




































