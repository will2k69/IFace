public class SendFriendship extends ItensForMenu implements Command {
    Relacionamentos relation = new Relacionamentos();

    public SendFriendship(String log) {
        this.login = log;
    }

    @Override
    public void execute(ItensForMenu ifm) {
        System.out.print("\nDigite o login de seu amigo: ");
        String amg = keyboard.nextLine();
        boolean nice=true;
        
        if (amg.equals(this.login)) {
            System.out.println("\n=========================================");
            System.out.println("ERROR: THIS ARE YOU! TRY ANOTHER LOGIN :/");
            System.out.println("=========================================\n");
            return;
        }

        try {//verificar se o amigo é um usuário cadastrado no IFace
            ifm.usersList.get(amg);

            for (UserIface uFriend: ifm.usersList.get(this.login).friends) {
                if (uFriend.getLogin().equals(amg)) {
                    System.out.println("Usuário " + "'" + amg + "'" + " já pertence a sua lista de amigos!");
                    nice=false;
                    break;
                }
            }
            if (nice)
                relation.solicitarAmizade(this.login, amg, ifm.usersList);
        } catch (NullPointerException npe) {
            System.out.println("\nERROR 404: Not Found\n");
        }
    }
}