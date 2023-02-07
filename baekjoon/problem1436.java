import java.util.Scanner;

public class problem1436 {
    public static void main(String[] args){
        Scanner scanf = new Scanner(System.in);
        int a = scanf.nextInt();
        int tmp = 666;
        int cnt = 1;
        String text = "";
        while(true){
            if( a == cnt){
                break;
            }else {
                tmp++;
                text = Integer.toString(tmp);
                if (text.contains("666") == true){
                    cnt++;
                };
            }
        }
        System.out.print(tmp);
    }
}
