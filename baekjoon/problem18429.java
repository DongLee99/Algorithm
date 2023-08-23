import java.util.*;



public class Main
{
    public static int N;
    public static int K;
    public static int [] arr;
    public static int [] tmp;
    public static int RESULT = 0;
    public static boolean [] visited;

    public static void find(int count) {
        if (count == N) {
            int now = 500;
            for (int i = 0; i < N; i++) {
                now = now + tmp[i] - K;
                if (now < 500) {
                    return;
                }
            }
            RESULT++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i] == false) {
                tmp[count] = arr[i];
                visited[i] = true;
                find(count + 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N];
        tmp = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        find(0);
        System.out.println(RESULT);
    }
}