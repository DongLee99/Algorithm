import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class problem2512 {
    static int N;
    static int arr [];
    static int M;
    static int visit;
    static int limit;
    static void search(int left, int right){
        while (left < right){
            int tmp = 0;
            int middle = (left +right)/2;
            int result = 0;
            for (int i = 0 ; i< N; i++){
                if (arr[i] > middle){
                    result = result + middle;
                }else {
                    result = result + arr[i];
                }
            }
            tmp = tmp -result;
            if (tmp < limit){
                limit = tmp;
            }
            if (M < result){
                //System.out.println(result);
                right = middle;
            }else {
                //System.out.println(result);
                left = middle+1;
            }
        }
        System.out.print(left-1);

    }
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        N = scanf.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = scanf.nextInt();
        }
        M = scanf.nextInt();
        Arrays.sort(arr);
        if (arr[N-1] *4 <= M){
            System.out.print(arr[N-1]);
        }else {
            search(arr[0],arr[N-1]);
        }
    }
}
// 모르겠다...

