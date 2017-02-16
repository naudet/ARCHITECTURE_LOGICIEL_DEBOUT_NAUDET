package fr.esiea.unique.binome.name.dictionary;

public class Mots {

	//19 mots maximum dans une partie
	public static String motsCommuns[] = new String [20];
	
	public String mot;
	
	
	public static void remplirLeTableauDeMot(String mot) {
		
		int i;
		int flag =0;
		
		for(i=0;i<motsCommuns.length;i++) {
			if(motsCommuns[i] == null && flag == 0) {
				motsCommuns[i] = mot;
				flag = 1;	
			}
		}
		
	}
	
	public static int verifierSiMotDansMotsCommuns(String word) {
		
		boolean reponse;
		int flag=0;
		
		for(int i=0;i<motsCommuns.length;i++) {
			
			if(motsCommuns[i] != null ) {
				reponse=word.contains(motsCommuns[i]);
				if(reponse == true) {
					flag=1;
					break;
				}
			}
		
		}
		
		return flag;
	}
	
	
	public static void afficherLeTableauDeMot() {
		
		System.out.println("");
		System.out.println("Voici les mots trouv�s que vous pouvez r�utiliser:");
		System.out.println("");
		for(int i=0; i<motsCommuns.length; i++) {
			if(motsCommuns[i] == null) {
				System.out.print(", ");
			}
			else {
				System.out.print(motsCommuns[i] +", ");
			}
		}
	}
	
}
