import java.io.IOException;
import java.util.Scanner;

class main {

    public static char [][] arr;
    public static int [] dx = {1, -1, 0, 0};
    public static int [] dy = {0, 0, -1, 1};
    public static boolean [][] visited;
    public static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new char [N+1][N+1];
        visited = new boolean [N+1][N+1];
        for (int i = 1; i <= N; i++) {
            String tmp = scanner.next();
            for (int j = 1; j <= N; j++) {
                arr[i][j] = tmp.charAt(j-1);
            }
        }

        int X = 0;
        int Y = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i + 1 <= N && i - 1 >= 1 && j + 1 <= N && j - 1 >= 1) {
                    if (arr[i][j] == '*' && arr[i + 1][j] == '*' && arr[i - 1][j] == '*' && arr[i][j + 1] == '*' && arr[i][j - 1] == '*') {
                        X = i;
                        Y = j;
                        break;
                    }
                }
            }
        }
        int lArm = 0;
        int rArm = 0;
        int lLeg = 0;
        int rLeg = 0;
        for (int i = Y + 1; i <= N; i++) {
            if (arr[X][i] == '*') {
                rArm++;
            } else {
                break;
            }
        }
        for (int i = Y - 1; i >= 1; i--) {
            if (arr[X][i] == '*') {
                lArm++;
            } else {
                break;
            }
        }
        int waist = 0;
        int dX = 0;
        for (int i = X + 1; i <= N; i++) {
            if (arr[i][Y] == '*') {
                waist++;
            }
        }
        dX = X + waist;
        for (int i = dX + 1; i <= N; i++) {
            if (arr[i][Y-1] == '*') {
                lLeg++;
            } else {
                break;
            }
        }
        for (int i = dX + 1; i <= N; i++) {
            if (arr[i][Y+1] == '*') {
                rLeg++;
            } else {
                break;
            }
        }
        System.out.println(X + " " + Y);
        System.out.println(lArm + " " + rArm + " " + waist + " " + lLeg + " " + rLeg);
    }
}