package com.ipn.edudown.johnlandongdown.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipn.edudown.johnlandongdown.entidades.CampoSemantico;
import com.ipn.edudown.johnlandongdown.entidades.Grado;
import com.ipn.edudown.johnlandongdown.entidades.GradoEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Imagenes;
import com.ipn.edudown.johnlandongdown.entidades.CampoSemanticoEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.ImagenesEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Juegos;
import com.ipn.edudown.johnlandongdown.entidades.JuegosEndpoint;
import com.ipn.edudown.johnlandongdown.helper.Helper;

@SuppressWarnings("serial")
public class AltaImagenesServlet extends HttpServlet {

	CampoSemanticoEndpoint csep = new CampoSemanticoEndpoint();
	JuegosEndpoint jep = new JuegosEndpoint();
	ImagenesEndpoint imep = new ImagenesEndpoint();
	Helper helper = new Helper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<CampoSemantico> camposemantico = csep.listCampoSemantico(null);
		List<Imagenes> imagenes = imep.listImagenes(null);

		req.setAttribute("camposemantico", camposemantico);
		req.setAttribute("imagenes", imagenes);
		req.getRequestDispatcher("altaImagen.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/plain");

		String icon = req.getParameter("icon");
		String[] images = req.getParameterValues("image[]");
		String camposemantico = req.getParameter("camposemantico");

		CampoSemantico cs = csep.getCampoSemantico(helper.limpiaID(
				"CampoSemantico", camposemantico));

		List<Imagenes> imagenes = new ArrayList<Imagenes>();
		for (int i = 0; i < images.length; i++) {
			if (!images[i].isEmpty()) {
				imagenes.add(imep.getImagenes(helper.limpiaID("Imagenes",
						images[i])));
			}
		}

		Juegos juego = new Juegos();
		juego.setNombre("Relacionar imagenes" + cs.getSemantico());
		juego.setCampoSemantico_idCampoSemantico(cs);
		juego.setIconJuego(icon);
		juego.setTiempo("2:30");
		switch(icon){
		case "iconRI.png":
			juego.setTipoJuego("Relacionar imagen");
			break;
		case "iconLI.png":
			juego.setTipoJuego("Relacionar lineas imagen");
			break;
		case "iconMI.png":
			juego.setTipoJuego("Memorama imagen");
			break;
		}
		
		juego.setImagenes_idImagenes(imagenes);

		jep.insertJuegos(juego);

		List<CampoSemantico> semanticos = csep.listCampoSemantico(null);
		List<Imagenes> imags = imep.listImagenes(null);

		req.setAttribute("camposemantico", semanticos);
		req.setAttribute("imagenes", imags);

		req.setAttribute("acierto", "El juego se creo correctamente.");
		req.getRequestDispatcher("altaImagen.jsp").forward(req, resp);
	}

	public void granja(String semantico) {
		String[] nombre = { "caballo.png", "gallina.png", "perro.png",
				"vaca.png", "borrego.png", "chivo.png", "gallo.png",
				"pollito.png", "burro.png", "conejo.png", "pato.png",
				"puerco.png"

		};
		CampoSemantico cs = csep.getCampoSemantico(helper.limpiaID(
				"CampoSemantico", semantico));

		List<Imagenes> lista = new ArrayList<Imagenes>();
		for (String name : nombre) {
			Imagenes img = new Imagenes();
			img.setNombre(name);
			lista.add(img);
		}
		Juegos juego = new Juegos();
		juego.setNombre("Memorama imagenes " + cs.getSemantico());
		juego.setCampoSemantico_idCampoSemantico(cs);
		juego.setIconJuego("iconMI.png");
		juego.setTiempo("5:00");
		juego.setTipoJuego("Memorama de imagen");
		juego.setImagenes_idImagenes(lista);

	}

}
