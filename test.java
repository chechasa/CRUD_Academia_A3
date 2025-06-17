import java.util.Scanner;

public class test {



public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

        int opcaoPrincipal = 0;
            System.out.println("===============================================");

        do {
            System.out.println("===============================================");
            System.out.println("              SISTEMA DE ACADEMIA              ");	
            System.out.println("===============================================");
            System.out.println("1 - Editar Alunos");
            System.out.println("2 - Editar Treinos");
            System.out.println("0 - Sair");
            System.out.println("===============================================");

            System.out.print("Escolha uma opção: ");
            opcaoPrincipal = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer do teclado

        

        } while (opcaoPrincipal == 0);

        scanner.close();
}}