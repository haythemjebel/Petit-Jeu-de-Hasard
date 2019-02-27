package controler;

import java.util.ArrayList;
import java.util.List;

public class ModelJeu {
	private int nombre; 
	private List<String> historique = new ArrayList<>();
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public List<String> getHistorique() {
		return historique;
	}
	public void setHistorique(List<String> historique) {
		this.historique = historique;
	}

	// model bch nesajil bih les donne w ni7awil bih les donne min serlet lil  partie view 
	// zada bch nijejil fih les resultat mete3ina 
}
