import java.util.*;

public class problem {
    static int A;
    static int B;
    static int C;
    static int M;
    static int now = 0;
    static int count;
    static int work;

    static void check() {
        if (count == 24) {
            System.out.println(work);
            return;
        }
        if ((now + A) <= M) {
            now = now + A;
            count++;
            work += B;
            check();
        } else {
            now = now - C;
            if (now < 0) {
                now = 0;
            }
            count++;
            check();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        B = scanner.nextInt();
        C = scanner.nextInt();
        M = scanner.nextInt();
        if (A > M) {
            System.out.println(0);
            return;
        }
        check();
    }
}