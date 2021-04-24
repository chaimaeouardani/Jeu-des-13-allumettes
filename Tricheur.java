package allumettes;
import java.util.Scanner;

public class Tricheur implements Strategie {
		
		private String Name;
		private Scanner scan;

		public Tricheur(String nom) {
			this.Name = nom;
			this.scan = new Scanner(System.in);
			
		}

		/**Demander au Joueur le nombre d'allumette qu'il veut prendre
		 * @param Jeu game
		 */
		public int AskPrise(Jeu game){


			System.out.println("[Je triche...]");
			
			while (game.getNombreAllumettes() > 2) {
				
					try {
						
						game.retirer(1);
	
					}catch (CoupInvalideException e) {
						System.out.println("erreur !");
					}		
	
			}
			System.out.println("[Allumettes restantes : 2]");
			return 1;
			
			}
			
			
			
}

	

