import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

class main {

    public static int H;
    public static int W;
    public static int X;
    public static int Y;

    public static int [][] arr;
    public static int [][] arr2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        H = scanner.nextInt();
        W = scanner.nextInt();
        X = scanner.nextInt();
        Y = scanner.nextInt();
        int cx = H - X;
        int cy = W - Y;
        int [][] arr = new int [H][W];
        int [][] arr2 = new int [H+X][W+Y];
        for (int i = 0; i < H+X; i++) {
            for (int j = 0; j < W + Y; j++) {
                arr2[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                arr[i][j] = arr2[i][j];
            }
        }
        for (int i = 0; i < cx; i++) {
            for (int j = 0; j < cy; j++) {
                arr[X + i][Y + j] = arr2[i+X][j+Y] - arr[i][j];
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}