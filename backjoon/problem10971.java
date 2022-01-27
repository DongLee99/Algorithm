import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.regex.Matcher;

public class problem {
    static boolean visit[];
    static int [][] arrays;
    static int N;
    static int MIN = Integer.MAX_VALUE;

    static void check(int num, int start, int now, int depth) {
        if (now == start && num > 0) {
            MIN = Math.min(MIN, num);
            return;
        }
        for (int n = 1; n <= N; n++) {
            if (arrays[now][n] > 0) {
                if (start == n && N == depth) {
                    num = num + arrays[now][n];
                    check(num, start, n, depth + 1);
                }
                else if (!visit[n]) {
                    visit[n] = true;
                    num = num + arrays[now][n];

                    check(num, start, n, depth + 1);

                    num = num - arrays[now][n];
                    visit[n] = false;

                }
            }
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arrays = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            String[] sarr = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                arrays[i][j] = Integer.parseInt(sarr[j - 1]);
            }
        }

        visit[1] = true;
        check(0, 1, 1, 1);

        bw.write(MIN + "\n");
        bw.flush();

    }
}
