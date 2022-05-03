import java.util.HashMap;

public interface Relationship {
    public abstract void solicitarAmizade(String user, String friend, HashMap<String, UserIface> list);
    public abstract void solicitacoes(String loginUser, HashMap<String, UserIface> list);
    public abstract void sendMessage(String loginUser, String loginDestiny, HashMap<String, UserIface> list);
    public abstract void sendMessageMyFeed(String loginUser, HashMap<String, UserIface> list);
    public abstract void sendMessageFeed(String loginUser, String loginDestiny, HashMap<String, UserIface> list);
}