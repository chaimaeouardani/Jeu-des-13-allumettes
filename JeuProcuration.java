package allumettes;

public class JeuProcuration extends game implements Jeu {
	

	public JeuProcuration(int nb) {
		super(nb);
	}

	public void retirer(int nb) throws OperationInterditeException {
		throw new OperationInterditeException("Le joueur triche.");
	}

	
	

}
