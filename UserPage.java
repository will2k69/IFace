import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class UserPage extends MainPageIface{    
    private Scanner keyboard = new Scanner(System.in);
    private String opcao;
    private Relationship relation = new Relationship();

    
    public boolean isUser(String login, String senha) {
        if (this.usersList.get(login) != null) {
            if (this.usersList.get(login).getPass().equals(senha))
                return true;
        }
        return false;
    }

    public void createUser() {
        System.out.println("Digite seu nome:");
        String pegaNome = keyboard.nextLine();
        while (true) {
            System.out.println("Digite seu login:");
            String pegaLogin = keyboard.nextLine();
            if (this.usersList.get(pegaLogin) != null) {
                System.out.println("\n=========================================");
                System.out.println("ERRO: Login já existente! Tente novamente\n");
                System.out.println("=========================================\n");
            }
            else {
                System.out.println("Digite sua senha:");
                String pegaSenha = keyboard.nextLine();
                this.usersList.put(pegaLogin, new UserIface(pegaNome, pegaLogin, pegaSenha));
                break;
            }
        }

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Usuário cadastrado com sucesso!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    public void inicio(String login, String senha) throws IOException, InterruptedException {
        while (true) {
            System.out.printf("\nDigite uma opção:\n1---->ACESSAR FEED\n2---->COMUNIDADES\n3---->ENVIAR MENSAGEM\n4---->SOLICITAR AMIZADE\n5---->VISUALIZAR SOLICITAÇÕES DE AMIZADES\n6---->LISTA DE AMIGOS\n7---->INFORMAÇÕES DA CONTA\n8---->MODIFICAR DADOS DE USUÁRIO\n\n9---->EXCLUIR CONTA IF@ce\n0---->SAIR\n99 - Mostrar usuários\n");
            opcao = keyboard.nextLine();
            
            if (opcao.equals("0")) {
                System.out.println("\n");
                break;
            }

            else if (opcao.equals("1")) {
                System.out.println("\n1 - Acessar meu feed\n2 - Buscar feed");
                opcao = keyboard.nextLine();
                if (opcao.equals("1"))
                    relation.sendMessageMyFeed(login, this.usersList);
                else if (opcao.equals("2")) {
                    System.out.println("Pesquisar login: ");
                    String loginDestiny = keyboard.nextLine();
                    
                    if (usersList.get(loginDestiny) != null)
                        relation.sendMessageFeed(login, loginDestiny, this.usersList);
                    else {
                        System.out.println("\n=========================================");
                        System.out.println("    Usuário não encontrado");
                        System.out.println("=========================================\n");
                    }
                }
            }

            else if (opcao.equals("2")) {
                System.out.println("\n1 - Ver comunidades\n2 - Participar de uma comunidade\n3 - Criar comunidade");
                opcao = keyboard.nextLine();
                if (opcao.equals("1")) {
                    if (!this.usersList.get(login).myCommunitys.isEmpty()) {
                        System.out.println("===============COMUNIDADES===============");
                        System.out.println("Número - Nome da comunidade");
                        for (int i=0; i < this.usersList.get(login).myCommunitys.size(); i++)
                            System.out.println(i + " - " + this.usersList.get(login).myCommunitys.get(i));
                        System.out.println("=========================================");
                        System.out.println("\nDigite o número da comunidade: ");
                    }
                    else {
                        System.out.println("\n=========================================");
                        System.out.println("ERROR: User don't pertence there's a community\n");
                        System.out.println("=========================================\n");
                        continue;
                    }
                    opcao = keyboard.nextLine();
                    int iAux = Integer.parseInt(opcao);
                    String nomeDaComuna = this.usersList.get(login).myCommunitys.get(iAux);
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
                    if (this.communitys.get(nameCommunity) != null) {
                        this.communitys.get(nameCommunity).addMember(this.usersList.get(login));
                    }
                }
                else if (opcao.equals("3")) {
                    System.out.println("Digite o nome e descrição da comunidade:");
                    String n = keyboard.nextLine();
                    if (this.communitys.get(n) != null) {
                        System.out.println("\n=========================================");
                        System.out.println("ERROR: Community already existent\n");
                        System.out.println("=========================================\n");
                        continue;
                    }
                    String d = keyboard.nextLine();
                    //Community novaComuna = new Community(n, login, d);
                    this.communitys.put(n, new Community(n, login, d));
                    this.usersList.get(login).myCommunitys.add(n);
                    System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Comunidade criada com sucesso! ^_^ ^_^");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                }
            }

            else if (opcao.equals("3")) {
                System.out.println("Pesquisar login: ");
                String loginDestiny = keyboard.nextLine();
                if (this.usersList.get(loginDestiny) != null)
                    relation.sendMessage(login, loginDestiny, this.usersList);
                else {
                    System.out.println("\n=========================================");
                    System.out.println("ERRO: User not found");
                    System.out.println("=========================================\n");
                }
            }

            else if (opcao.equals("4")) {
                System.out.print("\nDigite o login de seu amigo: ");
                String amg = keyboard.nextLine();
                boolean nice=true, isUser=false;
                
                if (this.usersList.get(amg) != null) {//verificar se o amigo é um usuário cadastrado no IFace
                    isUser=true;
                    for (UserIface uFriend: this.usersList.get(login).friends) {
                        if (uFriend.getLogin().equals(amg)) {
                            System.out.println("Usuário " + "'" + amg + "'" + " já pertence a sua lista de amigos!");
                            nice=false;
                            break;
                        }
                    }
                    if (nice)
                        relation.solicitarAmizade(login, amg, this.usersList);
                }

                if (!isUser)
                    System.out.println("ERROR 404: Not Found");
            }

            else if (opcao.equals("5"))
                relation.solicitacoes(login, usersList);
            
            else if (opcao.equals("6"))
                this.usersList.get(login).listarAmigos();
        
            else if (opcao.equals("7"))
                this.usersList.get(login).status();

            else if (opcao.equals("8")) {
                while (true) {
                    System.out.println("\nO que deseja alterar?");
                    System.out.print("1 - Nome\n2 - Login\n3 - Senha\n0 - VOLTAR\nDigite aqui: ");
                    opcao = keyboard.nextLine();
                    
                    if (opcao.equals("0"))
                        break;

                    if (opcao.equals("1")) {
                        System.out.print("Digite seu novo nome: ");
                        while (true) {
                            boolean nice=true;
                            String n = keyboard.nextLine();
                            for (UserIface uIface: this.usersList.values()) {
                                if (uIface.getName().equals(n)) {
                                    System.out.println("\n=========================================");
                                    System.out.println("ERROR: Username already existing! Try again.");
                                    System.out.println("=========================================\n");
                                    nice = false;
                                    break;
                                }
                            }
                            if (nice) {
                                this.usersList.get(login).setName(n);
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
                            if (this.usersList.get(l) != null) {
                                System.out.println("\n=========================================");
                                System.out.println("ERROR: Login already existing! Try again.");
                                System.out.println("=========================================\n");
                                nice = false;
                            }

                            if (nice) {
                                this.usersList.get(login).setLogin(l);
                                this.usersList.put(l, this.usersList.get(login));
                                this.usersList.remove(login);
                                login = l;
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
                            if (this.usersList.get(login).getPass().equals(s)) {
                                System.out.println("\n=========================================");
                                System.out.println("ERROR: Password already existing! Try again.");
                                System.out.println("=========================================\n");
                                nice = false;
                            }
                            
                            if (nice) {
                                this.usersList.get(login).setPass(s);
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
                    trash.put(l, this.usersList.get(login));
                    this.usersList.remove(login);
                    System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.printf("Usúario '%s' removido com sucesso!\n", l);
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                    break;
                }
            }

            else if (opcao.equals("99")) {
                System.out.println("========LISTA DE USUÁRIOS========");
                for (String key: this.usersList.keySet()) {
                    System.out.printf("Nome: %s\nLogin: %s\nSenha: %s\n", this.usersList.get(key).getName(), this.usersList.get(key).getLogin(), this.usersList.get(key).getPass());
                    System.out.println();
                }
            }

            System.out.println("Tecle ENTER para sair: ");
            keyboard.nextLine();
            clear();
        }
    }
}