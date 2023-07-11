import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static int N;
    public static int[][] arr;
    public static String result = "";

    public static void find(int x, int y, int size) {
        if (check(x, y, size)) {
            result = result + arr[x][y];
            return;
        }

        int newSize = size / 2;
        result = result + "(";
        find(x, y, newSize);
        find(x, y + newSize, newSize);
        find(x + newSize, y, newSize);
        find(x + newSize, y + newSize, newSize);
        result = result + ")";
    }

    public static boolean check(int x, int y, int size) {
        int tmp = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (tmp != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            String tmp = br.readLine();
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j-1)));
            }
        }
        find(1, 1, N);
        System.out.println(result);
    }
}

