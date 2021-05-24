import java.util.Scanner;

public class problem5585 {
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        int num = scanf.nextInt();
        int result = 1000 - num;
        int cnt = 0;
        int[] coin = { 500, 100, 50, 10, 5,1 };
        for (int i = 0 ; i< coin.length; i++){
            if (result == 0){
                break;
            }
            while ( result >= coin[i]){
                result = result - coin[i];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
