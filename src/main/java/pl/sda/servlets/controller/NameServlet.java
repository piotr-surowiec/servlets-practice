package pl.sda.servlets.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import pl.sda.servlets.model.ForbiddenNamesValidator;
import pl.sda.servlets.utils.ResponseUtil;

@WebServlet(name = "NameServlet", urlPatterns = {"/name"})
public class NameServlet extends HttpServlet {

	public static final String PARAMETER_NAME = "name";
	private static final String NAME_REGEX = "[A-Z][a-z]+";
	private static final String FEMALE_MALE_REGEX = ".+a";
	private static final String FEMALE_PATH = "/female";
	private static final String MALE_PATH = "/male";
	private static final String MAIN_SITE_PATH = "/index.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ResponseUtil.setResponse(resp);

		PrintWriter writer = resp.getWriter();
		writer.println("<h2 style=\"color: red\"> Nie obsługujemy getów !</h2>");

		req.getRequestDispatcher("/index.jsp").include(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ResponseUtil.setResponse(resp);

		PrintWriter writer = resp.getWriter();
		Optional<String> givenName = Optional.ofNullable(req.getParameter(PARAMETER_NAME));
		String path = givenName
				.map(name -> convertNameToProperPath(name, writer))
				.orElseGet(() -> getPathWhenMissingName(writer));


		req.getRequestDispatcher(path).include(req, resp);
	}

	protected String convertNameToProperPath(String name, PrintWriter writer) {
		if (name.matches(NAME_REGEX)) {
			if(ForbiddenNamesValidator.isForbidden(name)){
				writer.println("<h4 style=\"color: red\">Imię zabronione !</h4>");
				return MAIN_SITE_PATH;
			}
			writer.println("<h4>Twoje imię to: " + name + "</h4>");
			return name.matches(FEMALE_MALE_REGEX) ? FEMALE_PATH : MALE_PATH;
		} else {
			writer.println("<h4>Imię podane w złym formacie</h4>");
			return MAIN_SITE_PATH;
		}
	}

	private String getPathWhenMissingName(PrintWriter writer) {
		writer.println("Nie podałeś imienia");
		return MAIN_SITE_PATH;
	}
}
