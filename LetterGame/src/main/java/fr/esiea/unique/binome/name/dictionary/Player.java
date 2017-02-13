package fr.esiea.unique.binome.name.dictionary;

public class Player {

	public int player;
	public int nbMot;
	public Lettre lettreDeDepart = new Lettre(null,0);
	
	public Player () {
		player=0;
		nbMot = 0;
		lettreDeDepart.letter = null;
	}
	public int joueur() {
		return player;
	}
	public int nombreDeMot(){
		return nbMot;
	}
	
}
