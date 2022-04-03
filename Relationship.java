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
            op = keyboard.next();

            if (op.equals("0"))
                break;
            
            else if (op.equals("a") || op.equals("A")) {
                System.out.println("\nDigite o número da solicitação:\n(Tecle 'a' para aceitar TODAS)");
                op = keyboard.next();
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
}
