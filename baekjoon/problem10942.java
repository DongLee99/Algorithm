import java.util.*;
public class Main {
    public static int N;
    public static int M;
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int finish = sc.nextInt();
            int size = finish - start;
            if (size == 0) {
                System.out.println(1);
                continue;
            }
            boolean check = true;
            int index = 0;
            for (int j = start - 1; j < (size + 1) / 2; j++) {
                if (arr[j] != arr[finish - 1 - index++]) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}