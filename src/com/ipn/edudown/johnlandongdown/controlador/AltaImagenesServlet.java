package com.ipn.edudown.johnlandongdown.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipn.edudown.johnlandongdown.entidades.CampoSemantico;
import com.ipn.edudown.johnlandongdown.entidades.Imagenes;
import com.ipn.edudown.johnlandongdown.entidades.CampoSemanticoEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Juegos;
import com.ipn.edudown.johnlandongdown.entidades.JuegosEndpoint;
import com.ipn.edudown.johnlandongdown.helper.Helper;

@SuppressWarnings("serial")
public class AltaImagenesServlet extends HttpServlet {

	CampoSemanticoEndpoint csep = new CampoSemanticoEndpoint();
	JuegosEndpoint jep = new JuegosEndpoint();
	Helper helper = new Helper();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String semantico = req.getParameter("semantico");
		CampoSemantico cs = csep.getCampoSemantico(helper.limpiaID("CampoSemantico", semantico));
		
		String[] imagenes = {
				"caballo.png",  
				"perro.png",  
				"chivo.png",  
				"gallo.png",  
				"pollito.png",  
				"burro.png",        
				"conejo.png",  
				"pato.png",  
				"puerco.png"  
		};
		
		List<Imagenes> list = new ArrayList<Imagenes>();
		for(String index: imagenes){
			Imagenes img = new Imagenes();
			img.setNombre(index);
			list.add(img);
		}
		
		Juegos juego =new Juegos();
		juego.setNombre("Relacionar las imagenes con lineas de " + cs.getSemantico());
		juego.setTipoJuego("Relacion Lineas");
		juego.setIconJuego("iconLI.png");
		juego.setTiempo("1:30");
		juego.setCampoSemantico_idCampoSemantico(cs);
		juego.setImagenes_idImagenes(list);
		
		jep.insertJuegos(juego);
	}

}