import java.util.ArrayList;
import java.util.Scanner;

public class Relationship {

    Scanner keyboard = new Scanner(System.in);
    String op;


    public void solicitarAmizade(int idUser, int idFriend, ArrayList<UserIface> list) {
        list.get(idFriend).pedidosDeAmizades.add(idUser);
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Foi enviada uma solicitação de amizade para " + "'" + list.get(idFriend).getLogin() + "'" + "!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    public void solicitacoes(int idUser, ArrayList<UserIface> list) {
        System.out.println("\n=============SOLICITAÇÕES DE AMIZADE=============");
        for (int i=0; i < list.get(idUser).pedidosDeAmizades.size(); i++) {
            System.out.println(i + " - " + list.get(list.get(idUser).pedidosDeAmizades.get(i)).getLogin());
        }
        System.out.println("==================================================");
        
        while (true) {
            System.out.println("O que deseja fazer?\nTecle 'a' para Aceitar\nTecle 'r' para Rejeitar\n'0' para sair");        
            op = keyboard.nextLine();

            if (op.equals("0"))
                break;
            
            else if (op.equals("a") || op.equals("A")) {
                System.out.println("\nDigite o número da solicitação:\n(Tecle 'a' para aceitar TODAS)");
                op = keyboard.nextLine();
                if (op.equals("a") || op.equals("A")) {

                }
                else {
                    int iAux = Integer.parseInt(op);
                    int idFriend = list.get(idUser).pedidosDeAmizades.get(iAux);
                    //adicionando a lista de amigos de 'idUser' e 'idFriend'
                    list.get(idUser).friends.add(list.get(idFriend));
                    list.get(idFriend).friends.add(list.get(idUser));
                    //removendo o pedido de 'idFriend' da lista de solicitacoes de 'idUser'
                    list.get(idUser).pedidosDeAmizades.remove(iAux);

                    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Usuários " + "'" + list.get(idUser).getLogin() + "'" + " e " + "'" + list.get(idFriend).getLogin() + "'" + " agora são amig@s! ^_^");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                }
            }
            
            else if (op.equals("r") || op.equals("R")) {
                System.out.println("\nDigite o número da solicitação:\n(Tecle 'r' para rejeitar TODAS)");
                op = keyboard.next();
                if (Integer.parseInt(op) >= 0) {

                }
            }
        }
    }

    public void sendMessage(int idDestiny, int idUser, ArrayList<UserIface> list, String loginDestiny) {
        if (list.get(idUser).conversations.get(loginDestiny) == null) {
            ArrayList<String> frases = new ArrayList<String>();
            list.get(idUser).conversations.put(loginDestiny, frases);
            list.get(idDestiny).conversations.put(list.get(idUser).getLogin(), frases);
        }
        else {
            System.out.println("\n==========================");
            for (String historico: list.get(idUser).conversations.get(loginDestiny))
                System.out.println(historico);
        }
        System.out.println("\nEnvie ':q' para sair do chat");
        while (true) {
            String msg = keyboard.nextLine();
            if (msg.equals(":q"))
                break;
            list.get(idUser).conversations.get(loginDestiny).add(list.get(idUser).getLogin() + ": " + msg);
        }
    }
}
