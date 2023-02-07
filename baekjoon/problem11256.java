import java.util.*;

public class problem {
    static int candy;
    static int M;
    static int [] arrays;
    static List<Integer> result = new ArrayList<>();
    static void check() {
        Arrays.sort(arrays);
        int count = 1;
        for (int i = arrays.length - 1; i > 0; i--) {
            if (candy > 0) {
                candy = candy - arrays[i];
                if (candy <= 0) {
                    result.add(count);
                    break;
                } else {
                    count++;
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            candy = scanner.nextInt();
            M = scanner.nextInt();
            arrays = new int[M];
            for (int j = 0; j < M; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                arrays[j] = x * y;
            }
            check();
        }
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}