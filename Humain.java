package allumettes;

import java.util.Scanner;


public class Humain implements Strategie{

	
	private String Name;
	private Scanner scan;

	public Humain(String nom) {
		this.Name = nom;
		this.scan = new Scanner(System.in);
		
	}

	public int AskPrise(Jeu game){
		
		int n = 0;
		boolean etat = true;
		String reponse;
		
		do {
		
			System.out.println(this.Name + ", combien d'allumettes ? ");
			reponse =  scan.nextLine();
			
			if (reponse.equals("triche")) {
				
				try {
					game.retirer(1);
					System.out.println("[Une allumette en moins, plus que " + game.getNombreAllumettes() + ". Chut !]");
					return this.AskPrise(game);
									
					} catch (CoupInvalideException e) {
						return this.AskPrise(game);
					}
			}

			else {
			
					try {
				        n = Integer.parseInt(reponse);
				        etat = false;
				    } catch (NumberFormatException nfe) {
				    	System.out.println("Vous devez donner un entier.");
						
				    }
			}
		}while (etat);	
			 
		
		return n;		
		}
	}

		
	
			
			
