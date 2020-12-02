import java.util.Scanner;
import java.util.Stack;
public class problem2908 {
    public static void main(String args[]){
        Scanner scanf = new Scanner(System.in);
        String text1 = "";
        String text2 = "";
        String a = scanf.next();
        String b = scanf.next();

        for (int i = a.length(); i>0; i--){
            text1 = text1 + Character.toString(a.charAt(i-1));
        }
        for (int i = b.length(); i>0; i--){
            text2 = text2 + Character.toString(b.charAt(i-1));
        }
        if ((Integer.parseInt(text1) > Integer.parseInt(text2))){
            System.out.print(text1);
        }
        else{
            System.out.print(text2);
        }
    }
}
