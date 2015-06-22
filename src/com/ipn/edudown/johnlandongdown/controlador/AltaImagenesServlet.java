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
		resp.setContentType("text/plain");
		
		String semantico = req.getParameter("semantico");
		String tipo = req.getParameter("index");
		String sec = req.getParameter("sec");
		
		
		CampoSemantico cs = csep.getCampoSemantico(helper.limpiaID(
				"CampoSemantico", semantico));
		
		switch(tipo){
		case "granja":
			List<Imagenes> listaimg = new ArrayList<Imagenes>();
			String[] imagenes = {
					"caballo.png",  
					"gallina.png",  
					"perro.png",      
					"vaca.png",  
					"borrego.png",            
					"chivo.png",      
					"gallo.png",      
					"pollito.png",  
					"burro.png",              
					"conejo.png",     
					"pato.png",      
					"puerco.png" 
			};
			
			for(String index: imagenes){
				Imagenes img = new Imagenes();
				img.setNombre(index);
				imep.insertImagenes(img);
				listaimg.add(img);
			}
			Juegos juegoMe =new Juegos();
			
			juegoMe.setNombre("Relacionar las imagenes " + cs.getSemantico());
			juegoMe.setTipoJuego("Relacionar imagen");
			juegoMe.setIconJuego("iconRI.png");
			juegoMe.setTiempo("1:00");
			juegoMe.setCampoSemantico_idCampoSemantico(cs);
			juegoMe.setImagenes_idImagenes(listaimg);
			jep.insertJuegos(juegoMe);
			
			if("game".equals(sec)){
				Juegos juego =new Juegos();
				
				juego.setNombre("Relacionar las imagenes " + cs.getSemantico());
				juego.setTipoJuego("Relacionar imagen");
				juego.setIconJuego("iconRI.png");
				juego.setTiempo("1:00");
				juego.setCampoSemantico_idCampoSemantico(cs);
				
				List<Imagenes> listita = new ArrayList<Imagenes>();
				Imagenes img = new Imagenes();
				img.setNombre("caballo.png");
				listita.add(img);
				Imagenes img1 = new Imagenes();
				img.setNombre("perro.png");
				listita.add(img);
				Imagenes img2 = new Imagenes();
				img.setNombre("gallina.png");
				listita.add(img);
				juego.setImagenes_idImagenes(listita);
				
				jep.insertJuegos(juego);

			}
			resp.getWriter().println("Fin jugegos de granja imagenes.");
			break;
		case "bebidas":
			break;
		case "acuaticos":
			break;
		case "zoo":
			break;
		case "colores":
			break;
		case "trasnporte":
			break;
		case "cuerpo":
			break;
		case "vestir":
			break;
		}
		
		
		
		
	}
}
