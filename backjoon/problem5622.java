import java.util.Scanner;
import java.util.Stack;

public class problem5622 {
    public static void main(String args[]){
        Scanner scanf = new Scanner(System.in);
        Stack<Integer> sum = new Stack<>();
        String a = scanf.next();
        int result =0;
        char [][] b = {{'2','A','B','C'} , {'3','D','E','F'}, {'4','G','H','I'},{'5','J','K','l'},{'6','M','N','O'},{'8','T','U','V'}};
        char [][] c ={{'7','P','Q','R','S'},{'9','W','X','Y','Z'}};
        for (int k = 0; k < a.length(); k ++) {
            for (int i = 0; i < 6; i++) {
                for (int j = 1; j < 4; j++) {
                    if (a.charAt(k) == b[i][j]){
                        sum.push(Integer.parseInt(Character.toString(b[i][0]))+1);
                        break;
                    }
                }
            }
            for (int i =0; i<2; i++){
                for (int j = 1; j < 5; j++) {
                    if (a.charAt(k) == c[i][j]){
                        sum.push(Integer.parseInt(Character.toString(c[i][0]))+1);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i<sum.size(); i++){
            result = result + sum.get(i);
        }
        System.out.print(result);
    }
}
