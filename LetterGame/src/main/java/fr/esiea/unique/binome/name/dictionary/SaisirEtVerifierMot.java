package fr.esiea.unique.binome.name.dictionary;

import java.util.Scanner;

public class SaisirEtVerifierMot {

	private static Scanner sc;
	Player joueur1 = new Player(false);
	Player joueur2 = new Player(false);
	
	public SaisirEtVerifierMot(Player joueur1, Player joueur2) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}
	
	public void saisirEtVerifierMot() {
		
		Lettre nouvelleLettre = new Lettre('n',1);
		Lettre lettre = new Lettre('n',1);
		lettre.tableau();
		String fichierPath = "LetterGame/src/main/java/fr/esiea/unique/binome/name/dictionary/dico.txt";
		Fichier fichier = new Fichier(fichierPath);
		
		System.out.println("");
		System.out.println("Veuillez saisir un mot :");
		
		sc = new Scanner(System.in);
		String mot = sc.nextLine();
		int resultPotCommun = Game.checkTheWordPotCommun(mot);
		int resultDictionary = fichier.checkIfWordCorrect(fichierPath, mot);
		int resultMotsCommuns = Mots.verifierSiMotDansMotsCommuns(mot);
		if((resultPotCommun == 1 && resultDictionary == 1) || (resultDictionary == 1 && resultMotsCommuns == 1)) {
			Game.updatePotCommun(mot);
			Mots.remplirLeTableauDeMot(mot);
			Mots.afficherLeTableauDeMot();
			if(joueur1.tour==true) {
				joueur1.nbMot++;
				
				nouvelleLettre.letter=lettre.getLetter();
				Game.remplirLePotCommun(nouvelleLettre);
				Game.afficherLePotCommun();
				if(joueur1.tour == true) {
					joueur1.tour = false;
					joueur2.tour = true;
				}
				else {
					joueur2.tour=false;
					joueur1.tour = true;
				}
			}
			else {
				joueur2.nbMot++;
				nouvelleLettre.letter=lettre.getLetter();
				Game.remplirLePotCommun(nouvelleLettre);
				Game.afficherLePotCommun();
				if(joueur1.tour == true) {
					joueur1.tour = false;
					joueur2.tour = true;
				}
				else {
					joueur2.tour=false;
					joueur1.tour = true;
				}
			}
			//Game.afficherLePotCommun();
		}
		else {
			Game.afficherLePotCommun();
			Mots.afficherLeTableauDeMot();
		}
	}
}
