import java.util.Scanner;

public class Main {
    public static int N;
    public static int[] tmp;
    public static boolean[] visited;

    public static void find(int count) {
        if (count == N) {
            for (int i : tmp) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                tmp[count] = i;
                find(count + 1);
                visited[i] = false;
            }

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        tmp = new int[N];
        visited = new boolean[N + 1];
        find(0);
    }
}
