import java.util.ArrayList;

public class RemoteControl {
    ArrayList<ItensForMenu> listCommands = new ArrayList<>();
    int iCommand;

    public RemoteControl(int index, String login) {
        this.iCommand = index;
        this.addListCommands(new AcessFeed(login));
        this.addListCommands(new AcessCommunity(login));
        this.addListCommands(new SendMessage(login));
        this.addListCommands(new SendFriendship(login));
        this.addListCommands(new ViewFriendRequest(login));
        this.addListCommands(new ToListFriends(login));
        this.addListCommands(new InfoAccount(login));
        this.addListCommands(new ModifyAccount(login));
        this.addListCommands(new DeleteAccount(login));
    }

    public void addListCommands(ItensForMenu command) {
        this.listCommands.add(command);
    }

    public void run(ItensForMenu ifm) {
        this.listCommands.get(iCommand).execute(ifm);
    }
}