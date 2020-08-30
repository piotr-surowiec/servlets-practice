package pl.sda.servlets.controller;

import static pl.sda.servlets.controller.NameServlet.PARAMETER_NAME;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import pl.sda.servlets.model.NamesDB;
import pl.sda.servlets.utils.ResponseUtil;

@WebServlet(name="FemaleServlet", urlPatterns = "/female")
public class FemaleServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ResponseUtil.setResponse(resp);
		PrintWriter writer = resp.getWriter();
		NamesDB.addFemaleName(req.getParameter(PARAMETER_NAME));
		writer.println("<h4>Jesteś kobietą!</h4>");
		writer.println("<a href=\"index.jsp\">Wróc do strony głownej</a>");
	}
}
