import java.util.Scanner;
import java.util.Arrays;
public class problem1654 {
    static long tmp [];
    static long stop1;
    public static void search(long tmp[], long stop, long start ,int b){
        long mid = ((stop + start)/2);
        //System.out.println(mid);
        long result = 0;
        for (int i = 0 ; i < tmp.length; i++){
             result = result + tmp[i]/mid;
        }
        //System.out.print(result);
            if (stop >start){
                stop1 = mid;
                return;
            }else if (result >=b ){
                //System.out.println("stop" + mid + " " + start);
                search(tmp, mid+1, start, b);
            }else {
                //System.out.println("start" + stop + " " + mid);
                search(tmp, stop,mid-1,b);
            }
    }

    public static void main(String args[]) {
        Scanner scanf = new Scanner(System.in);
        int a = scanf.nextInt();
        int b = scanf.nextInt();
        tmp = new long[a];
        for (int i = 0; i < a; i ++){
            long c = scanf.nextLong();
            tmp[i] = c;
        }
        Arrays.sort(tmp);
        search(tmp, 1 , tmp[a-1], b);
        System.out.print(stop1);
    }

}