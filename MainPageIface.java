import java.util.ArrayList;
import java.util.Scanner;

public class MainPageIface {

    private static Scanner tec = new Scanner(System.in);
    private static String opcao;
    private static UserPage host = new UserPage();
    public ArrayList<UserIface> usersList = new ArrayList<UserIface>();
    public static void main(String[] args) {
        
        while (true) {

            System.out.println("================IFace================");
            System.out.println("Bem-vind@ a página inicial do IFace!");
            System.out.println("=====================================");
            System.out.printf("\nDigite:\n1 - Fazer login\n2 - Criar uma conta\n0 - SAIR\n\nDigite aqui: ");
            opcao = tec.nextLine();
            
            System.out.println();
            if (opcao.equals("1")) {
                while (true) {
                    System.out.println("Digite seu login: ");
                    String log = tec.nextLine();
                    System.out.println("Digite sua senha: ");
                    String sen = tec.nextLine();

                    if (host.isUser(log, sen)) {
                        host.inicio(log, sen);
                        break;
                    }
                    else {
                        System.out.println("ERROR 404: User or pass not found");
                        System.out.printf("1 - Tentar de novo\n0 - SAIR\n");
                        opcao = tec.nextLine();

                        if (opcao.equals("0"))
                            break;
                    }
                }
            }
            else if (opcao.equals("2")) {
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