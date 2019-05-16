package biblioteka;

import java.util.ArrayList;

public class Racun {
	
	// stanja objekta
	int brojRacuna;
	String imeMusterije;
	int brojPosudjenihKnjiga = 0;
	static ArrayList<Racun> racuni = new ArrayList<>();
	
	// konstruktori
	Racun() {
		
	}
	
	Racun(int brojRacuna, String imeMusterije) {
		if(provjeraUnosa(brojRacuna, imeMusterije) == true) {
			this.brojRacuna = brojRacuna;
			this.imeMusterije = imeMusterije;
			
			racuni.add(this);
		}
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
	
}
