public class InfoAccount extends ItensForMenu implements Command{
    
    public InfoAccount(String log) {
        this.login = log;
    }

    @Override
    public void execute(ItensForMenu ifm) {
        ifm.usersList.get(this.login).status();
    }
}