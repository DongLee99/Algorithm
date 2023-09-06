import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int N;
    public static int PERSON1;
    public static int PERSON2;
    public static List<Integer>[] arr;
    public static boolean[] visited;
    public static int M;
    public static int RESULT = -1;

    public static void dfs(int PERSON1, int PERSON2, int count) {
        if (PERSON1 == PERSON2) {
            RESULT = count;
            return;
        }
        visited[PERSON1] = true;
        for (int i = 0; i < arr[PERSON1].size(); i++) {
            int next = arr[PERSON1].get(i);
            if (visited[next] == false) {
                dfs(next, PERSON2, count+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        PERSON1 = sc.nextInt();
        PERSON2 = sc.nextInt();
        M = sc.nextInt();
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int parent = sc.nextInt();
            int children = sc.nextInt();
            arr[parent].add(children);
            arr[children].add(parent);
        }
        dfs(PERSON1, PERSON2, 0);
        System.out.println(RESULT);
    }
}
