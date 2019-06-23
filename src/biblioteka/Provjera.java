package biblioteka;

public class Provjera {
	
	public static boolean provjeraUnosaRacuna(int brojRacuna, String imeMusterije) {
		
		for (int i = 0; i < UI.racuni.size(); i++) {
			if (UI.racuni.get(i).getBrojRacuna() == brojRacuna) {
				System.out.println("Greska pri unosu.");
				return false;
			}
		}
		
		if (brojRacuna < 0) {
			System.out.println("Greska pri unosu.");
			return false;
		}
	
		return true;
	}

	public static boolean provjeraUnosaKnjige(int brojKnjige, String imeKnjige) {	
	
		for (int i = 0; i < UI.knjige.size(); i++) {
			if (UI.knjige.get(i).getBrojKnjige() == brojKnjige) {
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
	
	public static boolean provjeraPriPodizanju(int brojRacuna, int brojKnjige) {
		
		Racun trenutniRacun = Racun.getRacun(brojRacuna);
		Knjiga trenutnaKnjiga = Knjiga.getKnjiga(brojKnjige);

		if (trenutniRacun == null || trenutnaKnjiga == null) {
			System.out.println("Uneseni racun/knjiga ne postoji.");
			return false;
		} else if (trenutniRacun.getBrojPosudjenihKnjiga() >= 3) {
			System.out.println("Vec imate tri podignute UI.knjige, vratite jednu pa ce te onda moci dignuti drugu.");
			return false;
		} else if (trenutnaKnjiga.isStatus() == true) {
			System.out.println("Zeljena knjiga je vec dignuta.");
			return false;
		}
			
		return true;
	}
	
	public static boolean provjeraPriVracanju(int brojRacuna, int brojKnjige) {
		
		Racun trenutniRacun = Racun.getRacun(brojRacuna);
		Knjiga trenutnaKnjiga = Knjiga.getKnjiga(brojKnjige);

		if (trenutniRacun == null || trenutnaKnjiga == null) {
			System.out.println("Uneseni racun/knjiga ne postoji.");
			return false;
		} else if (trenutniRacun.getBrojPosudjenihKnjiga() <= 0) {
			System.out.println("Nemate podignutih knjiga koje bi mogli vratiti.");
			return false;
		}
		
		if (trenutnaKnjiga.isStatus() == false) {
			System.out.println("Zeljena knjiga je vec vracena.");
			return false;
		}
			
		return true;
	}
}
