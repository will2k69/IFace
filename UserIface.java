import java.util.ArrayList;

public class UserIface extends UserPage{
    private String name, login, pass;
    private int id;
    protected ArrayList<Integer> pedidosDeAmizades = new ArrayList<Integer>();
    protected ArrayList<UserIface> friends = new ArrayList<UserIface>();

    //constructor...
    public UserIface(String nome, String login, String senha) {
        setName(nome);
        setLogin(login);
        setPass(senha);
    }//<

    /*public void solicitarAmizade(int idFriend) {
        usersList.get(idFriend).pedidosDeAmizades.add(this.getId());
        System.out.println("Foi enviada uma solicitação de amizade para " + usersList.get(idFriend).getLogin() + "!\n");
    }*/
    
    public void status() {
        System.out.println("\n\n========STATUS========");
        System.out.println("Nome: " + getName());
        System.out.println("Login: " + getLogin());
        System.out.println("Senha: " + getPass());
        System.out.println("======================");
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