import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem {
    static int T;
    static int N;
    static int M;
    static int [] arr;
    static int [] result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            st = new StringTokenizer(bf.readLine());
            M = Integer.parseInt(st.nextToken());
            result = new int [M+1];
            result[0] = 1;
            for (int coin : arr) {
                for (int k = coin; k <= M; k++) {
                    result[k] = result[k] + result[k-coin];
                }
            }
            System.out.println(result[M]);
        }
    }
}