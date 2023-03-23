import java.util.*;

class Main {
    public static int N;
    public static int K;
    public static int [][] arr; // 0 흰색 / 1 빨 / 2 파
    public static int [][] hingPosition; // 0 흰색 / 1 빨 / 2 파
    public static List<Hing> hings = new ArrayList<>();

    public static class Hing {
        public Queue<Hing> carryOn = new LinkedList<>();
        public int idx;
        public int x;
        public int y;
        public int direction;

        public Hing(int idx, int x, int y, int direction) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    public static Hing getHing(int idx) {
        for (int i = 0; i < hings.size(); i++) {
            if (hings.get(i).idx == idx) {
                return hings.get(i);
            }
        }
    }
    // 이동하려는 칸 = 흰색 (이동), 말 있을시 (위에 올림)
    // A위에 말 -> 같이 AB -> DE => DEAB

    // 빨간색 -> 이동하려는 칸 말 X 순서 반대로 AB -> BA, 있을시 ABC -> DE => DECBA
    // 파란색 -> 방향 바꾸고 한칸 이동 (바꾼후 파란색이면 가만히 있는다)
    public static void play() {
        while (true) {
            for (int i = 0; i < hings.size(); i++) {
                Hing hing = hings.get(i);
                if (hing.direction == 1) {
                    if (hing.carryOn.size() == 0) {
                        if (hing.y + 1 < N) {
                            if (arr[hing.x][hing.y + 1] == 0) {
                                hing.y = hing.y + 1;
                                if (hingPosition[hing.x][hing.y] != 0) {
                                    Hing getHing = getHing(hingPosition[hing.x][hing.y]);
                                    getHing.carryOn.add(hing);
                                }
                            } else if (arr[hing.x][hing.y + 1] == 1) {

                            } else if (arr[hing.x][hing.y + 1] == 2) {

                            }
                        }
                    } else {
                        while(!hing.carryOn.isEmpty()) {
                            Hing poll = hing.carryOn.poll();
                            if (poll.y + 1 < N) {
                                poll.y = poll.y + 1;
                                if (hingPosition[poll.x][poll.y] != 0) {
                                    Hing getHing = getHing(hingPosition[poll.x][poll.y]);
                                    while(!poll.carryOn.isEmpty()) {
                                        Hing poll1 = poll.carryOn.poll();
                                        poll1.y = poll1.y+1;
                                        getHing.carryOn.add(poll1);
                                    }
                                }
                            }
                        }
                    }
                } else if (hing.direction == 2) {

                } else if (hing.direction == 3) {

                } else if (hing.direction == 4) {

                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        arr = new int [N][N];
        hingPosition = new int[N][N];
        for (int i = 0; i < N; i++) {
            String tmp = scanner.next();
            String[] s = tmp.split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(s[i]);
            }
        }
        // 1 -> 2 <- 3 위 4 아래
        for (int i = 0; i < K; i++) {
            Hing hing = new Hing(i+1, scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            hings.add(hing);
            hingPosition[hing.x][hing.y] = hing.idx;
        }

        play();
    }
}
