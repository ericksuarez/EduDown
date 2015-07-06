package com.ipn.edudown.johnlandongdown.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.ipn.edudown.johnlandongdown.entidades.Alumno;
import com.ipn.edudown.johnlandongdown.entidades.AlumnoEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Avance;
import com.ipn.edudown.johnlandongdown.entidades.AvanceEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.CampoSemantico;
import com.ipn.edudown.johnlandongdown.entidades.CampoSemanticoEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.Juegos;
import com.ipn.edudown.johnlandongdown.entidades.JuegosEndpoint;
import com.ipn.edudown.johnlandongdown.entidades.PMF;
import com.ipn.edudown.johnlandongdown.helper.Helper;

@SuppressWarnings("serial")
public class EvaluarServlet extends HttpServlet {
	
	private String tiempopromedio;
	private Integer aciertos = 0;
	private Integer vecesjugado = 0;
	private List<Avance> avances = null;

	AvanceEndpoint avep = new AvanceEndpoint();
	CampoSemanticoEndpoint csep = new CampoSemanticoEndpoint();
	JuegosEndpoint jep = new JuegosEndpoint();
	Helper helper = new Helper();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String alu = req.getParameter("alumno");
		
		Alumno alumno = new AlumnoEndpoint().getAlumno(new Helper().limpiaID("Alumno", alu));
		List<CampoSemantico> semanticos = csep.listCampoSemantico(null);
		
		req.setAttribute("alumno", alumno);
		req.setAttribute("semanticos", semanticos);
		req.getRequestDispatcher("detalle.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/plain");
		
		int errores = 0;
		int hora = 0;
		int min = 0;
		int seg = 0;
		
		String alumno = req.getParameter("alumno");
		String semantico = req.getParameter("semantico");
		String tipo = req.getParameter("tipo");
		
		avances = avanceAlumno(alumno);
		
		CampoSemantico camposemantico = csep.getCampoSemantico(helper.limpiaID("CampoSemantico", semantico));
		List<Juegos> juegos = jep.listJuegos(null); 
		String regGame = "";
		
		vecesjugado = 0;
		aciertos = 0;
		
		for(Juegos ju : juegos){
			CampoSemantico cs = ju.getCampoSemantico_idCampoSemantico();
			
			if(camposemantico.getIdCampo() == cs.getIdCampo()){
				
				for(Avance av : avances){
					
					//if(!av.getJuegos_idJuegos().equals("Juegos(100000)")){
						Juegos jtmp = jep.getJuegos(helper.limpiaID("Juegos", av.getJuegos_idJuegos()));
					
					if(tipo.equals(jtmp.getIconJuego()) && jtmp.getIdJuegos() == ju.getIdJuegos()){
						hora += helper.tiempo(av.getTiempoTerminado(),0);
						min += helper.tiempo(av.getTiempoTerminado(),1);
						seg += helper.tiempo(av.getTiempoTerminado(),2);
						vecesjugado++;
						errores += av.getErrores();
						regGame += ju.getIdJuegos() + ",";
						}
					//}
				}	
			}
		}
		
		aciertos = vecesjugado - errores;
		tiempopromedio = helper.formatoTime(hora, min, seg);
		
		String html = innerHTML(tiempopromedio,aciertos,vecesjugado,regGame,alumno);
		resp.getWriter().print(html);
	}

	public String innerHTML(String tiempopromedio, Integer aciertos, Integer vecesjugado, 
							String regGame, String alumno){
		
		String html = "<form action='/supervisar' method='post'>";
		html += "<input type='hidden' name='regGame' value='" + regGame + "'> "
				+ "<input  type='hidden' name='alumno' value='" + alumno + "'> "
				+ "<input type='hidden' name='tiempoPromedio' value='" + tiempopromedio + "'> "
				+ "<input  type='hidden' name='intentosPromedio' value='" + vecesjugado + "'> "
		        +  "<li class='media'> "
				+ "<div class='media-left'> "
				+ "<i class='fa fa-clock-o fa-2x media-object'></i>"
				+ "</div>"
				+ "<div class='media-body'>"
				+ "		<a class='comment-author pull-left'>Tiempo promedio </a> "
				+ "		<span class='pull-right'>" + tiempopromedio + " min</span>"
				+ "		</div>"
				+ "	</li>"
				+ "	<li class='media'>"
				+ "		<div class='media-left'>"
				+ "			<i class='fa fa-calculator fa-2x media-object'></i>"
				+ "		</div>"
				+ "		<div class='media-body'>"
				+ "			<a class='comment-author pull-left'>Total de veces jugado </a> "
				+ "			<span class='pull-right'>" + vecesjugado + "</span>"
				+ "		</div>"
				+ "	</li>"
				+ "	<li class='media'>"
				+ "		<div class='media-left'>"
				+ "			<i class='fa fa-thumbs-o-up fa-2x media-object'></i>"
				+ "		</div>"
				+ "		<div class='media-body'>"
				+ "			<a class='comment-author pull-left'>Total de aciertos </a> "
				+ "			<span class='pull-right'>" + aciertos + "</span>"
				+ "		</div>"
				+ "	</li>"
				+ "	<li class='media'>"
				+ "		<div class='media-left'>"
				+ "			<i class='fa fa-pencil-square-o fa-2x media-object'></i>"
				+ "		</div>"
				+ "		<div class='media-body'>"
				+ "			<textarea row='3' style='width: 100%;' name='aprovado'></textarea>"
				+ "		</div>"
				+ "	</li>"
				+ "	<li class='media'>"
				+ "			<button type='submit' class='btn btn-danger pull-right'>Registrar Evaluacion</button>"
				+ "	</li>"
				+ "	</form>";
		return html;
	}

	public List<Avance> avanceAlumno(String alumno){
		List<Avance> execute = null;
		
		PersistenceManager mgr = PMF.get().getPersistenceManager();	
		Query query = mgr.newQuery(Avance.class, "Alumno_idAlumno == '" + alumno + "'");
		execute = (List<Avance>) query.execute();

		return execute;
	}
}
