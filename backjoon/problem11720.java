import java.util.Scanner;
import java.util.Stack;

public class problem11720 {
    public static void main(String args[]) {
        Scanner scanf = new Scanner(System.in);
        Stack<Integer> stack1 = new Stack<>();

        int a = scanf.nextInt();
        String b = scanf.next();
        int sum =0;
        for (int i = 0; i<a; i++){
            sum = sum + Integer.parseInt(Character.toString(b.charAt(i)));
        }
        System.out.print(sum);
    }
}
