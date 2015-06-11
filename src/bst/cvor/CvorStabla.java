
package bst.cvor;

public class CvorStabla {

	private CvorStabla levo;
	private CvorStabla desno;
	private int kljuc;
	private String podatak;
	
	public CvorStabla(CvorStabla l, CvorStabla d, int k, String p) {
		levo = l;
		desno = d;
		kljuc = k;
		podatak = p;
	}
	
	public CvorStabla getLevo() {
		return levo;
	}

	public void setLevo(CvorStabla levo) {
		this.levo = levo;
	}

	public CvorStabla getDesno() {
		return desno;
	}

	public void setDesno(CvorStabla desno) {
		this.desno = desno;
	}

	public int getKljuc() {
		return kljuc;
	}

	public void setKljuc(int kljuc) {
		this.kljuc = kljuc;
	}

	public String getPodatak() {
		return podatak;
	}

	public void setPodatak(String podatak) {
		this.podatak = podatak;
	}
	
}
