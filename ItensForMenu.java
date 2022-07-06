import java.text.SimpleDateFormat;
import java.util.*;

public class ItensForMenu {
    Scanner keyboard = new Scanner(System.in);
    String login;
    protected HashMap<String, UserIface> trash = new HashMap<String, UserIface>();
    protected HashMap<String, UserIface> usersList = new HashMap<String, UserIface>();//key=login
    protected HashMap<String, Comunidades> communitys = new HashMap<String, Comunidades>();//key=nome da community

    public void execute(ItensForMenu ifm) {}//polimorfismo ai que lindo :D
    
    public void chatMessage(String loginUser, String loginDestiny, HashMap<String, UserIface> list) {
        while (true) {
            String msg = keyboard.nextLine();
            if (msg.equals(":q"))
                break;
            String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());
            String cpy = "[" + timeStamp + "] " + loginUser + ": " + msg;
            list.get(loginUser).conversations.get(loginDestiny).add(cpy);
        }
    }

    public void chatMessage(String nomeDaComuna, HashMap<String, Comunidades> communitys) {
        while (true) {
            String msg = keyboard.nextLine();
            if (msg.equals(":q"))
                break;
            String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());
            msg = "[" + timeStamp + "] " + login + ": " + msg;
            communitys.get(nomeDaComuna).sendAMessage(msg);
        }
    }

    public void chatMessageWithF(String loginUser, HashMap<String, UserIface> list) {
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

    public void chatMessageF(String loginUser, String loginDestiny, HashMap<String, UserIface> list) {
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