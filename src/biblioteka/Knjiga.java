package biblioteka;

import java.util.ArrayList;

public class Knjiga {
	
	// stanja objekta
	int brojKnjige;
	String imeKnjige;
	boolean izdatost = false;
	static ArrayList<Knjiga> knjige = new ArrayList<>();
	
	// konstruktori
	Knjiga() {
		
	}
	
	Knjiga(int brojKnjige, String imeKnjige) {
		if (provjeraUnosa(brojKnjige, imeKnjige) == true) {
			this.brojKnjige = brojKnjige;
			this.imeKnjige = imeKnjige;
			
			System.out.println("Knjiga je unijeta.");
			knjige.add(this);
		}
	}
	
	// ponasanje objekata
	public boolean provjeraUnosa(int brojKnjige, String imeKnjige) {
		
		for (int i = 0; i < knjige.size(); i++) {
			if (knjige.get(i).brojKnjige == brojKnjige) {
				System.out.println("Knjiga sa unesenim brojem vec postoji.");
				return false;
			}
		}
		
		if (brojKnjige < 0) {
			System.out.println("Greska pri unosu.");
			return false;
		}
		
		return true;
	}
	
	// podizanje knjige
	public static void podizanjeKnjige(int brojRacuna, int brojKnjige) {
		
		if (provjeraPriPodizanju(brojRacuna, brojKnjige)) {	
			Knjiga.getKnjiga(brojKnjige).izdatost = true;
			Racun.getRacun(brojRacuna).brojPosudjenihKnjiga += 1;
			System.out.println("Uspjesno ste podigli knjigu.");
		} 
	}
	
	public static boolean provjeraPriPodizanju(int brojRacuna, int brojKnjige) {
		
		Racun trenutniRacun = Racun.getRacun(brojRacuna);
		
		if (trenutniRacun == null) {
			System.out.println("Uneseni racun ne postoji.");
			return false;
		}
		
		if (trenutniRacun.brojPosudjenihKnjiga >= 3) {
			System.out.println("Vec imate tri podignute knjige, vratite jednu pa ce te onda moci dignuti drugu.");
			return false;
		}
		
		Knjiga trenutnaKnjiga = Knjiga.getKnjiga(brojKnjige);
		
		if (trenutnaKnjiga == null) {
			System.out.println("Unesena knjiga ne postoji.");
			return false;
		}
		
		if (trenutnaKnjiga.izdatost == true) {
			System.out.println("Zeljena knjiga je vec dignuta.");
			return false;
		}
			
		return true;
	}
	
	// vracanje knjige
	public static void vracanjeKnjige(int brojRacuna, int brojKnjige) {
		
		if (provjeraPriVracanju(brojRacuna, brojKnjige)) {	
			Knjiga.getKnjiga(brojKnjige).izdatost = false;
			Racun.getRacun(brojRacuna).brojPosudjenihKnjiga -= 1;
			System.out.println("Uspjesno ste vratili knjigu.");
		} 
	}
	
	public static boolean provjeraPriVracanju(int brojRacuna, int brojKnjige) {
		
		Racun trenutniRacun = Racun.getRacun(brojRacuna);
		
		if (trenutniRacun == null) {
			System.out.println("Uneseni racun ne postoji.");
			return false;
		}
		
		if (trenutniRacun.brojPosudjenihKnjiga <= 0) {
			System.out.println("Nemate podignutih knjiga koje bi mogli vratiti.");
			return false;
		}
		
		Knjiga trenutnaKnjiga = Knjiga.getKnjiga(brojKnjige);
		
		if (trenutnaKnjiga == null) {
			System.out.println("Unesena knjiga ne postoji.");
			return false;
		}
		
		if (trenutnaKnjiga.izdatost == false) {
			System.out.println("Zeljena knjiga je vec vracena.");
			return false;
		}
			
		return true;
	}
	
	public static Knjiga getKnjiga(int brojKnjige) {
		
		for (int i = 0; i < knjige.size(); i++) {
			if (knjige.get(i).brojKnjige == brojKnjige) 
				return knjige.get(i);
		}
		
		return null;
	}
	
}
