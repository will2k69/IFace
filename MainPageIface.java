//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MainPageIface {
    private static Scanner tec = new Scanner(System.in);
    private static String opcao;
    private static UserPage host = new UserPage();
    public HashMap<String, UserIface> trash = new HashMap<String, UserIface>();
    public HashMap<String, UserIface> usersList = new HashMap<String, UserIface>();
    public static void main(String[] args) {
        
        while (true) {

            System.out.println("================IFace================");
            System.out.println("Bem-vind@ a página inicial do IFace!");
            System.out.println("=====================================");
            System.out.printf("\nDigite:\n1 - Fazer login\n2 - Criar uma conta\n3 - Recuperar conta IFace\n0 - SAIR\n\nDigite aqui: ");
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
                        System.out.println("\nERROR 404: User or pass not found");
                        System.out.printf("1 - Tentar de novo\n0 - SAIR\n");
                        opcao = tec.nextLine();

                        if (opcao.equals("0"))
                            break;
                    }
                }
            }
            
            else if (opcao.equals("2")) {
                host.createUser();
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Usuário cadastrado com sucesso!");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            }

            else if (opcao.equals("3")) {
                System.out.println("Digite seu login: ");
                String log = tec.nextLine();
                System.out.println("Digite sua senha: ");
                String sen = tec.nextLine();
                
                if (host.trash.get(log) != null) {
                    if (host.trash.get(log).getPass().equals(sen)) {
                        host.usersList.put(log, host.trash.get(log));
                        host.trash.remove(log);
                        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Sua conta foi recuperada, ufa! ^_^\n");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                    }
                    else
                        System.out.println("\nSenha incorreta");
                }
                else
                    System.out.println("\nUsuário não identificado!\n");
            }

            else if (opcao.equals("0"))
                break;
            else
                System.out.println("\n--------------------\nDIGITA CERTO AE, PO\n--------------------\n");
        }
        tec.close();
    }
}