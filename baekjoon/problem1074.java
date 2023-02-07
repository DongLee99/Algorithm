import java.util.*;

public class problem {
    static int count = 0;
    static void check(int result, int r, int c) {
        if (result == 1) {
            return;
        }

        if (r < result / 2 && c < result / 2) {
            check(result / 2, r, c);
        } else if (r < result / 2 && c >= result / 2) {
            count += result * result / 4;
            check(result / 2, r, c - result / 2);
        } else if (r >= result / 2 && c < result / 2) {
            count += (result * result / 4) * 2;
            check(result / 2, r - result / 2, c);
        } else {
            count += (result * result / 4) * 3;
            check(result / 2, r - result / 2, c - result / 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();

        int result = (int) Math.pow(2, N);
        check(result, r, c);

        System.out.println(count);

    }
}