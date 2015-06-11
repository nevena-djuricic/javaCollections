package bst;

import bst.cvor.CvorStabla;
import bst.interfejs.BSTInterfejst;
import bst.util.BSTUtil;

/**
 * BST stablo je sortirano binarno stablo za koje vazi da svi cvorovi 
 * u levom podstablu nekog cvora imaju vrednost manju od vrednosti 
 * tog cvora, a da svi cvorovi u desnom podstablu tog cvora imaju vrednosti vece od
 * vrednosti tog cvora. Klasa BSTStablo je klasa koja kreira jedno takvo stablo.
 * 
 * @author Nevena
 *
 */
public class BSTStablo implements BSTInterfejst{

	CvorStabla koren;
	
	/**
	 * 
	 * Ubacuje novi cvor u stablo tako da ono ostane sortirano.
	 * 
	 * @param noviKljuc - vrednost atributa kljuc cvora koji se ubacuje
	 * @param noviPodatak - vrednost atributa podatak cvora koji se ubacuje
	 */
	public void ubaci(int noviKljuc, String noviPodatak) {
		if (koren == null) {
			return;
		}
		
		CvorStabla noviCvor = new CvorStabla(null, null, noviKljuc, noviPodatak);
		CvorStabla pomocni = BSTUtil.pretraziRekurzivno(koren, noviKljuc);
		
		if (pomocni == null) {
			CvorStabla roditelj = BSTUtil.pronadjiRoditeljaKljucaKojiSeUbacuje(koren, noviKljuc);
			
			if (roditelj.getKljuc() > noviKljuc) {
				roditelj.setLevo(noviCvor);
			} else {
				roditelj.setDesno(noviCvor);
			}
		}
		
	}

	/**
	 * Izbacuje cvor iz stabla tako da ono ostane sortirano.
	 * 
	 * @param kljucCvoraZaIzbacivanje - vrednost atributa kljuc cvora koji se izbacuje
	 */
	public void izbaci(int kljucCvoraZaIzbacivanje) {
		if (koren == null) {
			return;
		}
		
		CvorStabla cvorZaizbacivanje = BSTUtil.pretraziRekurzivno(koren, kljucCvoraZaIzbacivanje);
		
		if (cvorZaizbacivanje.getLevo() == null && cvorZaizbacivanje.getDesno() == null) {
			BSTUtil.izbaciList(koren, kljucCvoraZaIzbacivanje);
		} else if ((cvorZaizbacivanje.getLevo() == null && cvorZaizbacivanje.getDesno() != null) ||
				(cvorZaizbacivanje.getLevo() != null && cvorZaizbacivanje.getDesno() == null)) {
			BSTUtil.izbaciPolulist(koren, kljucCvoraZaIzbacivanje);
		} else {
			BSTUtil.izbaciUnutrasnji(koren, kljucCvoraZaIzbacivanje);
		}
		
	
	}

	/**
	 * Metoda koja vraca visinu stabla koje se pretrazuje
	 * 
	 * @return visina stabla
	 */
	public int visina() {
		if (koren == null) {
			return 0;
		}

		return BSTUtil.visinaRekurzivno(koren);
	}

	public void prefiks() {
		if (koren == null) {
			return;
		}
		
		BSTUtil.prefixRekurzivno(koren);
	}

	public void infix() {
		if (koren == null) {
			return;
		}
		
		BSTUtil.infixRekurzivno(koren);
	}

	public void postfiks() {
		if (koren == null) {
			return;
		}
		
		BSTUtil.postfixRekurzivno(koren);
	}

}
