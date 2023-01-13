import java.util.*;

class Solution
{
    public static int N;
    public static int [] A;
    public static int [] dp;
    public static int B;
    public static int C;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.nextLine();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        scanner.nextLine();
        B = scanner.nextInt();
        C = scanner.nextInt();
        long result = 0;
        long size = 0;

        for (int i = 0; i < N; i++) {
            size = B;
            result++;
            if (A[i] > B) {
                if ((A[i] - B) % C != 0) {
                    result = result + (A[i] - B) / C + 1;
                } else {
                    result = result +(A[i] - B) / C;
                }

            }
        }
        System.out.println(result);
    }
}