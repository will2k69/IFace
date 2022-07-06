public class AcessCommunity extends ItensForMenu implements Command {

    public AcessCommunity(String log) {
        this.login = log;
    }

    @Override
    public void execute(ItensForMenu ifm) {
        System.out.println("\n1 - Ver comunidades\n2 - Participar de uma comunidade\n3 - Criar comunidade");
        String opcao = keyboard.nextLine();
        if (opcao.equals("1")) {
            if (!ifm.usersList.get(this.login).myCommunitys.isEmpty()) {
                System.out.println("===============COMUNIDADES===============");
                System.out.println("Número - Nome da comunidade");
                for (int i=0; i < ifm.usersList.get(this.login).myCommunitys.size(); i++)
                    System.out.println(i + " - " + ifm.usersList.get(login).myCommunitys.get(i));
                System.out.println("=========================================");
                System.out.println("\nDigite o número da comunidade: ");
            }
            else {
                System.out.println("\n=========================================");
                System.out.println("ERROR: User don't pertence there's a community\n");
                System.out.println("=========================================\n");
                return;
            }
            try {
                opcao = keyboard.nextLine();
                int iAux = Integer.parseInt(opcao);
                String nomeDaComuna = ifm.usersList.get(this.login).myCommunitys.get(iAux);
                ifm.communitys.get(nomeDaComuna).viewMessages();
            
                System.out.println("\nEnvie ':q' para sair do chat\n");
                this.chatMessage(nomeDaComuna, ifm.communitys);
            } catch(IndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("\nDigito inválido.");
                return;
            }
        }
        else if (opcao.equals("2")) {
            try {
                System.out.println("Digite o nome da comunidade: ");
                String nameCommunity = keyboard.nextLine();
                ifm.communitys.get(nameCommunity).addMember(ifm.usersList.get(this.login));
            } catch (NullPointerException npe) {
                System.out.println("Comunidade inexistente!");
            }
        }
        else if (opcao.equals("3")) {
            System.out.println("Digite o nome e descrição da comunidade:");
            String n = keyboard.nextLine();
            if (ifm.communitys.get(n) != null) {
                System.out.println("\n=========================================");
                System.out.println("ERROR: Community already existent");
                System.out.println("=========================================\n");
                return;
            }
            String d = keyboard.nextLine();
            ifm.communitys.put(n, new Comunidades(n, this.login, d));
            ifm.usersList.get(login).myCommunitys.add(n);
            System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Comunidade criada com sucesso! ^_^ ^_^");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        }
    }
}