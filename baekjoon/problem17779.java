import java.util.Scanner;

class Main {

    public static int [][] arr;
    public static int N;
    public static int MIN = Integer.MAX_VALUE;

    public static void makeArea(int x, int y, int d1, int d2) {
        int [][] tmpArr = new int[N+1][N+1];
        int count = 0;
        for (int i = x; i <= x+d1; i++) {
            tmpArr[i][y-count] = 5;
            count++;
        } // 2, 4, 2, 2 (4, 2) 왼쪽 /
        count = 0;
        for (int i = x; i <= x+d2; i++) {
            tmpArr[i][y+count] = 5;
            count++;
        } // 2, 4, 2, 2 (4, 6) 아래 \ 아래
        count = 0;
        for (int i = x + d1; i <= x+d1+d2; i++) {
            tmpArr[i][y-d1+count] = 5;
            count++;
        } // 2, 4, 2, 2 (6, 4) 오른 \ 아래
        count = 0;
        for (int i = x + d2; i <= x+d1+d2; i++) {
            tmpArr[i][y+d2-count] = 5;
            count++;
        } // 2, 4, 2, 2 (6, 4) / 아래
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(tmpArr[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        int count1 = 0;
        boolean [][] visited = new boolean[N+1][N+1];
        for (int i = 1; i < x + d1; i++) {
            for (int j = 1; j <= y; j++) {
                if (tmpArr[i][j] == 5) {
                    break;
                } else {
                    visited[i][j] = true;
                    count1 = count1 + arr[i][j];
                }
            }
        }

        int count2 = 0;
        for (int i = x+d1; i <= N; i++) {
            for (int j = 1; j < y -d1 + d2; j++) {
                if (tmpArr[i][j] == 5) {
                    break;
                } else {
                    visited[i][j] = true;
                    count2 = count2 + arr[i][j];
                }
            }
        }
        int count3 = 0;
        for (int i = x+d2 + 1; i <= N; i++) {
            for (int j = N; j >= y -d1 + d2; j--) {
                if (tmpArr[i][j] == 5) {
                    break;
                } else {
                    visited[i][j] = true;
                    count3 = count3 + arr[i][j];
                }
            }
        }
        int count4 = 0;
        for (int i = 1; i <= x + d2; i++) {
            for (int j = N; j > y; j--) {
                if (tmpArr[i][j] == 5) {
                    break;
                } else {
                    visited[i][j] = true;
                    count4 = count4 + arr[i][j];
                }
            }
        }
        int count5 = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (visited[i][j] == false) {
                    count5 = count5 + arr[i][j];
                }
            }
        }
        int cMax = Math.max(count1, Math.max(count2, Math.max(count3, Math.max(count4, count5))));
        int cMin = Math.min(count1, Math.min(count2, Math.min(count3, Math.min(count4, count5))));
        MIN = Math.min(MIN, cMax - cMin);
    }

    public static void makeDD(int x, int y) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int xdd = x + i + j;
                int yd1 = y - i;
                int yd2 = y + j;
                if (xdd <= N && 1 <= yd1 && yd1 < y && y < yd2 && yd2 <= N) {
                    makeArea(x, y, i, j);
                }
            }
        }
    }
    public static void makeXY() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                makeDD(i, j);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        makeXY();
        System.out.println(MIN);
    }
}
