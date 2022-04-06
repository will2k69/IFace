import java.util.Scanner;

public class UserPage extends MainPageIface{    
    private Scanner keyboard = new Scanner(System.in);
    private String opcao;
    //private Relationship relation = new Relationship();


    public boolean isUser(String login, String senha) {
        if (usersList.get(login) != null) {
            if (usersList.get(login).getPass().equals(senha)) {
                return true;
            }
        }
        return false;
        /*for (UserIface u: this.usersList) {
            if (u.getLogin().equals(login) && u.getPass().equals(senha)) {
                this.idUser = u.getId();
                return true;
            }
        }
        return false;*/
    }

    public void createUser() {//falta implementar verificação, se já existe nome, login e senha
        System.out.println("Digite seu nome, login e senha:");
        String pegaNome = keyboard.nextLine();
        String pegaLogin = keyboard.nextLine();
        String pegaSenha = keyboard.nextLine();
        
        System.out.println("\n");
        usersList.put(pegaLogin, new UserIface(pegaNome, pegaLogin, pegaSenha));
        //usersList.get(usersList.size() - 1).setId(usersList.size() - 1);
    }

    public void inicio(String login, String senha) {

        while (true) {
            System.out.printf("\n\nDigite uma opção:\n1 - Modificar dados de usuário\n2 - Informações da conta\n3 - Solicitar amizade\n4 - Ver solicitações de amizades\n5 - Ver lista de amigos\n6 - Enviar mensagem\n7 - Excluir conta\n8 - Acessar feed\n99 - Mostrar usuários\n0 - SAIR\n");
            opcao = keyboard.nextLine();
            
            if (opcao.equals("0")) {
                System.out.println("\n");
                break;
            }

            else if (opcao.equals("1")) {
                while (true) {
                    System.out.println("\n\nO que deseja alterar?");
                    System.out.print("1 - Nome\n2 - Login\n3 - Senha\n0 - VOLTAR\nDigite aqui: ");
                    opcao = keyboard.nextLine();
                    
                    if (opcao.equals("0"))
                        break;

                    if (opcao.equals("1")) {
                        System.out.print("Digite seu novo nome: ");
                        while (true) {
                            boolean nice=true;
                            String n = keyboard.nextLine();
                            for (UserIface uIface: usersList.values()) {
                                if (uIface.getName().equals(n)) {
                                    System.out.println("Nome de usuário já existente! Tente outro.");
                                    nice = false;
                                    break;
                                }
                            }
                            if (nice) {
                                usersList.get(login).setName(n);
                                System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.println(" Nome de usuário alterado com sucesso!");
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                                break;
                            }
                        }
                    }

                    if (opcao.equals("2")) {
                        System.out.print("Digite seu novo login: ");
                        while (true) {
                            boolean nice=true;
                            String l = keyboard.nextLine();
                            if (usersList.get(l) != null) {
                                System.out.println("Login já existente! Tente outro.");
                                nice = false;
                            }
                            /*for (UserIface uIface: usersList) {
                                if (uIface.getLogin().equals(n)) {
                                    System.out.println("Login já existente! Tente outro.");
                                    nice = false;
                                    break;
                                }
                            }*/
                            if (nice) {
                                usersList.get(login).setLogin(l);
                                System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.println("     Login alterado com sucesso!");
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                                break;
                            }
                        }
                    }

                    if (opcao.equals("3")) {
                        System.out.print("Digite sua nova senha: ");
                        while (true) {
                            boolean nice=true;
                            String s = keyboard.nextLine();
                            if (usersList.get(login).getPass().equals(s)) {
                                System.out.println("Senha já existente! Tente outra.");
                                nice = false;
                            }
                            /*
                            for (UserIface uIface: usersList) {
                                if (uIface.getPass().equals(n)) {
                                    System.out.println("Senha já existente! Tente outra.");
                                    nice = false;
                                    break;
                                }
                            }*/
                            if (nice) {
                                usersList.get(login).setPass(s);
                                System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.println("     Senha alterada com sucesso!");
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                                break;
                            }
                        }
                    }
                }
            }

            else if (opcao.equals("2"))
                usersList.get(login).status();

            else if (opcao.equals("3")) {
                System.out.print("\n\nDigite o login de seu amigo: ");
                String amg = keyboard.nextLine();
                boolean nice=true, isUser=false;
                
                if (usersList.get(amg) != null) {//verificar se o amigo é um usuário cadastrado no IFace
                    isUser=true;
                    for (UserIface uFI: usersList.get(login).friends) {
                        if (uFI.getLogin().equals(amg)) {
                            System.out.println("Usuário " + "'" + amg + "'" + " já pertence a sua lista de amigos!");
                            nice=false;
                            break;
                        }
                    }
                    if (nice) {//pedido de amizade para o id do usuario 'u'(o amigo)
                        Relationship relation = new Relationship();    
                        relation.solicitarAmizade(login, amg, usersList);
                    }
                }

                /*for (UserIface u: usersList) {//verificar se o amigo é um usuário cadastrado no IFace
                    if (u.getLogin().equals(amg)) {
                        isUser=true;
                        for (UserIface uFI: usersList.get(idUser).friends) {
                            if (uFI.getLogin().equals(amg)) {
                                System.out.println("Usuário " + amg + " já pertence a sua lista de amigos!");
                                nice=false;
                                break;
                            }
                        }
                        if (nice)//pedido de amizade para o id do usuario 'u'(o amigo)
                            relation.solicitarAmizade(idUser, u.getId(), usersList);
                        break;
                    }
                }*/
                if (!isUser)
                    System.out.println("ERROR 404: Not Found");
            }

            else if (opcao.equals("4")) {
                Relationship relation = new Relationship();
                relation.solicitacoes(login, usersList);
            }
            else if (opcao.equals("5"))
                usersList.get(login).listarAmigos();

            else if (opcao.equals("6")) {
                System.out.println("Pesquisar login: ");
                String l = keyboard.nextLine();
                //AQUI EH NECESSARIO VERIFICAÇÃO
                if (usersList.get(l) != null) {

                }
                /*int i=-1;
                for (UserIface u: usersList) {
                    if (u.getLogin().equals(l)) {
                        i = u.getId();
                        break;
                    }
                }*/
                Relationship relation = new Relationship();
                relation.sendMessage(login, l, usersList);
            }

            else if (opcao.equals("7")) {
                System.out.print("\nTem certeza que deseja excluir sua conta?\n(Você pode recuperar seus dados posteriormente)\n1 - Sim\n2 - Não\nDigite aqui: ");
                opcao = keyboard.nextLine();
                if (opcao.equals("1")) {
                    String l = login;
                    trash.put(l, usersList.get(login));
                    usersList.remove(login);
                    System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.printf("Usúario '%s' removido com sucesso!\n", l);
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                    break;
                }
            }
            
            else if (opcao.equals("8")) {
                System.out.println("\n1 - Acessar meu feed\n2 - Buscar feed");
                opcao = keyboard.nextLine();
                if (opcao.equals("1")) {
                    Relationship relation = new Relationship();
                    relation.sendMessageMyFeed(login, usersList);
                }
                else if (opcao.equals("2")) {
                    System.out.println("Pesquisar login: ");
                    String l = keyboard.nextLine();
                    /*int iDestiny=-1;
                    for (UserIface u: usersList) {
                        if (u.getLogin().equals(l)) {
                            iDestiny = u.getId();
                            break;
                        }
                    }*/
                    if (usersList.get(l) != null) {
                        Relationship relation = new Relationship();
                        relation.sendMessageFeed(login, l, usersList);
                    }
                    else
                        System.out.println("\n\nUsuário não encontrado!");
                }
            }

            else if (opcao.equals("99")) {
                System.out.println("========LISTA DE USUÁRIOS========");
                for (String key: usersList.keySet()) {
                    System.out.printf("Nome: %s\nLogin: %s\nSenha: %s\n", usersList.get(key).getName(), usersList.get(key).getLogin(), usersList.get(key).getPass());
                    System.out.println();
                }
                System.out.println("====================================\n");
            }
        }
    }
}