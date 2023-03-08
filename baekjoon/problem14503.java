import java.util.Scanner;

class main {

    public static int N;
    public static int M;
    public static int [][] arr;
    public static int [] dx = {1, -1, 0, 0};
    public static int [] dy = {0, 0, -1, 1};
    public static int count = 0;

    public static boolean check(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if (cx >= 0 && cx < N && cy >= 0 && cy < M) {
                if (arr[cx][cy] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void find(int x, int y, int d) {
        if (arr[x][y] == 0) {
            arr[x][y] = 3;
            count++;
        }
        // 0 (-1, 0)
        // 1 (0, 1)
        // 2 (1, 0)
        // 3 (0, -1)
        // 0북 (-1 ,0) 3서 (0, -1) 2남 (1, 0) 1동 (0, 1)
        if (check(x, y)) {
            if (d == 0) {
                d = 3;
                if (y - 1 >= 0 && y - 1 < M) {
                    if (arr[x][y-1] == 0) {
                        find(x, y-1, d);
                    } else {
                        find(x, y, d);
                    }
                }
            } else if (d == 1) {
                d = 0;
                if (x - 1 >= 0 && x - 1 < N) {
                    if (arr[x-1][y] == 0) {
                        find(x-1, y, d);
                    } else {
                        find(x, y, d);
                    }
                }
            } else if (d == 2) {
                d = 1;
                if (y + 1 >= 0 && y + 1 < M) {
                    if (arr[x][y+1] == 0) {
                        find(x, y+1, d);
                    } else {
                        find(x, y, d);
                    }
                }
            } else if (d == 3) {
                d = 2;
                if (x + 1 >= 0 && x + 1 < N) {
                    if (arr[x+1][y] == 0) {
                        find(x+1, y, d);
                    } else {
                        find(x, y, d);
                    }
                }
            }
            // 0북 (-1 ,0) 3서 (0, -1) 2남 (1, 0) 1동 (0, 1)
        } else {
            if (d == 0) {
                if (x + 1 >= 0 && x + 1 < N) {
                    if (arr[x + 1][y] == 0 || arr[x+1][y] == 3) {
                        find(x + 1, y, d);
                    }
                } else {
                    return;
                }
            } else if (d == 1) {
                if (y - 1 >= 0 && y - 1 < M) {
                    if (arr[x][y - 1] == 0 || arr[x][y-1] == 3) {
                        find(x, y - 1, d);
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else if (d == 2) {
                if (x - 1 >= 0 && x - 1 < N) {
                    if (arr[x - 1][y] == 0 || arr[x - 1][y] == 3) {
                        find(x - 1, y, d);
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else if (d == 3) {
                if (y + 1 >= 0 && y + 1 < M) {
                    if (arr[x][y + 1] == 0 || arr[x][y+1] == 3) {
                        find(x, y + 1, d);
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }


    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int d = scanner.nextInt();

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        find(x, y, d);
        System.out.println(count);
    }

    // 0 (-1, 0)
    // 1 (0, 1)
    // 2 (1, 0)
    // 3 (0, -1)
    // 0북 (-1 ,0) 3서 (0, -1) 2남 (1, 0) 1동 (0, 1)

    // 아직 칸이 청소 X = 청소
    // 주변 4칸 중 청소 X 는

}