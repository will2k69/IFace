import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class MainPageIface {
    private static Scanner keyboard = new Scanner(System.in);
    private static String opcao;
    private static UserPage host = new UserPage();
    protected HashMap<String, UserIface> trash = new HashMap<String, UserIface>();
    protected HashMap<String, UserIface> usersList = new HashMap<String, UserIface>();//key=login
    protected HashMap<String, Comunidades> communitys = new HashMap<String, Comunidades>();//key=nome da community

    public void execute(HashMap<String, UserIface> list) {}

    public static void main(String[] args) throws IOException, InterruptedException {
        clear();
        
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
        
            System.out.println("tecle ENTER para sair: ");
            keyboard.nextLine();
            clear();
        }
        keyboard.close();
    }

    //função para limpar tela
    static void clear() throws IOException, InterruptedException{
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            new ProcessBuilder("clear").inheritIO().start().waitFor();
    }
}