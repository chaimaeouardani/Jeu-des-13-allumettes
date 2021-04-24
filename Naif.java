package allumettes;
import java.util.Random;

public class Naif implements Strategie {
	

	public int AskPrise(Jeu game){
		Random rand = new Random();
	    return rand.nextInt(game.PRISE_MAX + 1);
	}

}