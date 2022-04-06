import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem {

    static int N;
    static int [][] arr;
    static int MAX = 0;

    static void find(int now) {
        if (now == N) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i][0] <= 0) {
                    cnt++;
                }
            }
            MAX = Math.max(MAX, cnt);
            return;
        }

        if (arr[now][0] <= 0) {
            find(now + 1);
        } else {
            boolean f = false;
            for (int j = 0; j < N; j++) {
                if (now == j || arr[j][0] <= 0) {
                    continue;
                }
                f = true;
                arr[now][0] = arr[now][0] - arr[j][1];
                arr[j][0] = arr[j][0] - arr[now][1];
                find(now + 1);
                arr[now][0] = arr[now][0] + arr[j][1];
                arr[j][0] = arr[j][0] + arr[now][1];
            }
            if (f == false) {
                find(now+1);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        arr = new int [N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        find(0);
        System.out.println(MAX);
    }
}