import java.util.ArrayList;
import java.util.Scanner;

public class Iface {
    private Scanner keyboard = new Scanner(System.in);

    private String name, login, pass;
    public ArrayList<AddUser> list = new ArrayList<AddUser>();
    
    //constructor
    public Iface() {
        setNome("admin");
        setLogin("admin");
        setSenha("12345");
    }
    public Iface(String name, String login, String password) {
        setNome(name);
        setLogin(login);
        setSenha(password);
    }

    public void criarConta() {
        System.out.println("Digite seu nome, login e senha:");
        list.add(new AddUser(keyboard.nextLine(), keyboard.nextLine(), keyboard.nextLine()));
    }
    class AddUser {
        String nome, login, senha;
    
        public AddUser(String nome, String login, String senha) {
            this.nome = nome;
            this.login = login;
            this.senha = senha;
        }

    }

    public void users() {
        System.out.println("========LISTAGEM DE USUÁRIOS========");
        for (int i=0; i < this.list.size() ; i++) {
            System.out.printf("Nome: %s\nLogin: %s\nSenha: %s\n", this.list.get(i).nome, this.list.get(i).login, this.list.get(i).senha);
            System.out.println();
        }
    }

    public void removeUser() {
        System.out.println("========REMOVER USUÁRIO========");
        System.out.println("Digite o nome: ");
        String name = keyboard.nextLine();
        int nice=0;
        for (int i=0; i < list.size() ; i++) {
            if (list.get(i).nome.equals(name)) {
                list.remove(i);
                System.out.printf("Usúario %s removido com sucesso!\n", name);
                nice=1;
                break;
            }
        }
        if (nice == 0) {
            System.out.println("Usuário não encontrado!");
        }

        System.out.println();
    }

    public void userConfig() {
        String l;
        
        System.out.println("Qual seu nome?");
        l = keyboard.nextLine();
        for (AddUser u: list) {
            if (l.equals(u.nome)) {
                System.out.println("Digite seu novo nome:");
                l = keyboard.nextLine();
                u.nome = l;
            }
        }
        
        System.out.println("Qual seu login?");
        l = keyboard.nextLine();
        for (AddUser u: list) {
            if (l.equals(u.login)) {
                System.out.println("Digite seu novo login:");
                l = keyboard.nextLine();
                u.login = l;
            }
        }

        System.out.println("Qual a sua senha");
        l = keyboard.nextLine();
        for (AddUser u: list) {
            if (l.equals(u.senha)) {
                System.out.println("Digite sua nova senha:");
                l = keyboard.nextLine();
                u.senha = l;
            }
        }
    }

    public void status() {
        System.out.println("========STATUS========");
        System.out.println("Nome: " + getNome());
        System.out.println("Login: " + getLogin());
        System.out.println("Senha: " + getSenha());
        System.out.println();
    }

    //getters
    public String getNome() {
        return this.name;
    }
    public String getSenha() {
        return this.pass;
    }
    public String getLogin() {
        return this.login;
    }
    //setters
    public void setNome(String n) {
        this.name = n;
    }
    public void setLogin(String l) {
        this.login = l;
    }
    public void setSenha(String s) {
        this.pass = s;
    }
}