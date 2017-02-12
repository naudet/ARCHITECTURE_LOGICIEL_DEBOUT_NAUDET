package fr.esiea.unique.binome.name.dictionary;

public class Lettre {

	public final String letterTab[]= {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	public String letter;

	
	public String getLetter () {
		int random = (int)( Math.random()*(26));
		letter = letterTab[random];
		return letter;
	}
}
