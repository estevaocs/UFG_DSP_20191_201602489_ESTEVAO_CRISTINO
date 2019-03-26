package br.com.estevaocristino.dsp20191.aulas0508.as;

import javax.sound.midi.Soundbank;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static Scanner scan = new Scanner(System.in);
	
	static File file = new File("src/main/resources/avaliacao.dat");
	
	static DataOutputStream outStream;
	
	static FileOutputStream outFile;

	private static DataInputStream inStream;

	public static void main(String[] args) {
		instanciaAluno();
		lerAluno();

	}
	
	private static void lerAluno() {
		Aluno aluno = new Aluno();

		String nome;
		Long matricula;
		Double nota1;
		Double nota2;

		try {
			FileInputStream inFile = new FileInputStream(file);
			inStream = new DataInputStream(inFile);
			String s = inStream.readUTF();
			List<String> list = new ArrayList<>();
			list = Arrays.asList(s.split(","));
			nome = list.get(0);
			String mat =  list.get(1);
			matricula = Long.parseLong(mat);
			nota1 = Double.parseDouble(list.get(2));
			nota2 = Double.parseDouble(list.get(3));

			aluno.setNome(nome);
			aluno.setMatricula(matricula);
			aluno.setNota1(nota1);
			aluno.setNota2(nota2);

			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Matricula: " + aluno.getMatricula());
			System.out.println("Nota 1: " + aluno.getNota1());
			System.out.println("Nota 2: " + aluno.getNota2());

			Double md = (aluno.getNota1() + aluno.getNota2())/2;
			if (md >= 5) {
				System.out.println("Aluno Aprovado");
			} else {
				System.out.println("Aluno Reprovado");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void verificaArquivo() throws IOException {
		try {
			outFile = new FileOutputStream(file);
			outStream = new DataOutputStream(outFile);
		} catch (FileNotFoundException e) {
			file.createNewFile();
			verificaArquivo();
		}
	}

	private static void instanciaAluno() {
		
		Aluno aluno = new Aluno();
		
		String nome;
		Long matricula;
		Double nota1;
		Double nota2;
		
		System.out.println("Digite o nome do aluno: ");
		nome = scan.nextLine();
		
		System.out.println("Digite a matricula do aluno: ");
		matricula = scan.nextLong();
		
		System.out.println("Digite a nota 1: ");
		nota1 = scan.nextDouble();
		
		System.out.println("Digite a nota 2: ");
		nota2 = scan.nextDouble();
		
		aluno.setNome(nome);
		aluno.setMatricula(matricula);
		aluno.setNota1(nota1);
		aluno.setNota2(nota2);
		
		gravarAluno(aluno);

	}

	private static void gravarAluno(Aluno aluno) {
		try {
			verificaArquivo();
			outStream.writeUTF(aluno.toString());
			outStream.close();
			outFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
