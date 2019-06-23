package biblioteka;

public class Menu {
	
	public static void menu() {
	
		System.out.println(" 1. Kreiranje racuna\n 2. Kreiranje knjige\n 3. Podizanje knjige\n 4. Vracanje knjige\n 5. Ispisivanje detalja postojecih racuna\n ---------------------------------------------");
		
		int unosKorinsika = UI.input.nextInt();
		if (unosKorinsika > 5 || unosKorinsika < 0)
			System.out.println("Pogresan unos");
		
		switch (unosKorinsika) {
			case 1 : Usluga.kreiranjeRacuna();
				break;
			case 2 : Usluga.kreiranjeKnjige();
				break;
			case 3 : Usluga.podizanjeKnjige();
				break;
			case 4 : Usluga.vracanjeKnjige();
				break;
			case 5 : Usluga.ispisivanjeDetaljaRacuna();
				break;
			}
	}
}
