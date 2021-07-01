package br.com.senai.curso;

import java.util.List;
import java.util.Scanner;

import br.com.senai.aluno.Aluno;

public class CursoController {

	private Scanner tec;

	public CursoController() {
		tec = new Scanner(System.in);
	}

	public int leopcao() {
		System.out.print("> ");
		return tec.nextInt();
	}

	public Curso cadastrarCurso() {

		Curso curso = new Curso();

		System.out.println("--- CADASTRAR CURSO ---");
		System.out.print("Informe o nome do curso: ");
		curso.setNomeCurso(tec.next());

		return curso;
	}

	public List<Curso> listarCursos(List<Curso> cursos) {

		if (cursos.isEmpty()) {
			System.out.println("Nenhum curso cadastrado.");
			return null;
		}

		System.out.println("--- CURSOS CADASTRADOS ---");

		System.out.printf("| %2s | %10s |\n", "Id", "Curso");

		for (int i = 0; i < cursos.size(); i++) {
			System.out.printf("| %2s | %10s |\n", i + 1, cursos.get(i).getNomeCurso());
		}

		return cursos;
	}

	public List<Curso> editarCurso(List<Curso> cursos) {

		Curso curso = new Curso();

		listarCursos(cursos);

		if (cursos.isEmpty()) {
			return null;
		}

		System.out.print("Informe o Id do curso para editar: ");
		int idCurso = tec.nextInt() - 1;

		System.out.println("1) Nome");
		System.out.print("Informe o campo que deseja alterar: ");
		int opcao = tec.nextInt();

		switch (opcao) {

		case 1:
			System.out.println("--- EDITAR O NOME DO CURSO ---");
			System.out.print("Informe o novo nome do curso: ");
			curso.setNomeCurso(tec.next());

			cursos.set(idCurso, curso);
			break;

		default:
			System.out.println("Opção Inválida!");
			break;
		}
		return cursos;
	}

	public void excluirCursos(List<Curso> cursos, List<Aluno> alunos) {

		listarCursos(cursos);

		if (cursos.isEmpty()) {
			return;
		}

		System.out.println("--- EXCLUIR CURSO ---");
		System.out.print("Informe o Id do curso para excluir: ");
		int idCurso = tec.nextInt() - 1;
		
		if (cursos.size() <= idCurso) {
			System.out.println("Curso não cadastrado.");
			return;
		}
		
		if (alunos.isEmpty()) {
			cursos.remove(idCurso);
			return;
		}
		
		if (cursos.get(idCurso).getNomeCurso() == alunos.get(idCurso).getCurso()) {
			System.out.println("Não é possível excluir um curso que possua um aluno cadastrado.");
			return;
		}
		cursos.remove(idCurso);
	}

	public void menu2(List<Curso> cursos, List<Aluno> alunos) {

		boolean sair = false;

		do {
			System.out.println("--- MENU ---");
			System.out.println("1) Cadastrar Curso");
			System.out.println("2) Listar Cursos");
			System.out.println("3) Editar Curso");
			System.out.println("4) Excluir Curso");
			System.out.println("5) Voltar");

			int opcao = leopcao();
			switch (opcao) {
			case 1:
				cursos.add(cadastrarCurso());
				break;

			case 2:
				listarCursos(cursos);
				break;

			case 3:
				editarCurso(cursos);
				break;

			case 4:
				excluirCursos(cursos, alunos);
				break;

			case 5:
				sair = true;
				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}

		} while (!sair);
	}
}
