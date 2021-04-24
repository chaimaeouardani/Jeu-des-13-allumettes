package allumettes;

public class Arbitre{
	private Joueur player1;
	private Joueur player2;
	
	
	//cons
	public Arbitre(Joueur j1, Joueur j2) {
		this.player1 = j1;
		this.player2 = j2;
	}
	
	
	public void arbitrer(Jeu game) {
		
		// numero du joueur qui doit jouer 
		int numJoueur = 1;
		
		//les deux joueurs de la partie
		Joueur[] players = {this.player1, this.player2};
		
		try {
		
		//main loop
		while (game.getNombreAllumettes() != 0) {
			
			//afficher le nombre d'allumette restant 
			System.out.println("Nombre d'allumettes restantes : " + game.getNombreAllumettes());
			
			//donner le tour au joueur qui doit jouer
			int nb = players[numJoueur - 1].getPrise(game);
			
			//afficher le nombre d'allumette pris par le joueur
		
			String terminaison;
			if (nb > 1) { 
				terminaison = "s.";
			} else {
				terminaison = ".";
			}
				
			System.out.println(players[numJoueur - 1].getNom() + " prend " + nb + " allumette" + terminaison); 
			
			//verifier si le coup est valide et le retirer 
			try {
				//retirer le nombre de prise du nombre d'allumettes restant
				game.retirer(nb);
				
				//actualiser le numero du joueur pour donner le role au deuxieme joueur 
				numJoueur = 2 - numJoueur / 2;
				
			} catch (CoupInvalideException e) {
				System.out.println("Impossible ! " + e.getMessage());
			} 
			
			
			System.out.println("");
			
		}
		
		// Afficher le resultat de la partie
		System.out.println(players[1 - numJoueur / 2].getNom() + " perd !");
		System.out.println(players[numJoueur - 1].getNom() + " gagne !");
		
		} catch (OperationInterditeException ex) {
			System.out.println("Abandon de la partie car " + players[numJoueur].getNom() + " triche !");
		
			
		}
		
		
	}
	
	
		
	
	
	
	
}
	
	
	
