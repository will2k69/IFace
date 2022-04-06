import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class UserPage extends MainPageIface{    
    private Scanner keyboard = new Scanner(System.in);
    private String opcao;


    public boolean isUser(String login, String senha) {
        if (usersList.get(login) != null) {
            if (usersList.get(login).getPass().equals(senha))
                return true;
        }
        return false;
    }

    public void createUser() {//falta implementar verificação, se já existe nome, login e senha
        System.out.println("Digite seu nome, login e senha:");
        String pegaNome = keyboard.nextLine();
        String pegaLogin = keyboard.nextLine();
        String pegaSenha = keyboard.nextLine();
        
        System.out.println("\n");
        usersList.put(pegaLogin, new UserIface(pegaNome, pegaLogin, pegaSenha));
    }

    public void inicio(String login, String senha) throws IOException, InterruptedException {

        while (true) {
            System.out.printf("\n\nDigite uma opção:\n1 - ACESSAR FEED\n2 - COMUNIDADES\n3 - ENVIAR MENSAGEM\n4 - SOLICITAR AMIZADE\n5 - VISUALIZAR SOLICITAÇÕES DE AMIZADES\n6 - LISTA DE AMIGOS\n7 - INFORMAÇÕES DA CONTA\n8 - MODIFICAR DADOS DE USUÁRIO\n\n9 - EXCLUIR CONTA IF@ce\n0 - SAIR\n99 - Mostrar usuários\n");
            opcao = keyboard.nextLine();
            
            if (opcao.equals("0")) {
                System.out.println("\n");
                break;
            }

            else if (opcao.equals("1")) {
                System.out.println("\n1 - Acessar meu feed\n2 - Buscar feed");
                opcao = keyboard.nextLine();
                if (opcao.equals("1")) {
                    Relationship relation = new Relationship();
                    relation.sendMessageMyFeed(login, usersList);
                }
                else if (opcao.equals("2")) {
                    System.out.println("Pesquisar login: ");
                    String l = keyboard.nextLine();
                    
                    if (usersList.get(l) != null) {
                        Relationship relation = new Relationship();
                        relation.sendMessageFeed(login, l, usersList);
                    }
                    else
                        System.out.println("\n\nUsuário não encontrado!");
                }
            }

            else if (opcao.equals("2")) {
                System.out.println("\n1 - Ver comunidades\n2 - Participar de uma comunidade\n3 - Criar comunidade");
                opcao = keyboard.nextLine();
                if (opcao.equals("1")) {
                    if (usersList.get(login).communitys.size() != 0) {
                        System.out.println("===============COMUNIDADES===============");
                        for (int i=0; i < usersList.get(login).communitys.size(); i++)
                            System.out.println(i + " - " + usersList.get(login).communitys.get(i));
                        System.out.println("=========================================");
                        System.out.println("\nDigite o número da comunidade: ");
                    }
                    else {
                        System.out.println("\nUsuário não pertence a alguma comunidade!\n");
                        continue;
                    }
                    opcao = keyboard.nextLine();
                    int iAux = Integer.parseInt(opcao);
                    String nomeDaComuna = usersList.get(login).communitys.get(iAux);
                    this.communitys.get(nomeDaComuna).viewMessages();
                    
                    System.out.println("\nEnvie ':q' para sair do chat\n");
                    while (true) {
                        String msg = keyboard.nextLine();
                        if (msg.equals(":q"))
                            break;
                        String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());
                        msg = "[" + timeStamp + "] " + login + ": " + msg;
                        communitys.get(nomeDaComuna).sendAMessage(msg);
                    }
                }
                else if (opcao.equals("2")) {
                    System.out.println("Digite o nome da comunidade: ");
                    String nameCommunity = keyboard.nextLine();
                    if (communitys.get(nameCommunity) != null) {
                        communitys.get(nameCommunity).addMember(usersList.get(login));
                    }
                }
                else if (opcao.equals("3")) {
                    System.out.println("Digite o nome e descrição da comunidade:");
                    String n = keyboard.nextLine();
                    if (communitys.get(n) != null) {
                        System.out.println("\nComunidade já existente!");
                        continue;
                    }
                    String d = keyboard.nextLine();
                    Community novaComuna = new Community(n, login, d);
                    communitys.put(n, novaComuna);
                    usersList.get(login).communitys.add(n);
                    System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Comunidade criada com sucesso!");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                }
            }

            else if (opcao.equals("3")) {
                System.out.println("Pesquisar login: ");
                String l = keyboard.nextLine();
                //AQUI EH NECESSARIO VERIFICAÇÃO
                if (usersList.get(l) != null) {

                }
                
                Relationship relation = new Relationship();
                relation.sendMessage(login, l, usersList);
            }

            else if (opcao.equals("4")) {
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

                if (!isUser)
                    System.out.println("ERROR 404: Not Found");
            }

            else if (opcao.equals("5")) {
                Relationship relation = new Relationship();
                relation.solicitacoes(login, usersList);
            }
            else if (opcao.equals("6"))
                usersList.get(login).listarAmigos();

            else if (opcao.equals("7"))
                usersList.get(login).status();

            else if (opcao.equals("8")) {
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

            else if (opcao.equals("9")) {
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

            else if (opcao.equals("99")) {
                System.out.println("========LISTA DE USUÁRIOS========");
                for (String key: usersList.keySet()) {
                    System.out.printf("Nome: %s\nLogin: %s\nSenha: %s\n", usersList.get(key).getName(), usersList.get(key).getLogin(), usersList.get(key).getPass());
                    System.out.println();
                }
            }

            System.out.println("Tecle ENTER para sair: ");
            String o = keyboard.nextLine();
            clear();
        }
    }
}