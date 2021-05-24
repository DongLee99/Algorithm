import java.util.Scanner;

public class problem1472 {
    public static void main(String args[]){
        Scanner scanf = new Scanner(System.in);

        String text = scanf.next();
        char [] a = new char[text.length()];
        for (int i = 0; i< text.length(); i++){
            a[i] = text.charAt(i);
        }
        char tmp = ' ';
        for (int i = 0; i< text.length(); i++){
            for (int j = i+1; j< text.length(); j++){
                if(Integer.parseInt(a[i] +"") <Integer.parseInt(a[j] +"")){
                    tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
        for (int i = 0; i<text.length();i++) {
            System.out.print(a[i]);
        }
    }
}
