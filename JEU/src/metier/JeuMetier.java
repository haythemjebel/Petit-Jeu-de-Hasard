package metier;

public class JeuMetier {
	private int nombreSecret;
	private boolean fin;

	/**
	 * public JeuMetier() { genererSecret(); } 5ater constructeur par defaut
	 **/
	public void genererSecret() {
		nombreSecret = (int) (Math.random() * 1000);
	}

	public String jouer(int nb) {
		if (fin == false) {
			if (nb > nombreSecret)
				return "votre nombre"+nb+" est plus grand ";
			else if (nb < nombreSecret)
				return "votre nombre"+nb+" est plus petit ";
			else {
				fin = true;
				return "barvo vous avez gagné";
			}

		} else {
			return "le jeu est temineé , le nombre cherche est " + nombreSecret;
		}
	}

	public boolean isFin() {
		return fin;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}

	
}
