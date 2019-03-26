package br.com.estevaocristino.dsp20191.aulas0508.as;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Avaliacao {
	
	static Scanner scan = new Scanner(System.in);
	
	static File file = new File("src/main/resources/avaliacao.dat");
	
	static DataOutputStream outStream;
	
	static FileOutputStream outFile;

	private static DataInputStream inStream;

	public static void main(String[] args) {
//		instanciaAluno();
		lerAluno();

	}
	
	private static void lerAluno() {
		Aluno aluno = new Aluno();
		try {
			FileInputStream inFile = new FileInputStream(file);
			inStream = new DataInputStream(inFile);
			System.out.println(inStream.readUTF());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void verificaArquivo() {
		try {
			outFile = new FileOutputStream(file);
			outStream = new DataOutputStream(outFile);
		} catch (FileNotFoundException e) {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
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
		verificaArquivo();
		try {
			outStream.writeChars(aluno.getNome());
			outStream.writeLong(aluno.getMatricula());
			outStream.writeDouble(aluno.getNota1());
			outStream.writeDouble(aluno.getNota2());
			outStream.close();
			outFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
