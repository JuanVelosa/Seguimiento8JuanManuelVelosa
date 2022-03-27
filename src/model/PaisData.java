package model;

import java.util.ArrayList;
import java.util.Collections;

public class PaisData {
	private ArrayList<Pais> pais;

	public PaisData() {
		pais = new ArrayList<>();
	}

	public void print() {
		for (Pais p : pais)
			System.out.print(p.toString() + "\n");
	}

	public void cleanData() {
		pais.clear();
	}

	public void orden() {
		Collections.sort(pais);
	}

	public void addPais(Pais p) {
		pais.add(p);
	}
}
