import java.util.Scanner;


public class problem11047 {
    public static void main(String args[]){
        Scanner scanf = new Scanner(System.in);
        int cnt = 0;
        int first = scanf.nextInt();
        int second = scanf.nextInt();
        int [] tmp = new int [first];
        for (int i = 0 ; i < first; i++){
            int a = scanf.nextInt();
            tmp[i] = a;
        }

        for (int i = first-1 ; 0<= i ; i--){
            if (second == 0){

                break;
            }
            if (second / tmp[i] > 0){

                cnt = cnt + (second / tmp[i]);
                second = second % tmp[i];
            }else {

                continue;
            }
        }
        System.out.print(cnt);
    }
}
