import java.util.ArrayList;
import java.util.HashMap;

public class RemoteControl {
    ArrayList<MainPageIface> listCommands = new ArrayList<>();
    int iCommand;

    public RemoteControl(int index, String login) {
        this.iCommand = index;
        this.setListCommands(new AcessFeed(login));
    }

    public void setListCommands(MainPageIface command) {
        this.listCommands.add(command);
    }

    public void run(HashMap<String, UserIface> list) {
        this.listCommands.get(iCommand).execute(list);
    }

}
