import java.util.*;

class Main {

    public static int R;
    public static int C;
    public static int T;
    public static int [][] arr;
    public static int [] dx = {0, 0, 1, -1};
    public static int [] dy = {1, -1, 0, 0};
    public static int X1 = 0;
    public static int Y1 = 0;
    public static int X2 = 0;
    public static int Y2 = 0;
    public static Queue<Node> trash = new LinkedList<>();

    public static class Node {
        public int x;
        public int y;
        public int value;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    public static void spread() {
        Queue<Node> queue = new LinkedList<>();

        while(!trash.isEmpty()) {
            Node node = trash.poll();
            if (node.value < 5) {
                continue;
            }
            int spreadValue = node.value / 5;
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int cx = node.x + dx[i];
                int cy = node.y + dy[i];
                if (cx == X1 && cy == Y1) {
                    continue;
                } else if (cx == X2 && cy == Y2) {
                    continue;
                } else if (cx > 0 && cx <= R && cy > 0 && cy <= C) {
                    arr[cx][cy] = arr[cx][cy] + spreadValue;
                    count++;
                }
            }
            arr[node.x][node.y] = arr[node.x][node.y] - (spreadValue * count);
        }
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (arr[i][j] != -1 && arr[i][j] != 0) {
                    trash.add(new Node(i, j, arr[i][j]));
                }
            }
        }
    }
    public static void clear() {
        Queue<Node> tmp = new LinkedList<>();
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (i == 1) {
                    tmp.add(new Node(i, j, arr[i][j]));
                    continue;
                } else if (i == R) {
                    tmp.add(new Node(i, j, arr[i][j]));
                    continue;
                } else if (j == 1) {
                    tmp.add(new Node(i, j, arr[i][j]));
                    continue;
                } else if (j == C) {
                    tmp.add(new Node(i, j, arr[i][j]));
                    continue;
                } else if (i == X1) {
                    tmp.add(new Node(i, j, arr[i][j]));
                    continue;
                } else if (i == X2) {
                    tmp.add(new Node(i, j, arr[i][j]));
                    continue;
                }
            }
        }
        System.out.println(tmp.size());
        for (Node node : tmp) {
            if (node.x == X1) { // - 부분
                if (node.y + 1 <= C) {
                    node.y = node.y + 1;
                } else {
                    if (node.x - 1 > 0) {
                        node.x = node.x - 1;
                    }
                }
            } else if (node.x == X2) { // - 부분
                if (node.y + 1 <= C) {
                    node.y = node.y + 1;
                } else {
                    if (node.x + 1 <= R) {
                        node.x = node.x + 1;
                    }
                }
            } else if (node.x <= X1) { // | 부분
                if (node.y == C) {
                    if (node.x - 1 > 0) { // 위로
                        node.x = node.x -1;
                    } else {
                        if (node.y - 1 > 0) { // <-
                            node.y = node.y - 1;
                        }
                    }
                } else if (node.x == 1) {
                    if (node.y - 1 > 0) { // <-
                        node.y = node.y - 1;
                    } else {
                        if (node.x + 1 <= X1) { // 아래
                            node.x = node.x + 1;
                        }
                    }
                } else if (node.y == 1) {
                    if (node.x + 1 <= X1) {
                        node.x = node.x + 1;
                    }
                }
            } else if (node.x >= X2) {
                if (node.y == C) {
                    if (node.x + 1 <= R) { // 아래
                        node.x = node.x + 1;
                    } else {
                        if (node.y - 1 > 0) { // <-
                            node.y = node.y - 1;
                        }
                    }
                } else if (node.x == R) {
                    if (node.y - 1 > 0) { // <-
                        node.y = node.y - 1;
                    } else {
                        if (node.x -1 >= X2) { // 아래
                            node.x = node.x - 1;
                        }
                    }
                } else if (node.y == 1) {
                    if (node.x - 1 >= X2) {
                        node.x = node.x -1;
                    }
                }
            }
        }
        while(!tmp.isEmpty()) {
            Node poll = tmp.poll();
            if (poll.value < 0) {
                continue;
            } else {
                arr[poll.x][poll.y] = poll.value;
            }
        }
        arr[X1][Y1] = -1;
        arr[X1][2] = 0;
        arr[X2][Y2] = -1;
        arr[X2][2] = 0;
        trash = new LinkedList<>();
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (arr[i][j] != -1 && arr[i][j] != 0) {
                    trash.add(new Node(i, j, arr[i][j]));
                }
            }
        }
    }


    public static void play(int T) {
        for (int i = 0; i < T; i++) {
            spread();
            System.out.println("시작");
            for (int j = 1; j <= R; j++) {
                for (int k = 1; k <= C; k++) {
                    System.out.print(arr[j][k] + " ");
                }
                System.out.println();
            }
            clear();
            System.out.println("===================");
            for (int j = 1; j <= R; j++) {
                for (int k = 1; k <= C; k++) {
                    System.out.print(arr[j][k] + " ");
                }
                System.out.println();
            }

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        R = scanner.nextInt();
        C = scanner.nextInt();
        T = scanner.nextInt();
        arr = new int[R + 1][C + 1];
        int count = 0;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                int input = scanner.nextInt();
                if (input == -1) {
                    if (count == 0) {
                        X1 = i;
                        Y1 = j;
                        count++;
                        arr[i][j] = -1;
                    } else {
                        X2 = i;
                        Y2 = j;
                        arr[i][j] = -1;
                    }
                } else if (input > 0) {
                    arr[i][j] = input;
                    trash.add(new Node(i, j, input));
                }
            }
        }
        play(T);
        int answer = 0;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (arr[i][j] > 0) {
                    answer = answer + arr[i][j];
                }
            }
        }
        System.out.println(answer);
    }

    // 공기 청정기 항상 1열 y = 1 ( x 두칸씩)
    // 미세먼지 확산 인접 4칸
    // 확산 되는 양 (r,c) / 5
    // 남은 양 (r, c) - ((r, c)/5) * 확산된 양

    // 메서드 공기 확산
    // 청소기 on
}

