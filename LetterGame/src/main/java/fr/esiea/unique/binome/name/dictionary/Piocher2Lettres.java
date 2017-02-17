package fr.esiea.unique.binome.name.dictionary;

public class Piocher2Lettres {

	public static void piocher2Lettres() {
		
		Lettre nouvelleLettre1 = new Lettre('n',1);
		nouvelleLettre1.tableau();
		Lettre nouvelleLettre2 = new Lettre('n',1);
		nouvelleLettre2.tableau();
		
		System.out.println("Piocher 2 lettres ");
		
		nouvelleLettre1.letter=nouvelleLettre1.getLetter();
		Game.remplirLePotCommun(nouvelleLettre1);
		nouvelleLettre2.letter=nouvelleLettre2.getLetter();
		Game.remplirLePotCommun(nouvelleLettre2);
		System.out.println("Vous avez pioché: " + nouvelleLettre1.letter + " et " + nouvelleLettre2.letter);
		Game.afficherLePotCommun();
		
	}
}
