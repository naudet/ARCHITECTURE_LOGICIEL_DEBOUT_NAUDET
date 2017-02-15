package fr.esiea.unique.binome.name.dictionary;
import java.util.Scanner;
public class DebutDuJeu {

	

private Scanner sc;
Player joueur1 = new Player(false);
Player joueur2 = new Player(false);

	public DebutDuJeu(Player joueur1, Player joueur2) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}

	
	public void main() {
		
		//Player joueur1 = new Player(false);
		//Game.joueur1;
		//Player joueur2 = new Player(false);
		String fichierPath = "LetterGame/src/main/java/fr/esiea/unique/binome/name/dictionary/dico.txt";
		Fichier fichier = new Fichier(fichierPath);
		Lettre nouvelleLettre = new Lettre('n',1);
		
		joueur1.player = 1;
		joueur2.player = 2;
		Lettre lettre = new Lettre('n',1);
		lettre.tableau();
		
		
		
		////////////////    1er tour    /////////////////
		System.out.println("Le joueur 1 tire une lettre");
		joueur1.lettreDeDepart.letter = lettre.getLetter();
		Game.remplirLePotCommun(joueur1.lettreDeDepart);
		System.out.println("Le joueur 1 a tiré la lettre: " + joueur1.lettreDeDepart.letter);
		
		System.out.println("Le joueur 2 tire une lettre");
		joueur2.lettreDeDepart.letter = lettre.getLetter();
		Game.remplirLePotCommun(joueur2.lettreDeDepart);
		System.out.println("Le joueur 2 a tiré la lettre: " + joueur2.lettreDeDepart.letter);
		
		int tour = lettre.compareLetter(joueur1.lettreDeDepart.letter, joueur2.lettreDeDepart.letter);
		if(tour==1) {
			System.out.println("joueur 1 a toi de commencer");
			joueur1.tour = true;
		}
		if(tour==2) {
			System.out.println("joueur 2 a toi de commencer");
			joueur2.tour = true;
		}
		System.out.println("Piocher 2 lettres: ");
		nouvelleLettre.letter=lettre.getLetter();
		Game.remplirLePotCommun(joueur1.lettreDeDepart);
		nouvelleLettre.letter=lettre.getLetter();
		Game.remplirLePotCommun(nouvelleLettre);
		
		Game.afficherLePotCommun();
		
		System.out.println("");
		System.out.println("Veuillez saisir un mot :");
		
		sc = new Scanner(System.in);
		String mot = sc.nextLine();
		int resultPotCommun = Game.checkTheWordPotCommun(mot);
		int resultDictionary = fichier.checkIfWordCorrect(fichierPath, mot);
		if(resultPotCommun == 1 && resultDictionary == 1) {
			Game.updatePotCommun(mot);
			if(joueur1.tour==true) {
				joueur1.nbMot++;
			}
			else {
				joueur2.nbMot++;
			}
			Game.afficherLePotCommun();
		}
		else {
			Game.afficherLePotCommun();
		}
		/*if(joueur1.tour==true) {
			joueur1.tour = false;
			joueur2.tour = true;
		}
		else {
			joueur2.tour=false;
			joueur1.tour = true;
		}*/
		////////////////    1er tour    /////////////////
		
	}

}
