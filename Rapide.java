package allumettes;

import java.util.*;

public class Rapide implements Strategie {


	
	public int AskPrise(Jeu game) {
		
		return Math.min(game.getNombreAllumettes(), game.PRISE_MAX); 
	}

}



