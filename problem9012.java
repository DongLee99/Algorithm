import java.util.Scanner;
import java.util.Stack;

public class problem9012 {
    public static void main(String args[]){
        Scanner scanf = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        Stack<String> stack1 = new Stack<>();
        boolean result = false;
        int a = scanf.nextInt();
        for (int i =0; i < a; i++){
            String text = scanf.next();
            for (int j =0; j<text.length(); j++){
                stack.push(text.charAt(j));
                if (text.charAt(j) == ')'){
                    if (stack.size() == 1){
                        result = true;
                        stack1.push("NO");

                        for(int k = 0; k<stack.size(); k++){
                            stack.pop();
                        }
                        break;

                    }
                    if (stack.get(stack.size()-2) =='('){
                        stack.pop();
                        stack.pop();
                    }
                }

            }

            if (stack.size() > 0){
                result = true;
                stack1.push("NO");

                while(stack.size()>0){
                    stack.pop();
                }
            }

            if (stack.size() == 0 && result == false){
                stack1.push("YES");
            }
            result = false;
        }

        for (int i = 0; i<stack1.size(); i++){
            System.out.println(stack1.get(i));
        }
    }
}
