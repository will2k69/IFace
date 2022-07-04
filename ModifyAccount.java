public class ModifyAccount extends ItensForMenu implements Command{
    
    public ModifyAccount(String log) {
        this.login = log;
    }

    @Override
    public void execute(ItensForMenu ifm) {
        while (true) {
            System.out.println("\nO que deseja alterar?");
            System.out.print("1 - Nome\n2 - Login\n3 - Senha\n4 - Número de celular (1)\n5 - Número de celular (2)\n6 - Endereço\n7 - Data de nascimento\n8 - Idade\n9 - Signo\n\n0 - VOLTAR\nDigite aqui: ");
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
            
            try {
                if (opcao.equals("4") || opcao.equals("5") || opcao.equals("8")) {
                    System.out.println("Digite aqui: ");
                    String s = keyboard.nextLine();
                    switch(opcao) {
                        case "4":
                        this.usersList.get(login).dataLongInt.put("Celular (1)", new UserData<Long>(Long.parseLong(s), "Celular (1)"));
                        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("\tNúmero (1) adicionado com sucesso!");
                        break;
                        
                        case "5":
                        this.usersList.get(login).dataLongInt.put("Celular (2)", new UserData<Long>(Long.parseLong(s), "Celular (2)"));
                        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("\tNúmero (2) adicionado com sucesso!");
                        break;

                        case "8":
                        this.usersList.get(login).dataLongInt.put("Idade", new UserData<Long>(Long.parseLong(s), "Idade"));
                        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("\tIdade adicionada com sucesso!");
                        break;
                    }
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                }

                else if (Integer.parseInt(opcao) <= 9 && Integer.parseInt(opcao) >= 6) {
                    System.out.println("Digite aqui: ");
                    String s = keyboard.nextLine();
                    switch(opcao) {
                        case "6":
                        this.usersList.get(login).dataStr.put("Endereço", new UserData<String>(s, "Endereço"));
                        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("\tSeu endereço foi adicionado com sucesso!");
                        break;

                        case "7":
                        this.usersList.get(login).dataStr.put("Data de nascimento", new UserData<String>(s, "Data de nascimento"));
                        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("\tData de nascimento adicionada com sucesso!");
                        break;

                        case "9":
                        this.usersList.get(login).dataStr.put("Signo", new UserData<String>(s, "Signo"));
                        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("\tSeu signo foi adicionado com sucesso!");
                        break;
                    }
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                }
            } catch(NumberFormatException e) {
                System.out.println("\nDigito inválido.");
                continue;
            }
        }
    }
}