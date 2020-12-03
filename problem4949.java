import java.util.Scanner;
import java.util.Stack;

public class problem4949 {
    public static void main(String args[]){
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        Stack<String> stack3 = new Stack<>();
        int cnt = 0;
        Scanner scanf = new Scanner(System.in);
        boolean result2 = false;
        boolean result = false;
        while (result == false) {
            String text = scanf.nextLine();
            if (text.charAt(text.length()-1) == '.' && text.length() == 1){
                result = true;
                break;
            }
            cnt++;
            for (int i = 0 ; i< text.length();i++){
                if (text.charAt(i) == '('){
                    stack1.push(text.charAt(i));
                    continue;
                }else if (text.charAt(i) == '['){
                    stack1.push(text.charAt(i));
                    continue;
                }
                else if(stack1.size() == 0 && text.charAt(i) == ')'){
                    stack3.push("no");
                    result2 = true;
                    break;
                }else if(stack1.size() == 0 && text.charAt(i) == ']'){
                    stack3.push("no");
                    result2 = true;
                    break;
                }

                else if (text.charAt(i) == ')'){
                    if (stack1.get(stack1.size()-1) == '('){
                        stack1.pop();
                        continue;
                    }else {
                        stack1.push(text.charAt(i));
                        continue;
                    }
                }else if (text.charAt(i) == ']'){
                    if (stack1.get(stack1.size()-1) == '['){
                        stack1.pop();
                        continue;
                    }else {
                        stack1.push(text.charAt(i));
                        continue;
                    }
                }
            }

            if (stack1.size() == 0 ){
                if (result2 == false) {
                    stack3.push("yes");

                }

            }else {
                stack3.push("no");

            }
            result2 = false;

            while(stack1.size()>0){
                stack1.pop();
            }

        }
        for (int i= 0 ; i< stack3.size() ; i++){
            if(i != stack3.size()-1){
                System.out.println(stack3.get(i));
            }
            else {
                System.out.print(stack3.get(i));
            }

        }



    }
}
