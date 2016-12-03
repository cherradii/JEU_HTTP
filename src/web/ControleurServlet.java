package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.MetierJeu;

/**
 * Servlet implementation class ControleurServlet
 */
@WebServlet("/ControleurServlet")
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MetierJeu metier;
    private String gagnant;
	
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

		HttpSession session = request.getSession();
		ModelJeu mod;
		if (session.getAttribute("model") == null) {
			mod = new ModelJeu();
			session.setAttribute("model", mod);
		} else {
			mod = (ModelJeu) session.getAttribute("model");
		}

		if (request.getParameter("action").equals("Relancer")) {
			metier.genererSecret();
			metier.setFin(false);
			mod.setHistorique(new ArrayList<String>());
		} else {

			int np = Integer.parseInt(request.getParameter("nombre"));
			String rep = metier.jouer(np);
			if (rep.indexOf("Bravo") >= 0) {
				gagnant = request.getRemoteAddr();
			}
			if (rep.indexOf("Le jeu est terminé") >= 0) {
				rep = rep + ", le gagnant est " + gagnant;
			}
			mod.getHistorique().add(rep);
		}
		request.getRequestDispatcher("/WEB-INF/VueJeu.jsp").forward(request,
				response);
	}

}
