package fr.esiea.unique.binome.name.dictionary;

public class Lettre {

	public Lettre letterTab[] = new Lettre[26];
	
	//[a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]
	
	public char letter;
	public int nombre;

	
	public Lettre (char letter, int nombre) {
		this.letter = letter;
		this.nombre = nombre;
		
	}
	
	public void tableau() {
		letterTab[0] = new Lettre('A',1);
		letterTab[1] = new Lettre('B',1);
		letterTab[2] = new Lettre('C',1);
		letterTab[3] = new Lettre('D',1);
		letterTab[4] = new Lettre('E',1);
		letterTab[5] = new Lettre('F',1);
		letterTab[6] = new Lettre('G',1);
		letterTab[7] = new Lettre('H',1);
		letterTab[8] = new Lettre('I',1);
		letterTab[9] = new Lettre('J',1);
		letterTab[10] = new Lettre('K',1);
		letterTab[11] = new Lettre('L',1);
		letterTab[12] = new Lettre('M',1);
		letterTab[13] = new Lettre('N',1);
		letterTab[14] = new Lettre('O',1);
		letterTab[15] = new Lettre('P',1);
		letterTab[16] = new Lettre('Q',1);
		letterTab[17] = new Lettre('R',1);
		letterTab[18] = new Lettre('S',1);
		letterTab[19] = new Lettre('T',1);
		letterTab[20] = new Lettre('U',1);
		letterTab[21] = new Lettre('V',1);
		letterTab[22] = new Lettre('W',1);
		letterTab[23] = new Lettre('X',1);
		letterTab[24] = new Lettre('Y',1);
		letterTab[25] = new Lettre('Z',1);
		
	}
	public int getNombre() {
		return this.nombre;
	}
	
	public char getLetter () {
		int random = (int)( Math.random()*(26));
		char letter1 = letterTab[random].letter;
		return letter1;
	}
	public int compareLetter(char letter1, char letter2){
		int coef1=0;
		int coef2=0;
		for(int i=0; i<letterTab.length; i++){
			if(letterTab[i].letter==letter1) {
				coef1 = i;
			}
			else if (letterTab[i].letter==letter2) {
				coef2 = i;
			}
		}
		if(coef1<= coef2) {
			
			return 1;
		}
		else {
			return 2;
		}
	}
}
