package fr.esiea.unique.binome.name.dictionary;

public class Player {

	public int player;
	public int nbMot;
	public boolean tour;
	public Lettre lettreDeDepart = new Lettre('n',1);
	
	public Player (boolean tour) {
		this.tour = tour;
		player=0;
		nbMot = 0;
		lettreDeDepart.letter = 'X';
	}
	public int joueur() {
		return player;
	}
	public int nombreDeMot(){
		return nbMot;
	}
	public boolean geTour() {
		return tour;
	}
	
}
