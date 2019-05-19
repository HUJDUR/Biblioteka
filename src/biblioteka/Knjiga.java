package biblioteka;

public class Knjiga {
	
	// stanja objekta
	private int brojKnjige;
	private String imeKnjige;
	private boolean status = false;
	
	// konstruktori
	Knjiga() {
		
	}
	
	Knjiga(int brojKnjige, String imeKnjige) {
			this.brojKnjige = brojKnjige;
			this.imeKnjige = imeKnjige;
	}

	// setteri, setteri
	public String getImeKnjige() {
		return imeKnjige;
	}

	public void setImeKnjige(String imeKnjige) {
		this.imeKnjige = imeKnjige;
	}

	public int getBrojKnjige() {
		return brojKnjige;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}	
}
