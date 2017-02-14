package fr.esiea.unique.binome.name.dictionary;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fichier {

	public String fileName;
	
	
	public Fichier(String fileName) {
		this.fileName = fileName;
	}
	
	public void checkIfWordCorrect(String fichier, String mot) {
		String line = null;
		int flag=0;
		mot = mot.toLowerCase();
			
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			
			while((line=br.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(line);
				while(st.hasMoreElements()) {
					if(st.nextToken().equals(mot)) {
						flag = 1;
						System.out.println("");
						System.out.println("Votre mot est correct");
					}
					
					/*else {
						System.out.println("Wallah je comprend pas");
					}*/
				}
			}
			if(flag != 1) {
				System.out.println("");
				System.out.println("Votre mot n'existe pas");
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	
}
