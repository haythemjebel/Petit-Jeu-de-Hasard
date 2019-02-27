package controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.JeuMetier;

@WebServlet(name = "servlet", urlPatterns = { "*.do" })
public class ControlerJeu extends HttpServlet {
	private JeuMetier jeu;
	private String gagnant;

	@Override
	public void init() throws ServletException {
		jeu = new JeuMetier();
		jeu.genererSecret();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("vueJeu.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		ModelJeu mod;
		if (session.getAttribute("model") == null) {
			mod = new ModelJeu();
			session.setAttribute("model", mod);
		} else {
			mod = (ModelJeu) session.getAttribute("model");
		}
		if (req.getParameter("action").equals("Rejouer")) {
			jeu.genererSecret();
			jeu.setFin(false);
			mod.setHistorique(new ArrayList<String>());
		} else {
			int nb = Integer.parseInt(req.getParameter("nombre"));
			mod.setNombre(nb);
			String rep = jeu.jouer(nb);
			if (rep.indexOf("bravo") >= 0) {// rep.equals("barvo vous avez gagné")
				gagnant = req.getRemoteAddr();
			}
			if (rep.indexOf("le jeu") >= 0) {
				rep = rep + "le gagnant est " + gagnant;
			}
			mod.getHistorique().add(rep);

		}
		req.getRequestDispatcher("vueJeu.jsp").forward(req, resp);

	}

}
