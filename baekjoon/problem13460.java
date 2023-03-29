import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    private static int N;
    private static int M;
    private static char [][] arr;
    private static Node blue;
    private static Node red;
    private static int MIN = Integer.MAX_VALUE;
    private static int [] dx = {0, 0, 1, -1};
    private static int [] dy = {1, -1, 0, 0};

    public static class Node {
        public int x;
        public int y;
        public boolean result = false;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean check(int i, int rx, int ry, int bx, int by) {
        if (i == 0) {
            if (rx == bx) {
                if (ry < by) {
                    return true; // red / blue
                } else {
                    return false;
                }
            } else {
                return false; // false일 경우 red 먼저 움직이자
            }
        } else if (i == 1) {
            if (rx == bx) {
                if (ry < by) {
                    return false; // red / blue
                } else {
                    return true;
                }
            } else {
                return true; // false일 경우 red 먼저 움직이자
            }
        } else if (i == 2) {
            if (ry == by) {
                if (rx < bx) {
                    return true; // red / blue
                } else {
                    return false;
                }
            } else {
                return true; // false일 경우 red 먼저 움직이자
            }
        } else {
            if (ry == by) {
                if (rx < bx) {
                    return false; // red / blue
                } else {
                    return true;
                }
            } else {
                return false; // false일 경우 red 먼저 움직이자
            }
        }
    }

    public static Node go(int i, String type, int x, int y, int cX, int cY) {
        while(true) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (arr[x + dx[i]][y + dy[i]] == 'O') {
                Node node = new Node(x + dx[i], y + dy[i]);
                node.result = true;
                return node;
            } else if (xx == cX && yy == cY ) {
                return new Node(x, y);
            } else if (arr[xx][yy] == '#'){
                return new Node(x, y);
            } else {
                x = xx;
                y = yy;
            }
        }
    }

    public static void play(int count, int rx, int ry, int bx, int by) {
        if (count > 10) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            boolean result = check(i, rx, ry, bx, by); //false red 먼저
            Node mBlue;
            Node mRed;

            if (result) {
                mBlue = go(i, "blue", bx, by, 0, 0);
                mRed = go(i, "red", rx, ry, mBlue.x, mBlue.y);
            } else {
                mRed = go(i, "red", rx, ry, 0, 0);
                mBlue = go(i, "blue", bx, by, mRed.x, mRed.y);
            }
            if (mRed.result == true && mBlue.result != true) {
                MIN = Math.min(count, MIN);
                return;
            } else if (mBlue.result != true){
                play(count + 1, mRed.x, mRed.y, mBlue.x, mBlue.y);
            }

        }
    }

    public static void play2(int [] i, int count, int rx, int ry, int bx, int by) {
        if (count > 10) {
            return;
        }

        boolean result = check(i[count-1], rx, ry, bx, by); //false red 먼저
        Node mBlue;
        Node mRed;

        if (result) {
            mBlue = go(i[count-1], "blue", bx, by, 0, 0);
            mRed = go(i[count-1], "red", rx, ry, mBlue.x, mBlue.y);
        } else {
            mRed = go(i[count-1], "red", rx, ry, 0, 0);
            mBlue = go(i[count-1], "blue", bx, by, mRed.x, mRed.y);
        }
        if (mBlue.result == true) {
            return;
        } else if (mRed.result == true && mBlue.result) {
            return;
        } else if (mRed.result == true && mBlue.result != true) {
            MIN = Math.min(count, MIN);
            return;
        } else {
            System.out.println(mRed.x + " " + mRed.y+ " " + mBlue.x+ " " + mBlue.y);
            play2(i,count + 1, mRed.x, mRed.y, mBlue.x, mBlue.y);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String [] firstInputs = bf.readLine().split(" ");
        N = Integer.parseInt(firstInputs[0]);
        M = Integer.parseInt(firstInputs[1]);
        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = bf.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j);
                if (arr[i][j] == 'B') {
                    blue = new Node(i, j);
                } else if (arr[i][j] == 'R') {
                    red = new Node(i, j);
                }
            }
        }

        play(1, red.x, red.y, blue.x, blue.y);
        //int [] list = {0, 3, 0, 2, 1, 2, 1};
        //play2(list,1, red.x, red.y, blue.x, blue.y);
        if (MIN == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(MIN);
        }
    }
}