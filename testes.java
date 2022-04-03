import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class testes {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        String n1="Konoha";
        String n2="José";
        String msg;

        msg = keyboard.nextLine();
        list.add(n1 + ": " + msg);
        msg = keyboard.nextLine();
        list.add(n2 + ": " + msg);

        map.put(n2, list);

        for (String frase: map.get(n2))
            System.out.println(frase);

        keyboard.close();
    }
}