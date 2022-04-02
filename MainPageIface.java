import java.util.Scanner;

public class MainPageIface {
    protected static Scanner tec = new Scanner(System.in);
    protected static int opcao;
    protected static UserPage host = new UserPage();
    public static void main(String[] args) {
        
        while (true) {

            System.out.println("================IFace================");
            System.out.println("Bem-vind@ a página inicial do IFace!");
            System.out.println("=====================================");
            System.out.printf("\nDigite:\n1 - Fazer login\n2 - Criar uma conta\n0 - SAIR\n\nDigite aqui: ");
            opcao = tec.nextInt();
            System.out.println();
            if (opcao == 1) {
                while (true) {
                    System.out.println("Digite seu login: ");
                    String log = tec.next();
                    System.out.println("Digite sua senha: ");
                    String sen = tec.next();
                    if (host.isUser(log, sen)) {
                        host.inicio(log, sen);
                        break;
                    }
                    else {
                        System.out.println("ERROR 404: User or pass not found");
                        System.out.printf("1 - Tentar de novo\n0 - SAIR\n");
                        int op = tec.nextInt();
                        if (op == 0)
                            break;
                    }
                }
            }
            else if (opcao == 2) {
                host.createUser();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Usuário cadastrado com sucesso!");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            }
            else
                break;
        }
        tec.close();
    }
}