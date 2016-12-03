package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.MetierJeu;

/**
 * Servlet implementation class ControleurServlet
 */
@WebServlet("/ControleurServlet")
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MetierJeu metier;
    
    public void init() throws ServletException {
    	metier = new MetierJeu();
    	metier.genererSecret();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/VueJeu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelJeu mod = new ModelJeu();
		int np = Integer.parseInt(request.getParameter("nombre"));
		String rep = metier.jouer(np);
		mod.getHistorique().add(rep);
		request.setAttribute("model", mod);
		request.getRequestDispatcher("/WEB-INF/VueJeu.jsp").forward(request, response);
	}

}
