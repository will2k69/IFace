import java.io.*;
import java.util.Scanner;

public class UserPage {
    private LimpaTela limpador = new LimpaTela();
    private Scanner keyboard = new Scanner(System.in);
    protected ItensForMenu ifm = new ItensForMenu();
    
    public void isUser(String login, String senha) {
        UserIface u = this.ifm.usersList.get(login);
        u.getName();
    }

    public void createUser() {
        System.out.println("Digite seu nome:");
        String pegaNome = keyboard.nextLine();
        while (true) {
            System.out.println("Digite seu login:");
            String pegaLogin = keyboard.nextLine();
            if (this.ifm.usersList.get(pegaLogin) != null) {
                System.out.println("\n=========================================");
                System.out.println("ERRO: Login já existente! Tente novamente\n");
                System.out.println("=========================================\n");
            }
            else {
                System.out.println("Digite sua senha:");
                String pegaSenha = keyboard.nextLine();
                this.ifm.usersList.put(pegaLogin, new UserIface(pegaNome, pegaLogin, pegaSenha));
                break;
            }
        }

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Usuário cadastrado com sucesso!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    public void inicio(String login, String senha) throws IOException, InterruptedException {
        while (true) {
            try {
                System.out.println("Bem-vind@, " + login + "!");
                System.out.printf("\nDigite uma opção:\n1---->ACESSAR FEED\n2---->COMUNIDADES\n3---->ENVIAR MENSAGEM\n4---->SOLICITAR AMIZADE\n5---->VISUALIZAR SOLICITAÇÕES DE AMIZADES\n6---->LISTA DE AMIGOS\n7---->INFORMAÇÕES DA CONTA\n8---->MODIFICAR DADOS DE USUÁRIO\n\n9---->EXCLUIR CONTA IF@ce\n0---->SAIR\n");
                
                String opcao = keyboard.nextLine();
                if (opcao.equals("0")) {
                    System.out.println("\n");
                    break;
                }

                RemoteControl remoteControl = new RemoteControl(Integer.parseInt(opcao) - 1 , login);
                limpador.clear();
                remoteControl.run(this.ifm);
            } catch (IndexOutOfBoundsException | NumberFormatException iobnfe) {
                System.out.println("\nOpção inválida!\nTente novamente.\n");
            }

            System.out.println("Tecle ENTER para sair: ");
            keyboard.nextLine();
            limpador.clear();
        }
    }
}