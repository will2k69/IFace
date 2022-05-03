public interface Community {
    public abstract void viewMessages();
    public abstract void sendAMessage(String msg);
    public abstract void addMember(UserIface user);
}