import java.util.Scanner;
import java.util.Stack;

public class problem10773 {
    public static void main(String args[]){
        Scanner scanf = new Scanner(System.in);
        int a = scanf.nextInt();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < a ; i ++){
            int b = scanf.nextInt();
            if (b == 0){
                stack.pop();
            }
            else {
                stack.push(b);
            }
        }
        int sum = 0;
        for (int i =0; i< stack.size(); i++){
            sum = sum + stack.get(i);
        }
        System.out.print(sum);
    }
}
