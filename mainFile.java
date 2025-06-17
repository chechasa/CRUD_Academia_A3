
import java.util.Scanner;

import dao.AlunoDAO;
import dao.TreinoDAO;
import model.Aluno;
import model.Treino;



public class mainFile {



public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

        int opcaoPrincipal;

        do {
            System.out.println("===============================================");
            System.out.println("              SISTEMA DE ACADEMIA              ");	
            System.out.println("===============================================");
            System.out.println("1 - Alunos");
            System.out.println("2 - Treinos");
            System.out.println("0 - Sair");
            System.out.println("===============================================");

            System.out.print("Escolha uma opção: ");
            opcaoPrincipal = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer do teclado

            switch (opcaoPrincipal) {
                case 1:
                    menuAlunos(scanner);
                    break;
                case 2:
                    menuTreinos(scanner);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcaoPrincipal != 0);

        scanner.close();
    }



 private static void menuAlunos(Scanner scanner) {
        int opcaoPrincipal;
        AlunoDAO alunoDAO = new AlunoDAO();

        do {
            System.out.println("\n===============================================");
            System.out.println("               MENU DE ALUNOS                  ");
            System.out.println("===============================================");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Listar Alunos");
            System.out.println("3 - Editar Alunos");
            System.out.println("4 - Excluir Alunos ");
            System.out.println("5 - Buscar Aluno por Nome ou Cpf");
            System.out.println("0 - Sair");
            System.out.println("===============================================");
            
            System.out.print("Escolha uma opção: ");
            opcaoPrincipal = scanner.nextInt();
            scanner.nextLine(); 
         
        
                switch (opcaoPrincipal) {
                case 1:
                    System.out.println("Para cadastrar um aluno, vamos precisar somente de 5 informações");
                    System.out.println("Nome: ");
                    String nomeAluno = scanner.nextLine();
                    System.out.println("CPF: ");
                    String cpfAluno = scanner.nextLine();
                    System.out.println("Data de nascimento: ");
                    String dataNascimentoAluno = scanner.nextLine();
                    System.out.println("Telefone: ");
                    String telefoneAluno = scanner.nextLine();
                    System.out.println("Email: ");
                    String emailAluno = scanner.nextLine();



                    Aluno alunoSalvar = new Aluno(nomeAluno, cpfAluno, dataNascimentoAluno, telefoneAluno, emailAluno);
                    
                    try{

                        alunoDAO.salvar(alunoSalvar);
                        
                    } catch (Exception e) {
                    System.out.println("Erro ao salvar aluno: " + e.getMessage());
                    }

                    System.out.println("Aluno Registrado com Sucesso! ");

                    break;
                case 2:
                try{
                    System.out.println(alunoDAO.listarTodos());
                    

                    
                  } catch (Exception e) {
        System.out.println("Erro ao salvar aluno: " + e.getMessage());
    }
                    break;
                case 3:


                    System.out.println("Para editar informações sobre um aluno, por favor digite seu cpf, (xxx.xxx.xxx-xx)");
                    System.out.println("CPF: ");
                    String cpfAlunoAtualizado = scanner.nextLine();

                    System.out.println("Agora digite todos os dados para atualizacao");

                    System.out.println("Nome: ");
                    String nomeAlunoAtualizado = scanner.nextLine();
                    System.out.println("Data de nascimento: ");
                    String dataNascimentoAlunoAtualizado = scanner.nextLine();
                    System.out.println("Telefone: ");
                    String telefoneAlunoAtualizado = scanner.nextLine();
                    System.out.println("Email: ");
                    String emailAlunoAtualizado = scanner.nextLine();

                    Aluno alunoAtualizar = new Aluno(nomeAlunoAtualizado, cpfAlunoAtualizado, dataNascimentoAlunoAtualizado, telefoneAlunoAtualizado, emailAlunoAtualizado);
    try{

        alunoDAO.atualizar(alunoAtualizar);
      } catch (Exception e) {
        System.out.println("Erro ao salvar aluno: " + e.getMessage());
    }

                    break;
                case 4:
                    System.out.println("Porfavor digite o nome ou o CPF (xxx.xxx.xxx-xx), do aluno a ser excluido");
                    String dadoAlunoExcluido = scanner.nextLine();
                    try{

                        alunoDAO.excluir(dadoAlunoExcluido);
                      } catch (Exception e) {
        System.out.println("Erro ao salvar aluno: " + e.getMessage());
    }

                    break;
                case 5:
                    System.out.println("Porfavor digite o nome ou o CPF (xxx.xxx.xxx-xx), do aluno à ser pesquisado");
                    String dadoAlunoPesquisado = scanner.nextLine();
                    try{


                        System.out.println(alunoDAO.buscarPorNomeOuCpf(dadoAlunoPesquisado));
                        
                      } catch (Exception e) {
        System.out.println("Erro ao salvar aluno: " + e.getMessage());
    }

                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcaoPrincipal != 0);
    }

    private static void menuTreinos(Scanner scanner) {
        int opcaoPrincipal;
        TreinoDAO treinoDao = new TreinoDAO();
        do {
            System.out.println("===============================================");
            System.out.println("                 MENU TREINOS                  ");
            System.out.println("===============================================");
            System.out.println("1 - Cadastrar Treino");
            System.out.println("2 - Listar Treinos");
            System.out.println("3 - Editar Treino");
            System.out.println("4 - Excluir Treino");
            System.out.println("0 - Voltar");
            System.out.println("===============================================");

            System.out.print("Escolha uma opção: ");
            opcaoPrincipal = scanner.nextInt();
            scanner.nextLine(); 

             
                switch (opcaoPrincipal) {
                case 1:
                    System.out.println("Para cadastrar um treino, vamos precisar de 5 informações, ai vai:");


                    System.out.println("Tipo de treino (Calistenia, Musculacao, CrossFit): ");
                    String tipoDeTreino = scanner.nextLine();

                    System.out.println("Data de inicio: ");
                    String dataInicioTreino = scanner.nextLine();

                    System.out.println("Duracao do treino (em minutos): ");
                    int duracaoTreino = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Descricao do treino: ");
                    String descricaoTreino = scanner.nextLine();

                    System.out.println("Id do Aluno: ");
                    int IdAluno = scanner.nextInt();





try{

    Treino treinoSalvar = new Treino(IdAluno, tipoDeTreino, descricaoTreino, duracaoTreino, dataInicioTreino);
    treinoDao.salvar(treinoSalvar);
  } catch (Exception e) {
        System.out.println("Erro ao salvar aluno: " + e.getMessage());
    }

                    System.out.println("Treino Registrado com Sucesso! ");

                    break;
                case 2:
                    System.out.println("Para listar os treinos do aluno, digite o Id Aluno: ");
                    int IdAlunoListar = scanner.nextInt();
                try{

                    System.out.println(treinoDao.listarPorAluno(IdAlunoListar));
                    

                  } catch (Exception e) {
        System.out.println("Erro ao salvar aluno: " + e.getMessage());
    }
                    break;

                case 3:

                    System.out.println("Para editar um treino, o id do treino a ser atualizado:");

                    System.out.println("Id do Treino: ");
                    int idTreinoAtualizado = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Tipo de treino (Calistenia, Musculacao, CrossFit): ");
                    String tipoDeTreinoAtualizado = scanner.nextLine();

                    System.out.println("Data de inicio: ");
                    String dataInicioTreinoAtualizado = scanner.nextLine();

                    System.out.println("Duracao do treino (em minutos): ");
                    int duracaoTreinoAtualizado = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Descricao do treino: ");
                    String descricaoTreinoAtualizado = scanner.nextLine();

                Treino treinoAtualizar = new Treino(tipoDeTreinoAtualizado, descricaoTreinoAtualizado, duracaoTreinoAtualizado, dataInicioTreinoAtualizado);


                try{

                    treinoDao.atualizar(treinoAtualizar, idTreinoAtualizado);
                  } catch (Exception e) {
        System.out.println("Erro ao salvar aluno: " + e.getMessage());
    }

                    break;
                case 4:
                    System.out.println("Para excluir um treino, digite o id treino:");
                    int idTreinoExcluido = scanner.nextInt();
                    try{

                        treinoDao.excluir(idTreinoExcluido);
                    
                      } catch (Exception e) {
        System.out.println("Erro ao salvar aluno: " + e.getMessage());
    }
                    break;

                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcaoPrincipal != 0);
    }

  

}

   

