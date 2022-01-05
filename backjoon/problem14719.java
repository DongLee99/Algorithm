import java.util.Scanner;

public class problem14719 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        int x = scanner.nextInt();

        int [][] array = new int[x+1][y+1];
        boolean check = false;
        int position = 0;
        int count = 0;

        for (int i = 0; i < x; i++) {
            int top = scanner.nextInt();

            for (int j = 0; j < top; j++) {
                array[i][j] = 1;
            }
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (array[j][i] == 1) {
                    if (check == false) {
                        check = true;
                        position = j;
                    } else {
                        count = count + j - position - 1;
                        position = j;
                    }
                }
            }
            check = false;
            position = 0;
        }
        System.out.println(count);
    }
}
