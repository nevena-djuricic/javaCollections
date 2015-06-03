package bst.cvor;

public class CvorStabla {

	CvorStabla levo;
	CvorStabla desno;
	int kljuc;
	String podatak;
	
	public CvorStabla(CvorStabla l, CvorStabla d, int k, String p) {
		levo = l;
		desno = d;
		kljuc = k;
		podatak = p;
	}
	
}
