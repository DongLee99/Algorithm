import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < K; i++) {
            int start = sc.nextInt();
            int finish = sc.nextInt();
            int div = finish - start + 1;
            int total = 0;
            for (int j = start - 1; j < finish; j++) {
                total = total + arr[j];
            }
            double d = (double) total / (double) div;
            System.out.println(String.format("%.2f", d));
        }
    }
}