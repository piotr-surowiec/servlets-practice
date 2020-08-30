package pl.sda.servlets.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import pl.sda.servlets.utils.ResponseUtil;

@WebFilter(filterName = "GreetingFilter", servletNames = {"GreetingsServlet"})
public class GreetingsFilter implements Filter {

	public static final String ACCESS_TO_GREETING = "access";

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		//przed
		Object access = servletRequest.getAttribute(ACCESS_TO_GREETING);
		if(access != null){
			filterChain.doFilter(servletRequest, servletResponse);
		} else {
			ResponseUtil.setResponse((HttpServletResponse) servletResponse);

			PrintWriter writer = servletResponse.getWriter();
			writer.println("<h2 style=\"color: red\"> Nie masz uprawnień !</h2>");

			servletRequest.getRequestDispatcher("/index.jsp").include(servletRequest, servletResponse);
		}
	}
}
