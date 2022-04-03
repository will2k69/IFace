import java.util.Scanner;

public class UserPage extends MainPageIface{
    
    private Scanner keyboard = new Scanner(System.in);
    private int opcao, idUser;
    private Relationship relation = new Relationship();


    public boolean isUser(String login, String senha) {
        for (UserIface u: this.usersList) {
            if (u.getLogin().equals(login) && u.getPass().equals(senha)) {
                this.idUser = u.getId();
                return true;
            }
        }
        return false;
    }

    public void createUser() {//falta implementar verificação, se já existe nome, login e senha
        System.out.println("Digite seu nome, login e senha:");
        String pegaNome = keyboard.next();
        String pegaLogin = keyboard.next();
        String pegaSenha = keyboard.next();
        System.out.println("\n");
        usersList.add(new UserIface(pegaNome, pegaLogin, pegaSenha));
        usersList.get(usersList.size() - 1).setId(usersList.size() - 1);
    }

    public void inicio(String login, String senha) {

        while (true) {
            System.out.printf("\n\nDigite uma opção:\n1 - Modificar dados de usuário\n2 - Informações da conta\n3 - Solicitar amizade\n4 - Ver solicitações de amizades\n5 - Ver lista de amigos\n6 - Enviar mensagem\n7 - Excluir conta\n99 - Mostrar usuários\n0 - SAIR\n");
            opcao = keyboard.nextInt();
            
            if (opcao == 0) {
                System.out.println("\n");
                break;
            }

            else if (opcao == 1) {
                while (true) {
                    System.out.println("\n\nO que deseja alterar?");
                    System.out.print("1 - Nome\n2 - Login\n3 - Senha\n0 - VOLTAR\nDigite aqui: ");
                    opcao = keyboard.nextInt();
                    
                    if (opcao == 0)
                        break;

                    if (opcao == 1) {
                        System.out.print("Digite seu novo nome: ");
                        while (true) {
                            boolean nice=true;
                            String n = keyboard.next();
                            for (UserIface uIface: usersList) {
                                if (uIface.getName().equals(n)) {
                                    System.out.println("Nome de usuário já existente! Tente outro.");
                                    nice = false;
                                    break;
                                }
                            }
                            if (nice) {
                                usersList.get(idUser).setName(n);
                                System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.println(" Nome de usuário alterado com sucesso!");
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                                break;
                            }
                        }
                    }

                    if (opcao == 2) {
                        System.out.print("Digite seu novo login: ");
                        while (true) {
                            boolean nice=true;
                            String n = keyboard.next();
                            for (UserIface uIface: usersList) {
                                if (uIface.getLogin().equals(n)) {
                                    System.out.println("Login já existente! Tente outro.");
                                    nice = false;
                                    break;
                                }
                            }
                            if (nice) {
                                usersList.get(idUser).setLogin(n);
                                System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.println("     Login alterado com sucesso!");
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                                break;
                            }
                        }
                    }

                    if (opcao == 3) {
                        System.out.print("Digite sua nova senha: ");
                        while (true) {
                            boolean nice=true;
                            String n = keyboard.next();
                            for (UserIface uIface: usersList) {
                                if (uIface.getPass().equals(n)) {
                                    System.out.println("Senha já existente! Tente outra.");
                                    nice = false;
                                    break;
                                }
                            }
                            if (nice) {
                                usersList.get(idUser).setPass(n);
                                System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.println("     Senha alterada com sucesso!");
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                                break;
                            }
                        }
                    }
                }
            }

            else if (opcao == 2)
                usersList.get(idUser).status();

            else if (opcao == 3) {
                System.out.print("\n\nDigite o login de seu amigo: ");
                String amg = keyboard.next();
                boolean nice=true, isUser=false;
                for (UserIface u: usersList) {//verificar se o amigo é um usuário cadastrado no IFace
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
                }
                if (!isUser)
                    System.out.println("ERROR 404: Not Found");
            }

            else if (opcao == 4)
                relation.solicitacoes(idUser, usersList);

            else if (opcao == 5)
                usersList.get(idUser).listarAmigos();

            else if (opcao == 6) {

            }

            else if (opcao == 7) {
                System.out.print("\nTem certeza que deseja excluir sua conta?\n(Todos os seus dados serão excluidos permanentemente)\n1 - Sim\n2 - Não\nDigite: ");
                opcao = keyboard.nextInt();
                if (opcao == 1) {
                    String n = usersList.get(idUser).getName();
                    usersList.remove(idUser);
                    System.out.printf("\n\nUsúario %s removido com sucesso!\n", n);
                }
            }
            
            else if (opcao == 99) {
                System.out.println("========LISTA DE USUÁRIOS========");
                for (int i=0; i < usersList.size() ; i++) {
                    System.out.printf("Nome: %s\nLogin: %s\nSenha: %s\n", usersList.get(i).getName(), usersList.get(i).getLogin(), usersList.get(i).getPass());
                    System.out.println();
                }
                System.out.println("====================================\n");
            }
        }
    }
}