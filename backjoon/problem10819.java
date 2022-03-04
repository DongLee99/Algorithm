import javax.imageio.ImageTranscoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem {
    static int N;
    static int [] arr;
    static boolean [] visit;
    static int [] result;
    static int MAX = Integer.MIN_VALUE;

    static void dfs(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N-1; i++) {
                sum = sum + Math.abs(result[i] - result[i+1]);
            }
            MAX = Math.max(MAX,sum);
        }
        for (int i = 0; i< N; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                result[depth] = arr[i];
                dfs(depth+1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visit = new boolean [N];
        result = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(MAX);
    }
}