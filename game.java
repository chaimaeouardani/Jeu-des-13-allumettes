package allumettes;

public class game implements Jeu {
	
	private int nbAllumette ;
	
	
	public game(int nb) {
		this.nbAllumette = nb;
	}
	
	
	public int getNombreAllumettes() {
		return this.nbAllumette;
	}
	
	public void retirer(int nbPrises) throws CoupInvalideException { 
		
		if (nbPrises < 1) {
			throw new CoupInvalideException(nbPrises, "< 1");
			
		}
		else if (nbPrises > game.PRISE_MAX) {
			throw new CoupInvalideException(nbPrises, "> 3");
		}
		else if (nbPrises > this.nbAllumette) {
			throw new CoupInvalideException(nbPrises, "> 3");
		}
		else {
			this.nbAllumette -= nbPrises;
		}
		
	}

}
