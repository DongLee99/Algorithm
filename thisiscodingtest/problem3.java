import java.io.*;
import java.util.*;

public class problem {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = N;
        int count = 0;
        while(result != 1) {
            if (result % K == 0) {
                result = result / K;
                count++;
            } else {
                result = result - 1;
                count++;
            }
        }
        System.out.println(count);
    }
}