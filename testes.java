//import java.text.SimpleDateFormat;
//import java.util.Calendar;

//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Scanner;

public class testes {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //ArrayList<String> list = new ArrayList<String>();
        /*HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        String n1="Konoha";
        String n2="José";
        String msg;*/
        String msg = keyboard.nextLine();
        //String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());
        //msg = "[" + timeStamp + "] " + "Will: " + msg;
        /*for (int i=2; i < msg.length(); i++) {
            System.out.print(msg.charAt(i));
        }*/
        msg = msg.substring(0, msg.length()-2);
//        msg = msg.replace(String.valueOf(msg.charAt(msg.length()-2)), "");
        System.out.println(msg);
            /*getTime());
        int n = keyboard.nextInt();
        if (keyboard.hasNextLine())//problema de buffer
            keyboard.nextLine();
        msg = keyboard.nextLine();
        System.out.println(msg);

        /*map.put("José", list);

        msg = keyboard.nextLine();
        list.add(n1 + ": " + msg);
        msg = keyboard.nextLine();
        list.add(n2 + ": " + msg);

        System.out.println(map.get(n2));
        /*for (String frase: map.get(n2))
            System.out.println(frase);*/

        keyboard.close();
    }
}