import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem {
    static int M;
    static int N;
    static int count = Integer.MAX_VALUE;

    static void check(long num, int ct) {
        if (num == M) {
            count = Math.min(count, ct);
            return;
        }
        if (num > M) {
            return;
        }
        ct = ct + 1;
        check(num*2, ct);
        check(num*10 + 1, ct);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check(N, 1);
        if (count == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(count);
    }
}