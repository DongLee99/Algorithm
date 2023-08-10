import java.util.*;


public class Main
{
    public static int N;
    public static int M;
    public static int K;
    public static int[] arr;
    public static int[] tmpArr;
    public static boolean[] visited;
    public static int MIN = Integer.MAX_VALUE;

    public static void dfs(int size) {
        if (size == N) {
            int now = 0;
            int count = 1;
            int result = 0;
            int index = 0;
            while(count != K+1) {
                if (now + tmpArr[index % N] <= M) {
                    now = now + tmpArr[index % N];
                    result = result + tmpArr[index % N];
                    index++;
                } else {
                    if (count == K) {
                        break;
                    } else {
                        count++;
                        now = 0;
                        now = now + tmpArr[index % N];
                        result = result + tmpArr[index % N];
                        index++;
                    }
                }
            }
            MIN = Math.min(MIN, result);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                tmpArr[size] = arr[i];
                dfs(size + 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        K = scanner.nextInt();
        arr = new int[N];
        visited = new boolean[N];
        tmpArr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        dfs(0);
        System.out.println(MIN);
    }
}