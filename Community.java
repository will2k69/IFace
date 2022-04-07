import java.util.ArrayList;
import java.util.HashMap;

public class Community {
    private String name, description, host;
    private ArrayList<String> messages = new ArrayList<String>();
    private HashMap<String, UserIface> members = new HashMap<String, UserIface>();//key=login | value=membros pertencentes a comunidade
    
    
    public Community(String name, String host, String desString) {
        setName(name);
        setHost(host);
        setDescription(desString);
    }

    public void viewMessages() {
        for (String frase: this.messages)
            System.out.println(frase);
    }

    public void sendAMessage(String msg) {
        this.messages.add(msg);
    }

    public void addMember(UserIface user) {
        if (this.members.get(user.getLogin()) == null) {
            this.members.put(user.getLogin(), user);
            user.myCommunitys.add(this.name);
            System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Usuário " + "'" + user.getLogin() + "'" + " adicionado com sucesso!");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        }
        else
            System.out.println("\n\nUsuário " + "'" + user.getLogin() + "'" + " já pertence a comunidade!\n");
    }

    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
}