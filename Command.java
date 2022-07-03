import java.util.HashMap;

public interface Command {
    public void execute(HashMap<String, UserIface> list);
}
