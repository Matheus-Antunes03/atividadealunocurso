package br.com.senai.aluno;

import br.com.senai.curso.Curso;
import br.com.senai.curso.CursoController;

import java.util.List;
import java.util.Scanner;

public class AlunoController {

	CursoController cursoController = new CursoController();

	private Scanner tec;

	public AlunoController() {
		tec = new Scanner(System.in);
	}

	public int leopcao() {
		System.out.print("> ");
		return tec.nextInt();
	}

	public Aluno cadastrarAluno(List<Curso> cursos) {

		if (cursos.isEmpty()) {
			System.out.println("Não é possível cadastrar um aluno sem um curso cadastrado.");
			return null;
		}

		Aluno aluno = new Aluno();

		System.out.println("--- CADASTRAR ALUNO ---");
		System.out.print("Informe o nome: ");
		aluno.setNomeAluno(tec.next());

		System.out.print("Informe a idade: ");
		aluno.setIdadeAluno(tec.nextInt());

		cursoController.listarCursos(cursos);
		System.out.print("Informe o Id do curso: ");
		int idCurso = tec.nextInt() - 1;
		aluno.setCurso(cursos.get(idCurso).getNomeCurso());

		System.out.print("Informe o país: ");
		aluno.setPais(tec.next());

		System.out.print("Informe o estado: ");
		aluno.setEstado(tec.next());

		System.out.print("Informe a cidade: ");
		aluno.setCidade(tec.next());

		return aluno;
	}

	public List<Aluno> listarAlunos(List<Aluno> alunos, List <Curso> cursos) {

		if (alunos.isEmpty()) {
			System.out.println("Nenhum aluno cadastrado.");
			return null;
		}

		System.out.println("--- ALUNOS CADASTRADOS ---");

		System.out.printf("| %2s | %15s | %6s | %15s | %10s | %15s | %15s |\n", "Id", "Nome", "Idade", "Curso", "País",
				"Estado", "Cidade");

		for (int i = 0; i < alunos.size(); i++) {
			System.out.printf("| %2s | %15s | %6d | %15s | %10s | %15s | %15s |\n",
					i + 1,
					alunos.get(i).getNomeAluno(),
					alunos.get(i).getIdadeAluno(),
					cursos.get(i).getNomeCurso(),
					alunos.get(i).getPais(),
					alunos.get(i).getEstado(),
					alunos.get(i).getCidade());
		}

		return alunos;
	}

	public List<Aluno> editarAluno(List<Aluno> alunos, List<Curso> cursos) {

		Curso curso = new Curso();
		Aluno aluno = new Aluno();

		listarAlunos(alunos, cursos);

		if (alunos.isEmpty()) {
			return null;
		}

		System.out.print("Informe o Id do aluno para editar: ");
		int idAluno = tec.nextInt() - 1;

		System.out.println("1) Nome");
		System.out.println("2) Idade");
		System.out.println("3) Curso");
		System.out.println("4) Pais");
		System.out.println("5) Estado");
		System.out.println("6) Cidade");
		System.out.print("Informe o campo que deseja editar: ");
		int opcao = tec.nextInt();

		switch (opcao) {

		case 1:
			System.out.println("--- EDITAR O NOME ---");
			System.out.print("Informe o novo nome: ");
			aluno.setNomeAluno(tec.next());

			aluno.setIdadeAluno(alunos.get(idAluno).getIdadeAluno());
			aluno.setCurso(alunos.get(idAluno).getCurso());
			aluno.setPais(alunos.get(idAluno).getPais());
			aluno.setEstado(alunos.get(idAluno).getEstado());
			aluno.setCidade(alunos.get(idAluno).getCidade());

			alunos.set(idAluno, aluno);
			break;

		case 2:
			System.out.println("--- EDITAR A IDADE ---");
			System.out.print("Informe a nova idade: ");
			aluno.setIdadeAluno(tec.nextInt());

			aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
			aluno.setCurso(alunos.get(idAluno).getCurso());
			aluno.setPais(alunos.get(idAluno).getPais());
			aluno.setEstado(alunos.get(idAluno).getEstado());
			aluno.setCidade(alunos.get(idAluno).getCidade());

			alunos.set(idAluno, aluno);
			break;

		case 3:
			System.out.println("--- EDITAR O CURSO ---");
			cursoController.listarCursos(cursos);
			System.out.print("Informe o Id do novo curso: ");
			int idCurso = tec.nextInt() - 1;
			aluno.setCurso(cursos.get(idCurso).getNomeCurso());

			aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
			aluno.setIdadeAluno(alunos.get(idAluno).getIdadeAluno());
			aluno.setPais(alunos.get(idAluno).getPais());
			aluno.setEstado(alunos.get(idAluno).getEstado());
			aluno.setCidade(alunos.get(idAluno).getCidade());

			alunos.set(idAluno, aluno);
			break;

		case 4:
			System.out.println("--- EDITAR O PAÍS ---");
			System.out.print("Informe o novo país: ");
			aluno.setPais(tec.next());

			aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
			aluno.setIdadeAluno(alunos.get(idAluno).getIdadeAluno());
			aluno.setCurso(alunos.get(idAluno).getCurso());
			aluno.setEstado(alunos.get(idAluno).getEstado());
			aluno.setCidade(alunos.get(idAluno).getCidade());

			alunos.set(idAluno, aluno);
			break;

		case 5:
			System.out.println("--- EDITAR O ESTADO ---");
			System.out.print("Informe o novo estado: ");
			aluno.setEstado(tec.next());

			aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
			aluno.setIdadeAluno(alunos.get(idAluno).getIdadeAluno());
			aluno.setCurso(alunos.get(idAluno).getCurso());
			aluno.setPais(alunos.get(idAluno).getPais());
			aluno.setCidade(alunos.get(idAluno).getCidade());

			alunos.set(idAluno, aluno);
			break;

		case 6:
			System.out.println("--- EDITAR A CIDADE ---");
			System.out.print("Informe a nova cidade: ");
			aluno.setCidade(tec.next());

			aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
			aluno.setIdadeAluno(alunos.get(idAluno).getIdadeAluno());
			aluno.setCurso(alunos.get(idAluno).getCurso());
			aluno.setPais(alunos.get(idAluno).getPais());
			aluno.setEstado(alunos.get(idAluno).getEstado());

			alunos.set(idAluno, aluno);
			break;

		default:
			System.out.println("Opção Inválida!");
			break;
		}
		return alunos;
	}

	public void excluirAlunos(List<Aluno> alunos, List<Curso> cursos) {

		listarAlunos(alunos, cursos);

		if (alunos.isEmpty()) {
			return;
		}

		System.out.println("--- EXCLUIR ALUNO ---");

		System.out.print("Informe o Id do aluno para excluir: ");
		int idAluno = tec.nextInt() - 1;
		if (alunos.size() <= idAluno) {
			System.out.println("Aluno não cadastrado.");
			return;
		}
		alunos.remove(idAluno);
	}

	public void menu1(List<Aluno> alunos, List<Curso> cursos) {

		boolean sair = false;
		do {
			System.out.println("--- MENU ---");
			System.out.println("1) Cadastrar aluno");
			System.out.println("2) Listar alunos");
			System.out.println("3) Editar aluno");
			System.out.println("4) Excluir aluno");
			System.out.println("5) Voltar");

			int opcao = leopcao();
			switch (opcao) {
			case 1:
				alunos.add(cadastrarAluno(cursos));
				break;

			case 2:
				listarAlunos(alunos, cursos);
				break;

			case 3:
				editarAluno(alunos, cursos);
				break;

			case 4:
				excluirAlunos(alunos, cursos);
				break;

			case 5:
				sair = true;
				break;

			default:
				System.out.println("Opção Inválida!");
				break;
			}
		} while (!sair);
	}
}
