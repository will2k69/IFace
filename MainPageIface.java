import java.io.*;
import java.util.Scanner;

public class MainPageIface {
    private static Scanner keyboard = new Scanner(System.in);
    private static String opcao;
    private static UserPage host = new UserPage();
    private static LimpaTela limpador = new LimpaTela();
    
    public static void main(String[] args) throws IOException, InterruptedException {
        limpador.clear();

        while (true) {
            System.out.println("================IFace================");
            System.out.println("Bem-vind@ a página inicial do IF@ce!");
            System.out.println("=====================================");
            System.out.printf("\nDigite:\n1 - Fazer login\n2 - Criar uma conta\n3 - Recuperar conta IF@ce\n0 - SAIR\n\nDigite aqui: ");
            opcao = keyboard.nextLine();
            
            System.out.println();
            if (opcao.equals("1")) {
                while (true) {
                    System.out.println("Digite seu login: ");
                    String log = keyboard.nextLine();
                    System.out.println("Digite sua senha: ");
                    String sen = keyboard.nextLine();
                    
                    try {
                        host.isUser(log, sen);
                        limpador.clear();
                        host.inicio(log, sen);
                    } catch (NullPointerException npe) {
                        System.out.println("\n=========================================");
                        System.out.println("ERROR 404: User or pass not found\n");
                        System.out.println("=========================================\n");
                    }
                    System.out.printf("1 - Tentar de novo\n0 - SAIR\n");
                    opcao = keyboard.nextLine();
                    if (opcao.equals("0"))
                        break;
                }
            }
            
            else if (opcao.equals("2"))
                host.createUser();

            else if (opcao.equals("3")) {
                System.out.println("Digite seu login: ");
                String log = keyboard.nextLine();
                System.out.println("Digite sua senha: ");
                String sen = keyboard.nextLine();
                
                if (host.ifm.trash.get(log) != null) {
                    if (host.ifm.trash.get(log).getPass().equals(sen)) {
                        host.ifm.usersList.put(log, host.ifm.trash.get(log));
                        host.ifm.trash.remove(log);
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
        
            System.out.println("tecle ENTER para sair: ");
            keyboard.nextLine();
            limpador.clear();
        }
        keyboard.close();
    }
}