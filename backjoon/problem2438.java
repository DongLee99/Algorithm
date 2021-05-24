import java.util.Scanner;

public class problem2438 {
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        int tmp = scanf.nextInt();
        int cnt = 1;
        for (int i = 0 ;i < tmp; i++) {
            for (int j = 0; j < cnt; j++) {
                System.out.print('*');
            }
            cnt++;
            System.out.println();
        }
    }
}
