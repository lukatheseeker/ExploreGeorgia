package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.Place;

@WebServlet("/ListOfPlaces")
public class ListOfPlaces extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("places");
		EntityManager em = emf.createEntityManager();
		Query query = em
				.createQuery("select m from Place m order by m.kmFromTbilisi");
		List<Place> places = query.getResultList();
		out.println("<table style=\"background: white;\">");
		for (int i = 0; i < places.size(); i++) {
			out.println("<tr>");
			for (int j = 0; j < 3; j++) {
				if (i < places.size()) {
					out.println("<td>");
					out.println(places.get(i).toString());
					out.println("</td>");
					i++;
				} else {
					break;
				}
			}
			out.println("</tr>");
		}
		out.println("</table>");
	}
}
