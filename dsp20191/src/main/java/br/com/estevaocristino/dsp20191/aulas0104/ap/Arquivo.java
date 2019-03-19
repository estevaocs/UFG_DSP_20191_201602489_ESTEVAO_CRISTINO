package br.com.estevaocristino.dsp20191.aulas0104.ap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {

	public static void main(String[] args) throws IOException {
		File arquivo = new File("arquivo.txt");
		Arquivo a = new Arquivo();
		a.write(arquivo.getAbsolutePath(), "conteúdo");
		a.read(arquivo.getAbsoluteFile().toString());
	}

	public void read(String path) throws IOException {
		try (FileReader reader = new FileReader(path)) {
			BufferedReader br = new BufferedReader(reader);
			String line = br.readLine();

			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}
	}

	public void write(String path, String conteudo) {
		try {
			FileWriter fw = new FileWriter(path, true);
			BufferedWriter conexao = new BufferedWriter(fw);
			conexao.write(conteudo);
			conexao.newLine();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
