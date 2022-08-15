import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class main {
    public static int R;
    public static int C;
    public static int N;
    public static int [][] arr;
    public static int [][] pSum;

    public static int getResult(int x1, int y1, int x2, int y2) {
        int count = (x2 - x1 + 1) * (y2 - y1 + 1);
        return (pSum[x2][y2] - pSum[x1-1][y2] - pSum[x2][y1-1] + pSum[x1-1][y1-1]) / count;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        pSum = new int[R+1][C+1];

        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                pSum[i][j] = pSum[i-1][j] + pSum[i][j-1] - pSum[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(getResult(x1, y1, x2, y2));
        }

    }
}