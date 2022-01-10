import java.util.Scanner;

public class problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int k = scanner.nextInt();

        boolean result = false;

        int [] tmp = new int [x + 1];

        for (int i = 0; i < x; i++) {
            tmp[i] = scanner.nextInt();
        }

        int point1 = 0;
        int point2 = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;

        while (point1 <= x && point2 <= x) {
            if (count >= k && min > point2 - point1) {
                min = point2 - point1;
            }
            if (count < k) {
                count = count + tmp[point2++];
            }  else {
                count = count - tmp[point1++];
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}
