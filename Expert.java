package allumettes;

public class Expert implements Strategie{


	public int AskPrise(Jeu game) {
		switch (game.getNombreAllumettes()) {
		case 1:
			return 1;
			
		case 2:
			return 1;
			
		case 3:
			return 2;
			
		case 4:
			return 3;
			
		default:
			return 1;

		}

	}

}