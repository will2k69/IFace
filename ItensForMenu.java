import java.util.*;

public class ItensForMenu {
    Scanner keyboard = new Scanner(System.in);
    String login;
    protected HashMap<String, UserIface> trash = new HashMap<String, UserIface>();
    protected HashMap<String, UserIface> usersList = new HashMap<String, UserIface>();//key=login
    protected HashMap<String, Comunidades> communitys = new HashMap<String, Comunidades>();//key=nome da community

    public void execute(ItensForMenu ifm) {}//polimorfismo ai que lindo :D
}