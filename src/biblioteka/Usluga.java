package biblioteka;

public class Usluga {

	public static void kreiranjeRacuna() {
		
		System.out.println("Unesite broj racuna i vase ime:");
		int brojRacuna = UI.input.nextInt();
		String imeMusterije = UI.input.nextLine();
		
		if (Provjera.provjeraUnosaRacuna(brojRacuna, imeMusterije)) {
			UI.racuni.add(new Racun(brojRacuna, imeMusterije));
			System.out.println("Racun uspjesno kreiran.");
		}
		
		Menu.menu();
	}
	
	public static void kreiranjeKnjige() {
		
		System.out.println("Unesite broj UI.knjige i ime UI.knjige:");
		int brojKnjige = UI.input.nextInt();
		String imeKnjige = UI.input.nextLine();
		
		if (Provjera.provjeraUnosaKnjige(brojKnjige, imeKnjige)) {
			UI.knjige.add(new Knjiga(brojKnjige, imeKnjige));
			System.out.println("Knjiga uspjesno kreirana.");
		}
		
		Menu.menu();
	}
	
	public static void podizanjeKnjige() {
		
		System.out.println("Unesite broj vaseg racuna kao i broj UI.knjige koju zelite podignuti:");
		int brojRacuna = UI.input.nextInt();
		int brojKnjige = UI.input.nextInt();
		
		if (Provjera.provjeraPriPodizanju(brojRacuna, brojKnjige)) {	
			Knjiga.getKnjiga(brojKnjige).setStatus(true);
			Racun.getRacun(brojRacuna).setBrojPosudjenihKnjiga(Racun.getRacun(brojRacuna).getBrojPosudjenihKnjiga() + 1);
			System.out.println("Uspjesno ste podigli knjigu.");
		}
		
		Menu.menu();
	}
	
	public static void vracanjeKnjige() {
		
		System.out.println("Unesite broj vaseg racuna kao i broj UI.knjige koju zelite vratiti:");
		int brojRacuna = UI.input.nextInt();
		int brojKnjige = UI.input.nextInt();
		
		if (Provjera.provjeraPriVracanju(brojRacuna, brojKnjige)) {	
			Knjiga.getKnjiga(brojKnjige).setStatus(false);
			Racun.getRacun(brojRacuna).setBrojPosudjenihKnjiga(Racun.getRacun(brojRacuna).getBrojPosudjenihKnjiga() - 1);
			System.out.println("Uspjesno ste vratili knjigu.");
		} 
		
		Menu.menu();
	}
	
	public static void ispisivanjeDetaljaRacuna() {
		
		System.out.println("Unesite broj racuna:");
		int brojRacuna = UI.input.nextInt();
		
		System.out.println(Racun.getRacun(brojRacuna).toString());
		
		Menu.menu();
	}
}
