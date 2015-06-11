package bst.util;

import bst.cvor.CvorStabla;

public class BSTUtil {

	/**
	 * Metoda za rekurzivnu pretragu stabla po zadatom  kljucu.
	 * 
	 * @param koren - koren stabla koje se pretrazuje
	 * @param kljuc - vrednost kljuca koji se trazi
	 * @return vrednost cvora sa zadatim kljucem
	 */
	public static CvorStabla pretraziRekurzivno (CvorStabla koren, int kljuc) {
		if (koren == null || koren.getKljuc() == kljuc) {
			return koren;
		}

		if (koren.getKljuc() > kljuc) {
			return pretraziRekurzivno(koren.getLevo(), kljuc);
		} else {
			return pretraziRekurzivno(koren.getDesno(), kljuc);
		}
	}

	/**
	 * Metoda koja trazi roditelja cvora koji zelimo da ubacimo.
	 * 
	 * @param koren - koren stabla koje se pretrazuje
	 * @param kljuc - vrednost kljuca ciji se roditelj trazi
	 * @return roditelj cvora kojeg planiramo da ubacimo
	 * 		
	 */
	public static CvorStabla pronadjiRoditeljaKljucaKojiSeUbacuje(CvorStabla koren, int kljuc) {
		if (koren == null) {
			return null;
		}

		if ((koren.getLevo() == null && koren.getKljuc() > kljuc) ||
				(koren.getDesno() == null && koren.getKljuc() < kljuc)) {
			return koren;
		}

		if (koren.getKljuc() > kljuc) {
			return pronadjiRoditeljaKljucaKojiSeUbacuje(koren.getLevo(), kljuc);
		} else {
			return pronadjiRoditeljaKljucaKojiSeUbacuje(koren.getDesno(), kljuc);
		}

	}

	public static CvorStabla pronadjiRoditelja(CvorStabla koren, int kljuc) {
		if (koren == null || koren.getKljuc() == kljuc) {
			return null;
		}

		if ((koren.getLevo() != null && koren.getLevo().getKljuc() == kljuc) ||
				(koren.getDesno() != null && koren.getDesno().getKljuc() == kljuc)) {
			return koren;
		}

		CvorStabla pomocni = pronadjiRoditelja(koren.getLevo(), kljuc);

		if (pomocni != null) {
			return pomocni;
		}

		return pronadjiRoditelja(koren.getDesno(), kljuc);
	}

	public static void izbaciList(CvorStabla koren, int kljucCvoraZaIzbacivanje) {
		if (koren == null) {
			return;
		}

		CvorStabla roditelj = pronadjiRoditelja(koren, kljucCvoraZaIzbacivanje);

		if (roditelj.getKljuc() > kljucCvoraZaIzbacivanje) {
			roditelj.setLevo(null);
		} else {
			roditelj.setDesno(null);
		}
	}

	public static void izbaciPolulist(CvorStabla koren, int kljucCvoraZaIzbacivanje) {
		if (koren == null) {
			return;
		}

		CvorStabla cvorZaIzbacivanje = pretraziRekurzivno(koren, kljucCvoraZaIzbacivanje);
		CvorStabla roditelj = pronadjiRoditelja(koren, kljucCvoraZaIzbacivanje);

		if (roditelj.getLevo() == cvorZaIzbacivanje) {
			if (cvorZaIzbacivanje.getLevo() != null) {
				roditelj.setLevo(cvorZaIzbacivanje.getLevo());
			} else {
				roditelj.setLevo(cvorZaIzbacivanje.getDesno());
			}
		} else {
			if (cvorZaIzbacivanje.getLevo() != null) {
				roditelj.setDesno(cvorZaIzbacivanje.getLevo());
			} else {
				roditelj.setDesno(cvorZaIzbacivanje.getDesno());
			}
		}
	}
	
	public static void izbaciUnutrasnji(CvorStabla koren, int kljucCvoraZaIzbacivanje) {
		if (koren == null) {
			return;
		}
		
		CvorStabla cvorZaizbacivanje = pretraziRekurzivno(koren, kljucCvoraZaIzbacivanje);
		CvorStabla max = maxVrednost(koren.getLevo());
		
		int maxKljuc = max.getKljuc();
		max.setKljuc(kljucCvoraZaIzbacivanje);
		cvorZaizbacivanje.setKljuc(maxKljuc);
		
		izbaciList(koren, kljucCvoraZaIzbacivanje);
		
	}
	
	public static CvorStabla maxVrednost(CvorStabla koren) {
		if (koren == null) {
			return null;
		}
		
		while (koren.getDesno() != null) {
			koren = koren.getDesno();
		}
		
		return koren;
	}

	public static int visinaRekurzivno(CvorStabla koren) {
		if (koren == null) {
			return 0;
		}

		return 1 + Math.max(visinaRekurzivno(koren.getLevo()), visinaRekurzivno(koren.getDesno()));
	}
	
	public static void prefixRekurzivno(CvorStabla koren) {
		if (koren == null) {
			return;
		}
		
		System.out.println(koren.getPodatak());
		prefixRekurzivno(koren.getLevo());
		prefixRekurzivno(koren.getDesno());
	}
	
	public static void infixRekurzivno(CvorStabla koren) {
		if (koren == null) {
			return;
		}
		
		infixRekurzivno(koren.getLevo());
		System.out.println(koren.getPodatak());
		infixRekurzivno(koren.getDesno());
	}
	
	public static void postfixRekurzivno(CvorStabla koren) {
		if (koren == null) {
			return;
		}
		
		postfixRekurzivno(koren.getLevo());
		postfixRekurzivno(koren.getDesno());
		System.out.println(koren.getPodatak());
	}

}
