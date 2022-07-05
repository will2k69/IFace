public class DeleteAccount extends ItensForMenu implements Command{
    
    public DeleteAccount(String log) {
        this.login = log;
    }

    @Override
    public void execute(ItensForMenu ifm) {
        System.out.print("\nTem certeza que deseja excluir sua conta?\n(Você pode recuperar seus dados posteriormente)\n1 - Sim\n2 - Não\nDigite aqui: ");
        String opcao = keyboard.nextLine();
        
        if (opcao.equals("1")) {
            String l = this.login;
            ifm.trash.put(l, ifm.usersList.get(this.login));
            ifm.usersList.remove(this.login);
            System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.printf("Usúario '%s' removido com sucesso!\n", l);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        }
    }
}