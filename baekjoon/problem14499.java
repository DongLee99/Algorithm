import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class main {
    public static int N;
    public static int M;

    public static Dice dice;
    public static int [][] arr;
    public static class Dice {
        public int bottom;
        public int top;
        public int west;
        public int east;
        public int south;
        public int north;
        public Dice(int bottom, int top, int west, int east, int south, int north) {
            this.bottom = bottom;
            this.top = top;
            this.west = west;
            this.east = east;
            this.south = south;
            this.north = north;
        }
    }

    public static int changeDice(int value, int x, int y) {
        int bottom = dice.bottom;
        int top = dice.top;
        int west = dice.west;
        int east = dice.east;
        int south = dice.south;
        int north = dice.north;
        if (value == 1) {
            if (arr[x][y] == 0) {
                arr[x][y] = east;
                dice.west = bottom;
                dice.bottom = east;
                dice.east = top;
                dice.top = west;
            } else {
                dice.west = bottom;
                dice.bottom = arr[x][y];
                dice.east = top;
                dice.top = west;
                arr[x][y] = 0;
            }
        }
        if (value == 2) {
            if (arr[x][y] == 0) {
                arr[x][y] = west;
                dice.west = top;
                dice.bottom = west;
                dice.east = bottom;
                dice.top = east;
            } else {
                dice.west = top;
                dice.bottom = arr[x][y];
                dice.east = bottom;
                dice.top = east;
                arr[x][y] = 0;
            }
        }
        if (value == 3) {
            if (arr[x][y] == 0) {
                arr[x][y] = north;
                dice.top = south;
                dice.bottom = north;
                dice.north = top;
                dice.south = bottom;
            } else {
                dice.top = south;
                dice.bottom = arr[x][y];
                dice.north = top;
                dice.south = bottom;
                arr[x][y] = 0;
            }
        }
        if (value == 4) {
            if (arr[x][y] == 0) {
                arr[x][y] = south;
                dice.top = north;
                dice.bottom = south;
                dice.north = bottom;
                dice.south = top;
            } else {
                dice.top = north;
                dice.bottom = arr[x][y];
                dice.north = bottom;
                dice.south = top;
                arr[x][y] = 0;
            }
        }
        //System.out.println("north " + dice.north + "top " + dice.top + "bottom " + dice.bottom + "west " + dice.west + "east" + dice.east + "south" + dice.south);
        return dice.top;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int k = scanner.nextInt();
        dice = new Dice(0,0,0,0,0,0);
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < k; i++) {
            int value = scanner.nextInt();
            if (value == 1) {
                if (y + 1 >= 0 && y + 1 < M) {
                    System.out.println(changeDice(value, x, y + 1));
                    y = y + 1;
                } else {
                    continue;
                }
            }
            if (value == 2) {
                if (y - 1 >= 0 && y - 1 < M) {
                    System.out.println(changeDice(value, x, y - 1));
                    y = y - 1;
                } else {
                    continue;
                }
            }
            if (value == 3) {
                if (x - 1 >= 0 && x - 1 < N) {
                    System.out.println(changeDice(value, x - 1, y));
                    x = x - 1;
                } else {
                    continue;
                }
            }
            if (value == 4) {
                if (x + 1 >= 0 && x + 1 < N) {
                    System.out.println(changeDice(value, x + 1, y));
                    x = x + 1;
                } else {
                    continue;
                }
            }
        }
    }
    // N 세로
    // M 가로
    // x, y 주사위를 놓은 곳
    // k 명령의 개수
    // 동쪽 1, 서쪽 2, 북쪽 3, 남쪽 4
}