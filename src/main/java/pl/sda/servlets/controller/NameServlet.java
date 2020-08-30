package pl.sda.servlets.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import pl.sda.servlets.utils.ResponseUtil;

@WebServlet(name = "NameServlet", urlPatterns = {"/name"})
public class NameServlet extends HttpServlet {

	public static final String PARAMETER_NAME = "name";
	public static final String NAME_REGEX = "[A-Z][a-z]+";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ResponseUtil.setResponse(resp);

		PrintWriter writer = resp.getWriter();
		writer.println("<h2 style=\"color: red\" Nie obsługujemy getów !</h2>");

		req.getRequestDispatcher("./index.jsp").include(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ResponseUtil.setResponse(resp);

		PrintWriter writer = resp.getWriter();
		Optional<String> givenName = Optional.ofNullable(req.getParameter(PARAMETER_NAME));
		givenName.ifPresentOrElse(name -> processNameParameters(name, writer),
				() -> writer.println("Nie podałeś imienia"));

		req.getRequestDispatcher("/index.jsp").include(req, resp);
	}
	private void processNameParameters(String name, PrintWriter writer){
		if(name.matches(NAME_REGEX)){
			writer.println("<h4>Twoje imię to: " + name + "</h4>");
		}else{
			writer.println("<h4>Imię podane w złym formacie</h4>");
		}
	}
}
