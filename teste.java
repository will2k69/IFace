import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcao;
        
        Iface novoUsuario = new Iface();
        while (true) {
            System.out.printf("Digite uma opção:\n1 - Criar usuário\n2 - Modificar dados de usuário\n3 - Mostrar usuários\n4 - Remover usuário\n0 - SAIR\n");

            opcao = teclado.nextInt();
            if (opcao == 0) {
                break;
            }
            else if (opcao == 1) {
                novoUsuario.criarConta();
            }
            else if (opcao == 2) {
                novoUsuario.userConfig();
            }
            else if (opcao == 3) {
                novoUsuario.users();
            }
            else if (opcao == 4) {
                novoUsuario.removeUser();
            }
        }

        teclado.close();        
    }
}