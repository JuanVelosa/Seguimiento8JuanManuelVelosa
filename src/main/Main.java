package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import model.Medalla;
import model.Pais;
import model.PaisData;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		start();
	}

	public static void start() {
		String[] split = null;
		String tx = "";
		try {

			FileInputStream file = new FileInputStream(new File("src/data/in.txt"));
			BufferedReader reader = new BufferedReader(new InputStreamReader(file));
			tx = "";
			String line;
			while ((line = reader.readLine()) != null) {
				tx += line;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		split = tx.split(" ");
		int paises = Integer.parseInt(split[0].replace(" ", ""));
		PaisData data = new PaisData();
		String[] info = new String[paises];

		for (int i = 0; i < paises; i++) {

			info[i] = split[i + 1];
			data = orden(data, "1", info[i].split(";"), paises);

		}

		System.out.print("\nRama Masculina \n");
		data.print();

		System.out.print("\n----------\n");
		data.cleanData();

		for (int i = 0; i < paises; i++) {
			data = orden(data, "2", info[i].split(";"), paises);
		}

		data.orden();
		System.out.print("\nRama Femenina \n");
		data.print();
		System.out.print("\n----------\n");
		data.cleanData();
		for (int i = 0; i < paises; i++) {
			data = orden(data, "3", info[i].split(";"), paises);
		}
		data.orden();
		System.out.print("\nCombinado Masculino Y femenino \n ");
		data.print();
	}

	public static PaisData orden(PaisData data, String tipo, String[] split, int paises) {
		data.addPais(
				new Pais(split[0], new Medalla(Integer.parseInt(split[1])), new Medalla(Integer.parseInt(split[2])),
						new Medalla(Integer.parseInt(split[3])), new Medalla(Integer.parseInt(split[4])),
						new Medalla(Integer.parseInt(split[5])),
						new Medalla(Integer.parseInt(split[6])), tipo));
		data.orden();
		return data;

	}

}
