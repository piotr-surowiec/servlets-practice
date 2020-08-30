package pl.sda.servlets.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import pl.sda.servlets.model.NamesDB;
import pl.sda.servlets.utils.ResponseUtil;

@WebServlet(name="NamesListServlet", urlPatterns = {"/namesList"})
public class NamesListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ResponseUtil.setResponse(resp);
		PrintWriter writer = resp.getWriter();

		writer.println("<h2>Imiona żeńskie:</h2><br>");
		for(Map.Entry<String, Integer> entry : NamesDB.getAllFemaleNames().entrySet()){
			writer.println("Imię: " + entry.getKey() + " wpisano: " + entry.getValue() + " razy.<br>");
		}
		writer.println("<h2>Imiona męskie:</h2><hr>");
		for(Map.Entry<String, Integer> entry : NamesDB.getAllMaleNames().entrySet()){
			writer.println("Imię: " + entry.getKey() + " wpisano: " + entry.getValue() + " razy.<br>");
		}
	}
}
