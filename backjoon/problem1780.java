import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem {
    static int [][] arr;
    static int N;
    static int result1;
    static int result0;
    static int result;

    static void check(int x, int y, int size) {
        int tmp = arr[x][y];
        if (isPossible(tmp, x, y, size)) {
            if (tmp == 1) {
                result1 += 1;

            }
            if (tmp == 0) {
                result0 += 1;
            }
            if (tmp == -1) {
                result += 1;
            }
            return;
        }

        check(x, y, size/3);
        check(x, y + size/3, size/3);
        check(x, y + (size/3 * 2), size/3);
        check(x + size/3, y, size/3);
        check(x + size/3, y + size/3, size/3);
        check(x + size/3, y + (size/3 * 2), size/3);
        check(x + (size/3 * 2), y, size/3);
        check(x + (size/3 * 2), y + size/3, size/3);
        check(x + (size/3 * 2), y + (size/3 * 2), size/3);
    }

    private static boolean isPossible(int tmp, int x, int y, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[x+i][y+j] != tmp) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int [N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check(0, 0, N);
        System.out.println(result);
        System.out.println(result0);
        System.out.println(result1);
    }
}