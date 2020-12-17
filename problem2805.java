import java.util.Scanner;
import java.util.Arrays;
public class problem2805 {
    static long [] tmp;
    static long stop;
    static long b;
    public static void search(long start, long end){
        long mid = (start + end)/2;
        long result = 0;
        //System.out.println(mid);
        for (int i = 0 ; i < tmp.length; i++){
            if ( tmp[i] > mid) {
                result = result + tmp[i] - mid;
            }else {
                continue;
            }
        }
        System.out.print(result);
        if (start > end){
            System.out.print("finish" + start + " " + end);
            stop = end;
            return;
        }else if (result >= b){
            System.out.println("big" + start + " " + end);
            search(mid + 1,end);
        }else {
            System.out.println("down" + start + " " + end);
            search(start, mid -1);
        }
    }
    public static void main(String args[]) {
        Scanner scanf = new Scanner(System.in);
        int a = scanf.nextInt();
        b = scanf.nextInt();
        tmp = new long [a];
        for (int i = 0 ; i < a; i++){
            long c = scanf.nextLong();
            tmp[i] = c;
        }
        Arrays.sort(tmp);
        search(1,tmp[tmp.length-1]);
        System.out.print(stop);
    }
}
