package biblioteka;

import java.util.Scanner;

public class Biblioteka {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		menu();
		
	}
	
	public static void menu() {
		
		System.out.println("\nATM - menu:\n 1. Kreiranje racuna\n 2. Kreiranje knjige\n 3. Podizanje knjige\n 4. Vracanje knjige\n 5. Ispisivanje detalja postojecih racuna");
		
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
		
		new Racun(brojRacuna, imeMusterije);
		
		menu();
	}
	
	public static void kreiranjeKnjige() {
		
		System.out.println("Unesite broj knjige i ime knjige:");
		int brojKnjige = input.nextInt();
		String imeKnjige = input.nextLine();
		
		new Knjiga(brojKnjige, imeKnjige);
		
		menu();
	}
	
	public static void podizanjeKnjige() {
		
		System.out.println("Unesite broj vaseg racuna kao i broj knjige koju zelite podignuti:");
		int brojRacuna = input.nextInt();
		int brojKnjige = input.nextInt();
		
		Knjiga.podizanjeKnjige(brojRacuna, brojKnjige);
		
		menu();
	
	}
	
	public static void vracanjeKnjige() {
		
		System.out.println("Unesite broj vaseg racuna kao i broj knjige koju zelite vratiti:");
		int brojRacuna = input.nextInt();
		int brojKnjige = input.nextInt();
		
		Knjiga.vracanjeKnjige(brojRacuna, brojKnjige);
		
		menu();
		
	}
	
	public static void ispisivanjeDetaljaRacuna() {
		
		System.out.println("Unesite broj racuna:");
		int brojRacuna = input.nextInt();
		
		System.out.println(Racun.getRacun(brojRacuna).toString());
		
		menu();
	}
	
}
