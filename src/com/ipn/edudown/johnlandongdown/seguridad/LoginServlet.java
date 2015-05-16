package com.ipn.edudown.johnlandongdown.seguridad;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

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
			req.setAttribute("logout_link", link);
			req.setAttribute("usuario", usuario);
			req.getRequestDispatcher("home.jsp").forward(req, resp);
			// resp.sendRedirect("home.jsp");
			
			//req.getSession().setAttribute("name_var", new Object());
			//Object o = req.getSession().getAttribute("name_var");
			
		} else {
			String link = new String(userService.createLoginURL(req
					.getRequestURI()));
			req.setAttribute("login_link", link);
			req.getRequestDispatcher("login.jsp").forward(req, resp);

		}
	}

}
