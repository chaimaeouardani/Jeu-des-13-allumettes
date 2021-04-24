package allumettes;

/** Lance une partie des 13 allumettes en fonction des arguments fournis
 * sur la ligne de commande.
 * @author	Xavier Crégut Chaimae Ouardani
 * @version	$Revision: 1.5 $
 */
public class Jouer {

	/** Lancer une partie. En argument sont donnés les deux joueurs sous
	 * la forme nom@stratégie.
	 * @param args la description des deux joueurs
	 */
	public static void main(String[] args) {
				
		try {
			verifierNombreArguments(args);
			
			boolean confiant = verifierArguments(args);
			
			//l'indice du premier joueur dans la liste des arguments
			int index = args.length - 2;  // 3 args -> la position du joueur 1 est 1 et 2 args -> la position du joueur 1 est 0
		
			//creation de deux instances de joueur
			Joueur player1 = recupererJoueur(args[index]);
			Joueur player2 = recupererJoueur(args[index+1]);
			
			//creation de l'instance Jeu suivant confort ou pas
			Jeu partie = null;
			
			if (player1.getStrategie() instanceof Tricheur | player2.getStrategie() instanceof Tricheur) {
				
			
				if (! confiant) {
						partie = new JeuProcuration(13);
					}
			}		
			
			else {
				partie = new game(13);
			}
			
			Arbitre Arbitre = new Arbitre(player1, player2);
			
			Arbitre.arbitrer(partie);
			
	
		} catch (ConfigurationException e) {
			System.out.println();
			System.out.println("Erreur : " + e.getMessage());
			afficherUsage();
			System.exit(1);
		}
	}
	
	//recuperer les parametres du jeu depuis les arguments 
	private static Joueur recupererJoueur(String arg) {
		
		String[] joueur = arg.split("@");
		return new Joueur(joueur[0], initialiserStrategie(joueur));
	}
	
	//initialiser la strategie a partir de la liste {joueur, strategie}
	private static Strategie initialiserStrategie(String[] arg) {
		
		switch (arg[1]) {
			case ("expert"):
				return new Expert();
				
			case ("rapide"):
				return new Rapide();
				
			case ("humain"):
				return new Humain(arg[0]);
				
			case ("naif"):
				return new Naif();
			
			case ("tricheur"):
				return new Tricheur(arg[0]);				
				
			default:
				throw new ConfigurationException("Strategie invalide !");
			}	
	}

	
	
	private static boolean verifierArguments(String[] args) {
		if (args.length == 3 && args[0].equals("-confiant")) {
			return true;
		}
		else if (args.length == 2) {
			return false;
		}
		else {
			throw new ConfigurationException("l'option -confort doit etre au debut.");
		}
	}
	

	private static void verifierNombreArguments(String[] args) {
		final int nbJoueurs = 2;
		if (args.length < nbJoueurs) {
			throw new ConfigurationException("Trop peu d'arguments : "
					+ args.length);
		}
		if (args.length > nbJoueurs + 1) {
			throw new ConfigurationException("Trop d'arguments : "
					+ args.length);
		}
	}

	/** Afficher des indications sur la manière d'exécuter cette classe. */
	public static void afficherUsage() {
		System.out.println("\n" + "Usage :"
				+ "\n\t" + "java allumettes.Jouer joueur1 joueur2"
				+ "\n\t\t" + "joueur est de la forme nom@stratégie"
				+ "\n\t\t" + "strategie = naif | rapide | expert | humain | tricheur"
				+ "\n"
				+ "\n\t" + "Exemple :"
				+ "\n\t" + "	java allumettes.Jouer Xavier@humain "
					   + "Ordinateur@naif"
				+ "\n"
				);
	}

}
