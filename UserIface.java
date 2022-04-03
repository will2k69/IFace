import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserIface{
    Scanner kScanner = new Scanner(System.in);
    HashMap<String, ArrayList<String>> conversations = new HashMap<String, ArrayList<String>>();
    public ArrayList<Integer> pedidosDeAmizades = new ArrayList<Integer>();//contem 'ids' de users que querem ser amigos
    public ArrayList<UserIface> friends = new ArrayList<UserIface>();
    private String name, login, pass;
    private int id;

    //constructor...
    public UserIface(String nome, String login, String senha) {
        setName(nome);
        setLogin(login);
        setPass(senha);
    }//<
    
    public void status() {
        System.out.println("\n\n========STATUS========");
        System.out.println("Nome: " + getName());
        System.out.println("Login: " + getLogin());
        System.out.println("Senha: " + getPass());
        System.out.println("======================");
    }

    public void listarAmigos() {
        System.out.println("\n\n========LISTA DE AMIGOS========");
        for (UserIface uFriends: this.friends) {
            System.out.println(uFriends.getLogin());
        }
        System.out.println("===============================\n");
    }

    //getters
    public String getName() {
        return this.name;
    }
    public String getPass() {
        return this.pass;
    }
    public String getLogin() {
        return this.login;
    }
    public int getId() {
        return this.id;
    }
    //setters
    public void setName(String n) {
        this.name = n;
    }
    public void setLogin(String l) {
        this.login = l;
    }
    public void setPass(String p) {
        this.pass = p;
    }
    public void setId(int i) {
        this.id = i;
    }
}