package biblioteka;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteka {
	
	static Scanner input = new Scanner(System.in);
	static ArrayList<Racun> racuni = new ArrayList<>();
	static ArrayList<Knjiga> knjige = new ArrayList<>();

	public static void main(String[] args) {

		System.out.println(" ------------/////Biblioteka\\\\\\\\\\------------");
		menu();
		
	}
	
	public static void menu() {
		
		System.out.println(" 1. Kreiranje racuna\n 2. Kreiranje knjige\n 3. Podizanje knjige\n 4. Vracanje knjige\n 5. Ispisivanje detalja postojecih racuna\n ---------------------------------------------");
		
		int unosKorinsika = input.nextInt();
		if (unosKorinsika > 5 || unosKorinsika < 0)
			System.out.println("Pogresan unos");
		
		switch (unosKorinsika) {
			case 1 : kreiranjeRacuna();
				break;
			case 2 : kreiranjeKnjige();
				break;
			case 3 : podizanjeKnjige();
				break;
			case 4 : vracanjeKnjige();
				break;
			case 5 : ispisivanjeDetaljaRacuna();
				break;
			}
	}
		
	public static void kreiranjeRacuna() {
		
		System.out.println("Unesite broj racuna i vase ime:");
		int brojRacuna = input.nextInt();
		String imeMusterije = input.nextLine();
		
		if (provjeraUnosaRacuna(brojRacuna, imeMusterije)) {
			racuni.add(new Racun(brojRacuna, imeMusterije));
			System.out.println("Racun uspjesno kreiran.");
		}
		
		menu();
	}
	
	public static boolean provjeraUnosaRacuna(int brojRacuna, String imeMusterije) {
		
		for (int i = 0; i < racuni.size(); i++) {
			if (racuni.get(i).getBrojRacuna() == brojRacuna) {
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
	
	public static void kreiranjeKnjige() {
		
		System.out.println("Unesite broj knjige i ime knjige:");
		int brojKnjige = input.nextInt();
		String imeKnjige = input.nextLine();
		
		if (provjeraUnosaKnjige(brojKnjige, imeKnjige)) {
			knjige.add(new Knjiga(brojKnjige, imeKnjige));
			System.out.println("Knjiga uspjesno kreirana.");
		}
		
		menu();
	}
	
	public static boolean provjeraUnosaKnjige(int brojKnjige, String imeKnjige) {
		
		for (int i = 0; i < knjige.size(); i++) {
			if (knjige.get(i).getBrojKnjige() == brojKnjige) {
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
	
	public static void podizanjeKnjige() {
		
		System.out.println("Unesite broj vaseg racuna kao i broj knjige koju zelite podignuti:");
		int brojRacuna = input.nextInt();
		int brojKnjige = input.nextInt();
		
		if (provjeraPriPodizanju(brojRacuna, brojKnjige)) {	
			getKnjiga(brojKnjige).setStatus(true);
			getRacun(brojRacuna).setBrojPosudjenihKnjiga(getRacun(brojRacuna).getBrojPosudjenihKnjiga() + 1);
			System.out.println("Uspjesno ste podigli knjigu.");
		}
		
		menu();
	}
	
	public static boolean provjeraPriPodizanju(int brojRacuna, int brojKnjige) {
		
		Racun trenutniRacun = getRacun(brojRacuna);
		Knjiga trenutnaKnjiga = getKnjiga(brojKnjige);

		if (trenutniRacun == null || trenutnaKnjiga == null) {
			System.out.println("Uneseni racun/knjiga ne postoji.");
			return false;
		} else if (trenutniRacun.getBrojPosudjenihKnjiga() >= 3) {
			System.out.println("Vec imate tri podignute knjige, vratite jednu pa ce te onda moci dignuti drugu.");
			return false;
		} else if (trenutnaKnjiga.isStatus() == true) {
			System.out.println("Zeljena knjiga je vec dignuta.");
			return false;
		}
			
		return true;
	}
	
	public static void vracanjeKnjige() {
		
		System.out.println("Unesite broj vaseg racuna kao i broj knjige koju zelite vratiti:");
		int brojRacuna = input.nextInt();
		int brojKnjige = input.nextInt();
		
		if (provjeraPriVracanju(brojRacuna, brojKnjige)) {	
			getKnjiga(brojKnjige).setStatus(false);
			getRacun(brojRacuna).setBrojPosudjenihKnjiga(getRacun(brojRacuna).getBrojPosudjenihKnjiga() - 1);
			System.out.println("Uspjesno ste vratili knjigu.");
		} 
		
		menu();
	}
	
	public static boolean provjeraPriVracanju(int brojRacuna, int brojKnjige) {
		
		Racun trenutniRacun = getRacun(brojRacuna);
		Knjiga trenutnaKnjiga = getKnjiga(brojKnjige);

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
	
	public static void ispisivanjeDetaljaRacuna() {
		
		System.out.println("Unesite broj racuna:");
		int brojRacuna = input.nextInt();
		
		System.out.println(getRacun(brojRacuna).toString());
		
		menu();
	}
	
	public static Racun getRacun(int brojRacuna) {
		
		for (int i = 0; i < racuni.size(); i++) {
			if (racuni.get(i).getBrojRacuna() == brojRacuna) 
				return racuni.get(i);
		}
		
		return null;	
	}
	
	public static Knjiga getKnjiga(int brojKnjige) {
		
		for (int i = 0; i < knjige.size(); i++) {
			if (knjige.get(i).getBrojKnjige() == brojKnjige) 
				return knjige.get(i);
		}
		
		return null;
	}
}
