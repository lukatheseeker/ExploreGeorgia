package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.Place;

@WebServlet("/Places")
public class Places extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String alias = request.getParameter("alias");
		List<Place> places = (List<Place>) request.getSession().getAttribute(
				"places");
		Place place = null;
		for (Place p : places) {
			if (p.getAlias().equals(alias)) {
				place = p;
				break;
			}
		}
		if (place == null) {
			return;
		}
		out.println("<br/>");
		out.println("<h2 align=\"center\">" + place.getName() + "</h2>");
		out.println("<div id=\"largeInfo\"><br/>" + place.getLargeInfo()
				+ "</div>");
		out.println("<div id=\"afterLargeInfo\">");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>");
		out.println("<b>Distance from Tbilisi:</b>");
		out.println("</td>");
		out.println("<td>");
		out.println(place.getKmFromTbilisi() + "km");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("<b>Recommend number of Days:</b>");
		out.println("</td>");
		out.println("<td>");
		out.println(place.getDays());
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("<b>Access by minibus:</b>");
		out.println("</td>");
		out.println("<td>");
		out.println(place.isAccessByMinibus() ? "Yes" : "No");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<br/><img id=\"largeImg\" src=\"./images/"
				+ place.getAlias() + "/10.jpg\"/>");
		out.println("<br/><img id=\"largeImg\" src=\"./images/"
				+ place.getAlias() + "/11.jpg\"/>");
		out.println("<br/><img id=\"largeImg\" src=\"./images/"
				+ place.getAlias() + "/12.jpg\"/>");
		out.println("</div>");
	}

}
