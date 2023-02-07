import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int R;
    public static int [][] arr;

    public static void turn() {
        int m = M;
        int n = N;
        int x = 0;
        int y = 0;
        while(x <= n-1 && y <= m-1) {
            int tmp_x = x;
            int tmp_y = y;
            int tmp = arr[x][y];
            int next = arr[x][y];


            for (int i = x; i < n; i++) {
                if (i == x) {
                    tmp = arr[i+1][y];
                    next = arr[i][y];
                    arr[i+1][y] = next;
                } else if (i == n-1)  {
                    x = i;
                    next = tmp;
                } else {
                    next = tmp;
                    tmp = arr[i+1][y];
                    arr[i+1][y] = next;
                }
            }



            for (int j = y; j < m; j++) {
                if (j == y) {
                    tmp = arr[x][j + 1];
                    arr[x][j + 1] = next;
                } else if (j == m-1)  {
                    y = j;
                    next = tmp;
                } else {
                    next = tmp;
                    tmp = arr[x][j + 1];
                    arr[x][j + 1] = next;
                }
            }

            x = tmp_x;
            for (int i = n-1; i >= x; i--) {
                if (i == n-1) {
                    tmp = arr[i-1][y];
                    arr[i-1][y] = next;
                } else if (i == x)  {
                    x = i;
                    next = tmp;
                } else {
                    next = tmp;
                    tmp = arr[i-1][y];
                    arr[i-1][y] = next;
                }
            }

            y = tmp_y;
            for (int j = m-1; j >= y; j--) {
                if (j == m-1) {
                    tmp = arr[x][j - 1];
                    arr[x][j - 1] = next;
                }  else if (j == y)  {
                    y = j;
                    next = tmp;
                }else {
                    next = tmp;
                    tmp = arr[x][j - 1];
                    arr[x][j - 1] = next;
                }
            }


            x++;
            y++;
            n--;
            m--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int k = 0; k < R; k++) {
            turn();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

