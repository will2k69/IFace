import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class Relationship {

    Scanner keyboard = new Scanner(System.in);
    String op;


    public void solicitarAmizade(String user, String friend, HashMap<String, UserIface> list) {
        list.get(friend).pedidosDeAmizades.add(user);
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Foi enviada uma solicitação de amizade para " + "'" + list.get(friend).getLogin() + "'" + "!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    public void solicitacoes(String loginUser, HashMap<String, UserIface> list) {
        System.out.println("\n=============SOLICITAÇÕES DE AMIZADE=============");
        for (int i=0; i < list.get(loginUser).pedidosDeAmizades.size(); i++) {
            System.out.println(i + " - " + list.get(loginUser).pedidosDeAmizades.get(i));
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
                    String loginFriend = list.get(loginUser).pedidosDeAmizades.get(iAux);
                    //adicionando a lista de amigos de 'idUser' e 'idFriend'
                    list.get(loginUser).friends.add(list.get(loginFriend));
                    list.get(loginFriend).friends.add(list.get(loginUser));
                    //removendo o pedido de 'idFriend' da lista de solicitacoes de 'idUser'
                    list.get(loginUser).pedidosDeAmizades.remove(iAux);

                    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Usuários " + "'" + loginUser + "'" + " e " + "'" + loginFriend + "'" + " agora são amig@s! ^_^");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                }
            }
            
            else if (op.equals("r") || op.equals("R")) {
                System.out.println("\nDigite o número da solicitação:\n(Tecle 'r' para rejeitar TODAS)");
                op = keyboard.nextLine();
                if (Integer.parseInt(op) >= 0) {

                }
            }
        }
    }

    public void sendMessage(String loginUser, String loginDestiny, HashMap<String, UserIface> list) {
        if (list.get(loginUser).conversations.get(loginDestiny) == null) {
            ArrayList<String> frases = new ArrayList<String>();
            list.get(loginUser).conversations.put(loginDestiny, frases);
            list.get(loginDestiny).conversations.put(loginUser, frases);
        }
        else {
            System.out.println("\n==========================");
            for (String historico: list.get(loginUser).conversations.get(loginDestiny))
                System.out.println(historico);
        }
        System.out.println("\nEnvie ':q' para sair do chat");
        while (true) {
            String msg = keyboard.nextLine();
            if (msg.equals(":q"))
                break;
            String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());
            msg = "[" + timeStamp + "] " + loginUser + ": " + msg;
            list.get(loginUser).conversations.get(loginDestiny).add(loginUser + ": " + msg);
        }
    }

    public void sendMessageMyFeed(String loginUser, HashMap<String, UserIface> list) {
        System.out.println("\n=====================FEED DE NOTÍCIAS=====================");
        for (String historico: list.get(loginUser).myFeed) {
            for (int i=1; i < historico.length(); i++) {
                System.out.print(historico.charAt(i));
            }
            System.out.println();
        }

        System.out.println("\nDigite ':q' para sair\nDigite ':f' no final da mensagem para ser vista apenas pelos migos ^_^\n");
        
        while (true) {
            String msg = keyboard.nextLine();
            if (msg.equals(":q"))
                break;
            String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());
            if (msg.length() > 2 && (msg.charAt(msg.length()-1) == 'f' && msg.charAt(msg.length()-2) == ':')) {
                msg = msg.substring(0, msg.length()-2);//para remover os dois últimos chars:':f'
                msg = "f" + "[" + timeStamp + "] " + loginUser + "(amigos)" + ": " + msg;
            }
            else
                msg = "p" + "[" + timeStamp + "] " + loginUser + "(público)" + ": " + msg;
            list.get(loginUser).myFeed.add(msg);
        }
    }

    public void sendMessageFeed(String loginUser, String loginDestiny, HashMap<String, UserIface> list) {
        System.out.println("\n=============FEED DE NOTÍCIAS D@ " + loginDestiny + "=============");
        boolean friend=false;
        for (UserIface u: list.get(loginDestiny).friends) {
            if (u.getLogin().equals(loginUser)) {
                friend=true;
                break;
            }
        }
        
        for (String historico: list.get(loginDestiny).myFeed) {
            if (historico.charAt(0) == 'f') {
                if (!friend)
                    continue;
            }
            for (int i=1; i < historico.length(); i++) {
                System.out.print(historico.charAt(i));
            }
            System.out.println();
        }

        System.out.println("\nDigite ':q' para sair\n");
        while (true) {
            String msg = keyboard.nextLine();
            if (msg.equals(":q"))
                break;
            String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());
            msg = "p" + "[" + timeStamp + "] " + loginUser + ": " + msg;
            list.get(loginDestiny).myFeed.add(msg);
        }
    }
}
