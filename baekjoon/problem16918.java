import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class main {
    public static int R;
    public static int C;
    public static int N;
    public static String [][] arr;
    public static boolean [][] bomb;
    public static boolean [][] bomb2;
    public static boolean [][] bomb3;
    public static int [] dx = {1, -1, 0, 0};
    public static int [] dy = {0 , 0, 1, -1};

    public static void print(boolean[][] bomb) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bomb[i][j] == true) {
                    System.out.print("O");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    public static void reversePrint(boolean[][] bomb) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bomb[i][j] == true) {
                    System.out.print(".");
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        R = scanner.nextInt();
        C = scanner.nextInt();
        N = scanner.nextInt();
        arr = new String [R][C];
        bomb = new boolean[R][C];
        bomb2 = new boolean[R][C];
        bomb3 = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String tmp = scanner.next();
            for (int j = 0; j < C; j++) {
                arr[i][j] = String.valueOf(tmp.charAt(j));
                bomb3[i][j] = true;
                if (String.valueOf(tmp.charAt(j)).equals("O")) {
                    bomb[i][j] = true;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bomb[i][j] == true) {
                    bomb2[i][j] = true;
                    for (int k = 0; k < 4; k++) {
                        int cx = i + dx[k];
                        int cy = j + dy[k];
                        if (cx >= 0 && cy >= 0 && cx < R && cy < C) {
                            bomb2[cx][cy] = true;
                        }
                    }
                }
            }
        }
        if (N == 1) {
            print(bomb);
            return;
        } else if (N == 2) {
            print(bomb3);
            return;
        } else if (N == 3) {
            reversePrint(bomb2);
            return;
        } else if (N == 5) {
            print(bomb3);
            return;
        }
        else if (N % 2 == 0) {
            print(bomb3);
            return;
        } else if (N % 2 == 1 && N / 2 % 2 == 1) {
            reversePrint(bomb2);
            return;
        } else {
            print(bomb);
            return;
        }
    }
}