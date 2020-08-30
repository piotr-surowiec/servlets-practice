package pl.sda.servlets.utils;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {
	public static void setResponse(HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
	}
}
