import java.util.HashMap;
import java.util.Scanner;

public class AcessFeed extends MainPageIface implements Command {
    Relacionamentos relation = new Relacionamentos();
    Scanner keyboard = new Scanner(System.in);
    String login;

    public AcessFeed(String log) {
        this.login = log;
    }

    @Override
    public void execute(HashMap<String, UserIface> list) {
        System.out.println("\n1 - Acessar meu feed\n2 - Buscar feed");
        String opcao = keyboard.nextLine();
        if (opcao.equals("1"))
            relation.sendMessageMyFeed(this.login, list);
        else if (opcao.equals("2")) {
            System.out.println("Pesquisar login: ");
            String loginDestiny = keyboard.nextLine();
            
            try {
                UserIface u = usersList.get(loginDestiny);    
                relation.sendMessageFeed(login, loginDestiny, list);
                u.getName();
            } catch (NullPointerException npe) {
                System.out.println("\n=========================================");
                System.out.println("    Usuário não encontrado :/");
                System.out.println("=========================================\n");
            }
        }
    }
}
