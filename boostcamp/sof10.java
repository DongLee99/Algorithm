import java.util.*;
import java.io.*;


public class Main
{
    public static int N, K, P;
    public static void main(String args[]) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        long answer = K;
        for(int i = 1; i <= N; i++) {
            answer = (answer * P) % 1000000007;
        }
        System.out.println(answer);
    }
}
