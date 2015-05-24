package com.ipn.edudown.johnlandongdown.seguridad;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.ipn.edudown.johnlandongdown.entidades.Alumno;
import com.ipn.edudown.johnlandongdown.entidades.PMF;
import com.ipn.edudown.johnlandongdown.entidades.Profesor;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();

		if (user != null) {

			String link = new String(userService.createLogoutURL(req
					.getRequestURI()));
			String usuario = new String(req.getUserPrincipal().getName());

			if (accesoPermitido(true, usuario)) {
				req.getSession().setAttribute("logout_link", link);
				req.getSession().setAttribute("usuario", usuario);
				resp.sendRedirect("supervisar");
			} else {
				String login = new String(userService.createLoginURL(req
						.getRequestURI()));
				req.setAttribute("login_link", login);
				req.setAttribute("error",
						"No tienes permiso para accesar a esta aplicacion.");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} else {
			String link = new String(userService.createLoginURL(req
					.getRequestURI()));
			req.setAttribute("login_link", link);
			req.getRequestDispatcher("login.jsp").forward(req, resp);

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String usuario = req.getParameter("loginalumno");
		if (accesoPermitido(false, usuario)) {
			Alumno alumno = datosSesion(usuario);
			req.getSession().setAttribute("sesionAlumno", alumno);
			resp.sendRedirect("juego?seccion=semanticos");
		} else {
			resp.sendRedirect("index.html");
		}
	}

	protected boolean accesoPermitido(boolean tipo, String usuario) {

		PersistenceManager mgr = PMF.get().getPersistenceManager();
		List<Object> list = null;

		if (tipo) {
			Query q = mgr
					.newQuery(Profesor.class, "email == '" + usuario + "'");
			list = (List<Object>) q.execute();
		} else {
			Query q = mgr
					.newQuery(Alumno.class, "usuario == '" + usuario + "'");
			list = (List<Object>) q.execute();
		}
		mgr.close();

		return (list.size() > 0) ? true : false;
	}

	protected Alumno datosSesion(String usuario) {
		Alumno al = new Alumno();
		List<Alumno> list = null;
		
		PersistenceManager mgr = PMF.get().getPersistenceManager();

		Query q = mgr
				.newQuery(Alumno.class, "usuario == '" + usuario + "'");
		list = (List<Alumno>) q.execute();
		mgr.close();
		
		al = list.get(0);
		
		return al;
	}
}
// req.getSession().setAttribute("name_var", new Object());
// Object o = req.getSession().getAttribute("name_var");