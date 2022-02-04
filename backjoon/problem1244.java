
import java.util.Scanner;

class problem{
    static int [] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        arr = new int [N + 1];

        for (int i = 1; i <=N; i++) {
            arr[i] = scanner.nextInt();
        }

        int M = scanner.nextInt();

        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (x == 1) {
                for (int j = 1; j <= N; j++) {
                    if (j % y == 0) {
                        if (arr[j] == 0) {
                            arr[j] = 1;
                        } else {
                            arr[j] = 0;
                        }
                    }
                }
            } else {
                for (int j = 1; j <= N; j++) {
                    if (y-j > 0 && y+j <= N) {
                        if (arr[y-j] == arr[y + j]) {
                            if (arr[y - j] == 0) {
                                arr[y-j] = 1;
                                arr[y+j] = 1;
                            } else {
                                arr[y - j] = 0;
                                arr[y + j] = 0;
                            }
                        } else {
                            if (arr[y] == 0) {
                                arr[y] = 1;
                            } else {
                                arr[y] = 0;
                            }
                            break;
                        }
                    } else {
                        if (arr[y] == 0) {
                            arr[y] = 1;
                        } else {
                            arr[y] = 0;
                        }
                        break;
                    }
                }
            }
        }
        for (int k = 1; k <= N; k++) {
            System.out.print(arr[k] + " ");
            if (k % 20 == 0) {
                System.out.println();
            }
        }
    }
}