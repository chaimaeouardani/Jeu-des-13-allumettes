package allumettes;

public class Joueur {
	
	private String nom;				// nom du joueur
	private Strategie strat;		// la strategie du joueur
	
	
	
	//constructor
	public Joueur(String name, Strategie strategie) {
		this.nom = name;
		this.strat = strategie;
	}
	
	
	//accesseur
	public String getNom() {
		return this.nom;
	}
	
	public Strategie getStrategie() {
		return this.strat;
	}
	
	//
	public int getPrise(Jeu game) {
		return strat.AskPrise(game);
	}
	
	
}
