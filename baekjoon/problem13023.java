import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int N;
    public static int M;
    public static ArrayList<Integer>[] arr;
    public static boolean[] visited;
    public static boolean RESULT = false;

    public static void find(int x, int count) {
        if (count == 5) {
            System.out.println(1);
            System.exit(0);
        }
        for (int i = 0; i < arr[x].size(); i++) {
            int tmp = arr[x].get(i);
            if (visited[tmp] == false) {
                visited[tmp] = true;
                find(tmp, count + 1);
                visited[tmp] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }
        visited = new boolean[N];
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr[x].add(y);
            arr[y].add(x);
        }
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            find(i, 1);
            visited[i] = false;
        }
        System.out.println(0);
    }
}