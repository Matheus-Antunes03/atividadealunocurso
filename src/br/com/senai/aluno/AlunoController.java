package br.com.senai.aluno;

import java.util.Scanner;

public class AlunoController {
	
	private Scanner tec;
	
	public AlunoController() {
		tec = new Scanner(System.in);
	}

	public int leopcao() {
		System.out.print("> ");
		return tec.nextInt();
	}
	
	public Aluno cadastrarAluno() {
		
		Aluno aluno = new Aluno();
		
		System.out.println("--- CADASTRAR ALUNO ---");
		System.out.print("Informe o nome: ");
		aluno.setNomeAluno(tec.next());
		
		System.out.print("Informe a idade: ");
		aluno.setIdadeAluno(tec.nextInt());
		
		System.out.println("Informe o curso: ");
		aluno.setCurso(tec.next());
		
		return aluno;
	}
	System.out.println("odio");
}
