import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        int [] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum = sum + numbers[i];
        }
        int max = sum;
        int maxCount = 1;
        for (int i = X; i < N; i++) {
            sum = sum + numbers[i] - numbers[i-X];
            if (sum == max) {
                maxCount++;
            } else if (sum > max) {
                max = sum;
                maxCount = 1;
            }
        }

        if (max != 0) {
            System.out.println(max);
            System.out.println(maxCount);
        } else {
            System.out.println("SAD");
        }
    }
}
