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
		String name = request.getParameter("name");
		String days = request.getParameter("days");
		String access = request.getParameter("access");
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("places");
		EntityManager em = emf.createEntityManager();
		String select;
		if (isEmpty(name) && isEmpty(days) && isEmpty(access)) {
			select = selectAll();
		} else {
			select = selectWithParameters(name, days, access);
		}
		Query query = em.createQuery(select);
		int counter = 1;
		if (!isEmpty(name)) {
			query.setParameter(counter, name);
			counter++;
		}
		if (!isEmpty(days) && !days.equals("+")) {
			query.setParameter(counter, new Integer(days));
			counter++;
		}
		List<Place> places = query.getResultList();
		out.println("<table style=\"background: white;\">");
		for (int i = 0; i < places.size(); i++) {
			out.println("<tr>");
			for (int j = 0; j < 3; j++) {
				if (i < places.size()) {
					out.println("<td width=\"320px\">");
					out.println(places.get(i).toString());
					out.println("</td>");
					i++;
				} else {
					out.println("<td width=\"320px\">");
					out.println("</td>");
				}
			}
			out.println("</tr>");
		}
		out.println("</table>");
		em.close();
		emf.close();
	}

	private String selectWithParameters(String name, String days, String access) {
		StringBuilder sb = new StringBuilder("select m from Place m where ");
		boolean first = true;
		if (!isEmpty(name)) {
			sb.append(" m.name= ?");
			first = false;
		}
		if (!isEmpty(days) && !days.equals("+")) {
			if (!first) {
				sb.append(" and");
			}
			sb.append(" m.days<=?");
			first = false;
		}
		if (!isEmpty(days) && access.equals("1")) {
			if (!first) {
				sb.append(" and");
			}
			sb.append(" m.accessByMinibus=1");
		}
		sb.append(" order by m.kmFromTbilisi");
		return sb.toString();
	}

	private String selectAll() {
		return "select m from Place m order by m.kmFromTbilisi";
	}

	boolean isEmpty(String s) {
		if (s == null)
			return true;
		if (s.length() == 0)
			return true;
		return false;
	}

}
