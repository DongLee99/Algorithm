import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem {
    static int N;
    static int M;
    static String [][] arr;
    static int MIN = Integer.MAX_VALUE;

    static void check(int x, int y) {
        find("B", x, y);
        find("W", x, y);
    }
    static void find(String tmp, int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 8; j++) {
                    if (j % 2 == 0) {
                        if (!arr[x+i][y+j].equals(tmp)) {
                            count++;
                        }
                    } else {
                        if (arr[x+i][y+j].equals(tmp)) {
                            count++;
                        }
                    }
                }
            } else {
                for (int j = 0; j < 8; j++) {
                    if (j % 2 == 1) {
                        if (!arr[x+i][y+j].equals(tmp)) {
                            count++;
                        }
                    } else {
                        if (arr[x+i][y+j].equals(tmp)) {
                            count++;
                        }
                    }
                }
            }
        }
        MIN = Math.min(count, MIN);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new String [N][M];

        for (int i = 0; i < N; i++) {
            String buffer = bf.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = String.valueOf(buffer.charAt(j));
            }
        }

        int N_row = N - 7;
        int M_col = M - 7;


        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                check(i, j);
            }
        }
        System.out.println(MIN);
    }
}