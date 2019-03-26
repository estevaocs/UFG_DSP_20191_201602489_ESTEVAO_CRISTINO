package br.com.estevaocristino.dsp20191.aulas0508.as;

public class Aluno {
	
	private String nome;
	
	private Long matricula;
	
	private Double nota1;
	
	private Double nota2;

	public Aluno() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public Double getNota1() {
		return nota1;
	}

	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}

	public Double getNota2() {
		return nota2;
	}

	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}

	@Override
	public String toString() {
		return nome + "," + matricula + "," + nota1 + "," + nota2;
	}
}
