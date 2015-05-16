package com.ipn.edudown.johnlandongdown;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Landong_downServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
