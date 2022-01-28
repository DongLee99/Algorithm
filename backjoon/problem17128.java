import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problem {
    static List<Integer> print = new ArrayList<>();
    static int [] section;
    static int N;
    static int M;
    static int sum;
    static int [] arr;

    static void makeSum(){
        int result = 0;
        for (int i : section) {
            result = result + i;
        }
        sum = result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        arr = new int[N];
        section = new int [N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int res = 0;
            res = arr[i % N] * arr[(i+1)%N] * arr[(i+2)%N] * arr[(i+3)%N];
            sum = sum + res;
            section[i] = res;
        }

        for (int i = 0; i < M; i++) {
            int m = scanner.nextInt() - 1;
            int a1 = m - 1;
            int a2 = m - 2;
            int a3 = m - 3;
            if (m - 1 < 0) {
                a1 = N + (m - 1);
            }
            if (m - 2 < 0) {
                a2 = N + (m - 2);
            }
            if (m - 3 < 0) {
                a3 = N + (m - 3);
            }
            section[m] = section[m] * -1;
            section[a1] = section[a1] * -1;
            section[a2] = section[a2] * -1;
            section[a3] = section[a3] * -1;
            makeSum();
            print.add(sum);
        }
        for (Integer integer : print) {
            System.out.println(integer);
        }
    }
}
