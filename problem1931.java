import java.util.Scanner;
import java.util.Stack;
public class problem1931 {
    public static void main(String args[]){
        Scanner scanf = new Scanner(System.in);

        int a = scanf.nextInt();
        Stack<Integer> stack = new Stack<>();
        boolean result = false;
        for (int i = 0; i < a; i ++){
            int b = scanf.nextInt();
            int c = scanf.nextInt();
            if (stack.empty()) {
                stack.push(b);
                stack.push(c);
            }else {
                for (int j = 0 ; j< stack.size(); j= j+2){
                    if (stack.get(j) <=b && c <=stack.get(j+1)){// 안에
                        //System.out.println(1);
                        result = true;
                    }else if (b<=stack.get(j)  && c<=stack.get(j+1) && stack.get(j) <=c){ //왼쪽
                        //System.out.println(2);
                        result = true;
                    }else if ( b <= stack.get(j+1) && stack.get(j) <=b && stack.get(j+1)<=c) { //오른쪽
                        //System.out.println(3);
                        result = true;
                    }else if ( b<=stack.get(j) && stack.get(j+1)<=c){ //
                        //System.out.println(4);
                        result = true;
                    }else {
                        result = false;
                    }
                }
                if (result == false){
                    stack.push(b);
                    stack.push(c);
                }
            }
        }

        System.out.print(stack.size()/2);
    }
}
