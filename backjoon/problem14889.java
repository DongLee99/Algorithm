import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class main {
    public static int N;
    public static int [][] arr;
    public static boolean [] visit;
    public static int [] numbers;
    public static int Min = Integer.MAX_VALUE;

    static void combi(int idx, int count) {
        if (count == N / 2) {
            diff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                combi(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }

    static void diff() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] == true && visit[j] == true) {
                    team_start += arr[i][j];
                    team_start += arr[j][i];
                } else if (visit[i] == false && visit[j] == false) {
                    team_link += arr[i][j];
                    team_link += arr[j][i];
                }
            }
        }
        int val = Math.abs(team_start - team_link);
        if (val == 0) {
            System.out.println(0);
            System.exit(0);
        }
        Min = Math.min(Min, val);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        arr = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            String tmp = bf.readLine();
            String[] s = tmp.split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        combi(0, 0);
        System.out.println(Min);
    }
}