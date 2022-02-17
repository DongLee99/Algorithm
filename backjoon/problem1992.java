import java.util.*;

public class problem {
    static int [][] arr;
    static String result = "";

    static void check(int x, int y, int N) {
        if (test(x, y, N)) {
            result = result + arr[x][y];
            return;
        }
        result = result + "(";

        check(x, y, N/2);
        check(x, y + N/2, N/2);
        check(x + N/2, y, N/2);
        check(x + N/2, y + N/2, N/2);

        result = result + ")";

    }

    static boolean test(int x, int y, int N) {
        int test = arr[x][y];
        for (int i = x; i < x + N; i++) {
            for (int j = y ; j < y + N; j++) {
                if (test != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        arr = new int[N][N];

        for (int i = 0; i <N; i++) {
            String tmp = scanner.next();
            for (int j = 0; j <N; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
            }
        }

        check(0, 0, N);
        System.out.println(result);
    }
}