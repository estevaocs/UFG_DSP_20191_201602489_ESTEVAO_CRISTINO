
package br.com.estevaocristino.dsp20191.aulas0104.ap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerCSV {

	private static String CAMINHO_CSV = "UF.csv";
	private static BufferedReader reader;

	public static void main(String[] args) throws IOException {
		List<String> csv = read(CAMINHO_CSV);
		readCSV(csv);
	}

	public static List<String> read(String file) throws FileNotFoundException, IOException {
		reader = new BufferedReader(new FileReader(file));
		List<String> linhas = new ArrayList<String>();
		String line = null;
		while ((line = reader.readLine()) != null) {
			linhas.add(line + "\n");
		}
		return linhas;
	}

	public static void readCSV(List<String> csv) {
		for (int i = 0; i < csv.size(); i++) {
			System.out.println(csv.get(i));
		}
	}
}
