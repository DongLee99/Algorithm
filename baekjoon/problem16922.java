import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static int N;
    public static int result = 0;
    public static int [] arr = {1, 5, 10 ,50};
    public static boolean[] visit = new boolean[1001];
    public static void sum(int count, int idx, int depth) {
        if (depth == N) {
            if (visit[count] == false) {
                visit[count] = true;
                result++;
            }
            return;
        }
        for (int i = idx; i < 4; i++) {
            sum(count + arr[i], i, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        sum(0, 0, 0);
        System.out.println(result);
    }
}