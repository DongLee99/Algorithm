import java.util.Scanner;
import java.util.Stack;
public class problem2675 {
    public static void main(String[] args){
        Scanner scanf = new Scanner(System.in);
        int s = scanf.nextInt();
        Stack<Integer> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        for(int i = 0; i < s; i++){
            int a = scanf.nextInt();
            stack1.push(a);
            String S = scanf.next();
            stack2.push(S);
        }
        for(int i = 0; i<stack1.size();i++){

                int cnt = stack2.get(i).length();
                for(int k =0; k < cnt; k++) {
                    for (int c = 0; c < stack1.get(i); c++) {
                        System.out.print(stack2.get(i).charAt(k));
                    }
                }
                System.out.println();

        }
    }
}
