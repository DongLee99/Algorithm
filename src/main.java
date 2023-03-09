import java.util.*;

class main {

    public static int N;
    public static int M;
    public static int [][] arr;
    public static int [][] copyArr;
    public static boolean [][] visited;
    public static int [] bruteForce;
    public static List<CCTV> cctvs = new LinkedList<>();
    public static int [] dx = {-1, 0, 1, 0};
    public static int [] dy = {0, 1, 0 ,-1};
    public static int MAX = Integer.MAX_VALUE;

    public static class CCTV {
        public int num;
        public int x;
        public int y;

        CCTV(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    public static void getBlindSpot() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyArr[i][j] == 0) {
                    count++;
                }
            }
        }

        MAX = Math.min(count, MAX);
    }

    public static void find(int count) {
        if (count == cctvs.size()) {
            copyArr = new int[N][M];
            for (int i = 0; i < N; i++) {
                System.arraycopy(arr[i], 0, copyArr[i], 0, arr[i].length);
            }
            for (int i = 0; i < cctvs.size(); i++) {
                direction(cctvs.get(i), bruteForce[i]);
            }
            getBlindSpot();
            return;
        }
        for (int i = 0; i < 4; i++) {
            bruteForce[count] = i;
            find(count + 1);
        }
    }

    public static void direction(CCTV cctv, int direction) {
        int cctvNum = cctv.num;
        if (cctvNum == 1) {
            if (direction == 0) {
                watch(cctv, 0);
            } else if (direction == 1) {
                watch(cctv, 1);
            } else if (direction == 2) {
                watch(cctv, 2);
            } else if (direction == 3) {
                watch(cctv, 3);
            }
        } else if (cctvNum == 2) {
            if (direction == 0 || direction == 2) {
                watch(cctv, 0);
                watch(cctv, 2);
            } else {
                watch(cctv, 1);
                watch(cctv, 3);
            }
        } else if(cctvNum == 3) {
            if(direction == 0) {
                watch(cctv, 0); // 상우
                watch(cctv, 1);
            } else if(direction == 1) {
                watch(cctv, 1); // 우하
                watch(cctv, 2);
            } else if(direction == 2) {
                watch(cctv, 2); // 하좌
                watch(cctv, 3);
            } else if(direction == 3) {
                watch(cctv, 0); // 좌상
                watch(cctv, 3);
            }
        } else if(cctvNum == 4) {
            if(direction == 0) {
                watch(cctv, 0); // 좌상우
                watch(cctv, 1);
                watch(cctv, 3);
            } else if(direction == 1) {
                watch(cctv, 0); // 상우하
                watch(cctv, 1);
                watch(cctv, 2);
            } else if(direction == 2) {
                watch(cctv, 1); // 좌하우
                watch(cctv, 2);
                watch(cctv, 3);
            } else if(direction == 3) {
                watch(cctv, 0); // 상좌하
                watch(cctv, 2);
                watch(cctv, 3);
            }
        } else if(cctvNum == 5) { // 상우하좌
            watch(cctv, 0);
            watch(cctv, 1);
            watch(cctv, 2);
            watch(cctv, 3);
        }
    }

    public static void watch(CCTV cctv, int d) {
        Queue<CCTV> queue = new LinkedList<>();
        boolean [][] visited = new boolean[N][M];
        queue.add(cctv);
        visited[cctv.x][cctv.y] = true;
        while(!queue.isEmpty()) {
            int nx = queue.peek().x + dx[d];
            int ny = queue.poll().y + dy[d];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M || copyArr[nx][ny] == 6) {
                break;
            }

                if (copyArr[nx][ny] == 0) {
                    copyArr[nx][ny] = -1;
                    queue.add(new CCTV(cctv.num, nx, ny));
                } else {
                    queue.add(new CCTV(cctv.num, nx, ny));
                }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = scanner.nextInt();
                if (arr[i][j] != 0 && arr[i][j] != 6) {
                    cctvs.add(new CCTV(arr[i][j], i, j));
                }
            }
        }
        int [][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        bruteForce = new int[cctvs.size()];
        find(0);
        System.out.println(MAX);
    }

    // 1번 ->
    // 2번 <- ->
    // 3번 ^->
    // 4번 < ^ >
    // 5번 4방향
}

