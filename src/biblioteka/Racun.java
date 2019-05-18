package biblioteka;

import java.util.ArrayList;

public class Racun {
	
	// stanja objekta
	private int brojRacuna;
	private String imeMusterije;
	private int brojPosudjenihKnjiga = 0;
	private static ArrayList<Racun> racuni = new ArrayList<>();
	
	// konstruktori
	Racun() {
		
	}
	
	Racun(int brojRacuna, String imeMusterije) {
			this.brojRacuna = brojRacuna;
			this.imeMusterije = imeMusterije;
	}
	
	// stanja objekta
	public boolean provjeraUnosa(int brojRacuna, String imeMusterije) {
		
		for (int i = 0; i < racuni.size(); i++) {
			if (racuni.get(i).brojRacuna == brojRacuna) {
				System.out.println("Greska pri unosu.");
				return false;
			}
		}
		
		if (brojRacuna < 0) {
			System.out.println("Greska pri unosu.");
			return false;
		}
	
		System.out.println("Profil je uspjesno kreiran");
		return true;
	}
	
	public static Racun getRacun(int brojRacuna) {
		
		for (int i = 0; i < racuni.size(); i++) {
			if (racuni.get(i).brojRacuna == brojRacuna) 
				return racuni.get(i);
		}
		
		return null;
		
	}

	@Override
	public String toString() {
		return "Broj racuna = " + brojRacuna + ", ime musterije = " + imeMusterije + ", broj posudjenih knjiga = "
				+ brojPosudjenihKnjiga;
	}

	public void setBrojPosudjenihKnjiga(int brojPosudjenihKnjiga) {
		this.brojPosudjenihKnjiga = brojPosudjenihKnjiga;
	}

	public int getBrojPosudjenihKnjiga() {
		return brojPosudjenihKnjiga;
	}

	public static ArrayList<Racun> getRacuni() {
		return racuni;
	}
	
}
