package pl.sda.servlets.controller;

import static pl.sda.servlets.controller.NameServlet.PARAMETER_NAME;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import pl.sda.servlets.model.NamesDB;
import pl.sda.servlets.utils.ResponseUtil;

@WebServlet(name="MaleServlet", urlPatterns = "/male")
public class MaleServlet extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ResponseUtil.setResponse(resp);
		PrintWriter writer = resp.getWriter();
		NamesDB.addMaleName(req.getParameter(PARAMETER_NAME));
		writer.println("<h4>Jesteś facetem!</h4>");
		writer.println("<a href=\"index.jsp\">Wróc do strony głownej</a>");
	}
}
