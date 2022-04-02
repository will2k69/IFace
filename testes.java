import java.util.ArrayList;

public class testes {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(20);
        nums.add(21);
        for (int i=0; i < nums.size(); i++) {
            System.out.println(nums.get(i) + " " + i);
        }
    }

}