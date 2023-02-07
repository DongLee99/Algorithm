import java.util.*;

public class problem {
    static int N;
    static int [][] arrays;
    static boolean [][] visit;
    static int count = 0;
    static int MIN = Integer.MAX_VALUE;

    static void check(int x, int y, int depth) {
        if (depth == 3) {
            if (count < MIN) {
                MIN = count;
                count = 0;
                return;
            }
        } else {
            if (visit[x][y] == false && visit[x+1][y] == false && visit[x][y+1] == false&& visit[x-1][y] == false&& visit[x][y-1] == false)
                visit[x][y] = true;
            visit[x+1][y] = true;
            visit[x][y+1] = true;
            visit[x-1][y] = true;
            visit[x][y-1] = true;
            for (int i = 1; i < N-x-1; i++) {
                for (int j = 1; j < N-y-1; j++) {
                    count = count + arrays[x][y] + arrays[x+1][y] + arrays[x][y+1] +arrays[x-1][y] +arrays[x][y-1];
                    check(x + i, y + j, depth + 1);
                    visit = new boolean[N+1][N+1];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        arrays = new int[N+1][N+1];
        visit = new boolean[N+1][N+1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arrays[i][j] = scanner.nextInt();
            }
        }

        check(1,1,0);
        System.out.println(MIN);
    }
}