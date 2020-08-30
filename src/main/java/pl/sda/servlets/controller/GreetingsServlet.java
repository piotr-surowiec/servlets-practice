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

@WebServlet(name="FemaleServlet", urlPatterns = "/greeting")
public class GreetingsServlet extends HttpServlet {

	private static final String FEMALE_MALE_REGEX = ".+a";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ResponseUtil.setResponse(resp);
		String name = req.getParameter(PARAMETER_NAME);
		PrintWriter writer = resp.getWriter();

		if(name.matches(FEMALE_MALE_REGEX)){
			NamesDB.addFemaleName(req.getParameter(PARAMETER_NAME));
			writer.println("<h4>Jesteś kobietą!</h4>");
		} else {
			NamesDB.addMaleName(req.getParameter(PARAMETER_NAME));
			writer.println("<h4>Jesteś facetem!</h4>");
		}

		writer.println("<h4>Twoje imię to: " + name + "</h4>");
		writer.println("<a href=\"index.jsp\">Wróc do strony głownej</a>");
	}
}
