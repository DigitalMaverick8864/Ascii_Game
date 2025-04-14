package it.cefi.models;

import java.util.Random;

public class DatiRandom {
	//-----------------CREAZIONE METODI PER I DUE RANDOM------------------
	
	public static int randLungPar() {
		Random rnd=new Random();
		int lungParole=rnd.nextInt(2,12);
		return lungParole;
	}
	
	public static int randNumPar() {
		Random rnd=new Random();
		int numParole=rnd.nextInt(1,10);
		return numParole;
	}
	


}
