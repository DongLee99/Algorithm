import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {

    public static int N;
    public static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] levels = new int[N];

        long max = Integer.MAX_VALUE;
        long min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            levels[i] = Integer.parseInt(bf.readLine());
            min = Math.min(min, levels[i]);
        }

        long answer = 0;
        while (min <= max) {
            long mid = (max + min) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (mid >= levels[i]) {
                    sum += mid - levels[i];
                }
            }
            if (K >= sum) {
                min = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                max = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
