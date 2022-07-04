public class AcessFeed extends ItensForMenu implements Command {
    Relacionamentos relation = new Relacionamentos();

    public AcessFeed(String log) {
        this.login = log;
    }

    @Override//polimorfismo ai que lindo :D
    public void execute(ItensForMenu ifm) {
        System.out.println("\n1 - Acessar meu feed\n2 - Buscar feed");
        String opcao = keyboard.nextLine();
        if (opcao.equals("1"))
            relation.sendMessageMyFeed(this.login, ifm.usersList);
        else if (opcao.equals("2")) {
            System.out.println("Pesquisar login: ");
            String loginDestiny = keyboard.nextLine();
            
            try {
                UserIface u = ifm.usersList.get(loginDestiny);    
                relation.sendMessageFeed(this.login, loginDestiny, ifm.usersList);
                u.getName();
            } catch (NullPointerException npe) {
                System.out.println("\n=========================================");
                System.out.println("    Usuário não encontrado :/");
                System.out.println("=========================================\n");
            }
        }
    }
}