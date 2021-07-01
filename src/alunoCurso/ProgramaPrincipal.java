package alunoCurso;

import br.com.senai.aluno.AlunoController;
import br.com.senai.curso.Curso;
import br.com.senai.curso.CursoController;
import br.com.senai.aluno.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		
		List<Aluno> alunos = new ArrayList<>();
		List<Curso> cursos = new ArrayList<>();

		AlunoController alunoController = new AlunoController();
		CursoController cursoController = new CursoController();

		Scanner tec = new Scanner(System.in);
		boolean sair = false;

		do {
			System.out.println("--- MENU ---");
			System.out.println("1) Registro de Alunos");
			System.out.println("2) Registro de Cursos");
			System.out.println("3) Sair");
			System.out.print("> ");
			int opcao = tec.nextInt();
			switch (opcao) {
			case 1:
				alunoController.menu1(alunos, cursos);
				break;

			case 2:
				cursoController.menu2(cursos, alunos);
				break;

			case 3:
				sair = true;
				break;

			default:
				System.out.println("Opção Inválida!");
				break;
			}
		} while (!sair);
		System.out.println("Sistema encerrado!");
	}
}
