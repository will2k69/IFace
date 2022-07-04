public class ToListFriends extends ItensForMenu implements Command{
    
    public ToListFriends(String log) {
        this.login = log;
    }

    @Override
    public void execute(ItensForMenu ifm) {
        ifm.usersList.get(this.login).listarAmigos();
    }
}