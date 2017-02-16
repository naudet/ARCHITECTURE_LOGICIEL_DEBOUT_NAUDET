package fr.esiea.unique.binome.name.dictionary;


public class Game {
	
public static Lettre potCommun[] = new Lettre [25];

Player joueur1 = new Player(false);
Player joueur2 = new Player(false);

	
	public static void remplirLePotCommun (Lettre lettre) {
		int flag=0;
		for(int i = 0; i<potCommun.length; i++) {
			if(potCommun[i] != null && potCommun[i].letter == lettre.letter && flag==0) {
				potCommun[i].nombre++; 
				//lettre.nombre++;
				flag = 1;
				
			}
			else if(potCommun[i] == null && flag == 0) {
				potCommun[i] = lettre;
				potCommun[i].letter = lettre.letter;
				potCommun[i].nombre = 1;
				flag = 1;
				
			}
		}
	}
	
	public static int checkTheWordPotCommun(String word) {
		word=word.toUpperCase();
		int length = word.length();
		int i, j;
		boolean quit = false;
		char result;
		int count = 0;
		
		for(i=0; i<length; i++) {
			result = word.charAt(i);
			for(j=0; j<25; j++) {
				
				try {
					if(potCommun[j] != null && potCommun[j].letter == result) {
						count ++;
						//System.out.println("Toutes les lettres du mot ne sont pas contenues dans le pot commun");
						//quit = true;
						break;
						/*if(potCommun[j].nombre == 1) {
							potCommun[j] = null;
							break;
							//potCommun[j].letter = '';
							//potCommun[j].nombre = 0;
						}
						else {
							potCommun[j].nombre --;
							break;
						}*/
					}

				}
				catch (Exception e) {
					System.out.println(e.toString());
				}	
			}
			if( quit) {
				break;
			}
		}
		if(count == length) {
			return 1;
		}
		else {
			System.out.println("Certaines lettres ne sont pas dans le pot commun");
			return 0;
		}
	}
	public static void updatePotCommun(String word) {
		word=word.toUpperCase();
		int length = word.length();
		int i, j;
		char result;
		
		
		for(i=0; i<length; i++) {
			result = word.charAt(i);
			for(j=0; j<25; j++) {
				
				try {
					if(potCommun[j] != null && potCommun[j].letter == result) {
						if(potCommun[j].nombre == 1) {
							potCommun[j] = null;
							break;
		
						}
						else {
							potCommun[j].nombre --;
							break;
						}
					}

				}
				catch (Exception e) {
					System.out.println(e.toString());
				}	
			}
		}

	}
	

	
	public static void afficherLePotCommun () {
		System.out.println("");
		System.out.println("Voici le pot commun: ");
		System.out.println("");
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
	
	public void main() {
		
		Lettre lettre = new Lettre('n',1);
		//Lettre nouvelleLettre = new Lettre('n',1);
		lettre.tableau();
		
		DebutDuJeu debutDuJeu = new DebutDuJeu(joueur1, joueur2);
		debutDuJeu.main();
		
		
		
		//System.out.println(joueur1.tour);
		//System.out.println(joueur2.tour);
	
		while(joueur1.nbMot!=10) {
			System.out.println("");
			System.out.println("Joueur1 ton score:" + joueur1.nbMot);
			System.out.println("Joueur2 ton score:" + joueur2.nbMot);
			System.out.println("");
			if(joueur1.tour==true) {
			
				joueur1.tour = false;
				joueur2.tour = true;
				System.out.println("");
				System.out.println("Joueur 2 à toi de jouer");
				System.out.println("");
			
				Piocher2Lettres.piocher2Lettres();
				SaisirEtVerifierMot sevm = new SaisirEtVerifierMot(joueur1,joueur2);
				sevm.saisirEtVerifierMot();
			
			}
			else {
			
				joueur2.tour=false;
				joueur1.tour = true;
				System.out.println("");
				System.out.println("Joueur1 à toi de jouer");
				System.out.println("");
				Piocher2Lettres.piocher2Lettres();
				SaisirEtVerifierMot sevm = new SaisirEtVerifierMot(joueur1,joueur2);
				sevm.saisirEtVerifierMot();
			}
			
		}
	}
}
