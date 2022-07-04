public class SendMessage extends ItensForMenu implements Command {
    Relacionamentos relation = new Relacionamentos();

    public SendMessage(String log) {
        this.login = log;
    }

    @Override
    public void execute(ItensForMenu ifm) {
        System.out.println("Pesquisar login: ");
        String loginDestiny = keyboard.nextLine();
        
        try {
            ifm.usersList.get(loginDestiny);
            relation.sendMessage(this.login, loginDestiny, ifm.usersList);
        } catch (NullPointerException npe) {
            System.out.println("\n=========================================");
            System.out.println("ERROR: User not found");
            System.out.println("=========================================\n");
        }
    }
}