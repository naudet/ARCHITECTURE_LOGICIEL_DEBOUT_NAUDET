package fr.esiea.unique.binome.name.dictionary;

public class Game {
	
public static Lettre potCommun[] = new Lettre [25];
	
	public static void remplirLePotCommun (Lettre lettre) {
		int flag=0;
		for(int i = 0; i<potCommun.length; i++) {
			if(potCommun[i] != null && potCommun[i].letter == lettre.letter) {
				potCommun[i].nombre = lettre.nombre+1;
				flag = 1;
			}
			if(potCommun[i] == null && flag == 0) {
				potCommun[i] = lettre;
				potCommun[i].letter = lettre.letter;
				potCommun[i].nombre = 1;
				flag = 1;
			}
		}
	}
	
	public static void checkTheWordPotCommun(String word) {
		int length = word.length();
		int i, j;
		char result;
		
		for(i=1; i<length; i++) {
			for(j=0; j<25; j++) {
				result = word.charAt(i);
				//try {
					if(potCommun[j] != null && potCommun[j].letter == result) {
						if(potCommun[j].nombre == 1) {
							potCommun[j] = null;
							//potCommun[j].letter = '';
							//potCommun[j].nombre = 0;
						}
						else {
							potCommun[j].nombre --;
						}
					}
				//}
				/*catch (Exception e) {
					System.out.println(e.toString());
				}*/
				
			}
		}
	}
	

	
	public static void afficherLePotCommun () {
		System.out.println("");
		System.out.println("Voici le pot commun: ");
		for(int i=0; i<25; i++) {
			if(potCommun[i] != null) {
				if(potCommun[i].nombre > 1) {
					System.out.print(potCommun[i].letter +"x" + potCommun[i].nombre + " ");
				}
				else{
					System.out.print(potCommun[i].letter +" ");
				}
			}
			else{
				System.out.print(" ");
			}
		}
	}
	
	public void jeu() {
		Player joueur1 = new Player();
		Player joueur2 = new Player();
		String fichierPath = "LetterGame/src/main/java/fr/esiea/unique/binome/name/dictionary/dico.txt";
		Fichier fichier = new Fichier(fichierPath);
		
		joueur1.player = 1;
		joueur2.player = 2;
		Lettre lettre = new Lettre('n',1);
		lettre.tableau();
		String mot = "voiture";
		mot = mot.toUpperCase();
		
		joueur1.lettreDeDepart.letter = lettre.getLetter();
		joueur2.lettreDeDepart.letter = lettre.getLetter();
		remplirLePotCommun(joueur1.lettreDeDepart);
		remplirLePotCommun(joueur2.lettreDeDepart);
		
		int tour = lettre.compareLetter(joueur1.lettreDeDepart.letter, joueur2.lettreDeDepart.letter);
		if(tour==1) {
			System.out.println("joueur1 a toi frere");
		}
		if(tour==2) {
			System.out.println("joueur2 a toi frere");
		}
		afficherLePotCommun();
		checkTheWordPotCommun(mot);
		fichier.checkIfWordCorrect(fichierPath, mot);
		afficherLePotCommun();
	}

}
