import java.util.Scanner;
import java.util.Arrays;
public class problem2693 {
    public static void main(String args[]){
        Scanner scanf = new Scanner(System.in);
        int num = scanf.nextInt();
        int [] result = new int[num];
        for (int i = 0 ; i< num; i++){
            int[] tmp = new int [10];
            for (int j = 0; j<10; j++){
                int a = scanf.nextInt();
                tmp[j] = a;
            }
            Arrays.sort(tmp);
            result[i] = tmp[7];
        }
        for (int i = 0; i < num; i++){
            System.out.println(result[i]);
        }
    }
}
