import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem {
    static int N;
    static int [] arr = new int[10];
    static String [] result;
    static boolean [] visit = new boolean[10];
    static String [] sArr;
    static boolean [] sVisit;
    static long MAX = Long.MIN_VALUE;
    static long MIN = Long.MAX_VALUE;
    static String Min;

    static void dfs(int count) {

        if (count == N+1) {
            for (int i = 1; i <= N; i++) {
                if (sArr[i-1].equals("<")) {
                    if (Integer.parseInt(result[i-1]) < Integer.parseInt(result[i])) {
                        continue;
                    } else {
                        return;
                    }
                }
                if (sArr[i-1].equals(">")) {
                    if (Integer.parseInt(result[i-1]) > Integer.parseInt(result[i])) {
                        continue;
                    } else {
                        return;
                    }
                }
            }
            String sum = "";

            for (String i : result) {
                sum = sum + i;
            }
            if (MIN > Long.parseLong(sum)) {
                MIN = Long.parseLong(sum);
                Min = sum;

            }
            MIN = Math.min(MIN, Long.parseLong(sum));
            MAX = Math.max(MAX, Long.parseLong(sum));
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                result[count] = String.valueOf(arr[i]);

                dfs(count+1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        sArr = new String[N];
        sVisit = new boolean[N];
        result = new String[N+1];
        for (int i = 0; i < N; i++) {
            sArr[i] = st.nextToken();
        }

        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }

        dfs(0);
        System.out.println(MAX);
        System.out.println(Min);
    }
}