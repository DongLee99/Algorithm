import java.util.*;

class Main {

    public static int R;
    public static int C;
    public static int M;
    public static Sea [][] arr;
    public static Queue<Shark> sharks = new LinkedList<>();
    public static int KingY = 1;
    public static int answer = 0;

    public static class Shark implements Comparable<Shark>{
        public int r;
        public int c;
        public int s;
        public int d;
        public int z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r; //상어 x
            this.c = c; //상어 y
            this.s = s; //속력
            this.d = d; //이동 방향 1 위 2 아래 3 오른쪽 4 왼쪽
            this.z = z; //크기 z
        }

        public Shark() {
        }

        @Override
        public int compareTo(Shark o) {
            return o.z - this.z;
        }
    }
    public static void checkSharks(int r, int c) {
        Sea sea = arr[r][c];
        if (sea.sharks.size() > 1) {
            Shark poll = sea.sharks.poll();
            while(!sea.sharks.isEmpty()) {
                sea.sharks.poll();
            }
            sea.sharks.add(poll);
        }
    }

    public static class Sea {
        public int Max;
        public PriorityQueue<Shark> sharks = new PriorityQueue<>();

        public Sea(int max, PriorityQueue<Shark> sharks) {
            Max = max;
            this.sharks = sharks;
        }
    }

    public static void eatShark() {
        sharks = new LinkedList<>();
//        System.out.println("먹으러 옴");
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (arr[i][j].sharks.size() > 1) {
//                    System.out.println("먹이 존재");
                    Shark poll = arr[i][j].sharks.poll();
//                    System.out.println("승자" + poll.z);
                    arr[i][j].sharks = new PriorityQueue<>();
                    arr[i][j].sharks.add(poll);
                    sharks.add(poll);
                } else if (arr[i][j].sharks.size() == 1) {
                    sharks.add(arr[i][j].sharks.peek());
                }
            }
        }
    }
    public static void catchShark() {
        int MIN = Integer.MAX_VALUE;
        Shark tmpShark = new Shark();
        for (Shark shark : sharks) {
            if (shark.c == KingY) {
                if (shark.r < MIN) {
                    MIN = shark.r;
                    tmpShark = shark;
                }
            }
        }
//        System.out.println("잡기전 = " + sharks.size());
        if (MIN != Integer.MAX_VALUE) {
            answer += tmpShark.z;
            sharks.remove(tmpShark);
        }

//        System.out.println("잡은후 = " + sharks.size());
    }
    public static void moveShark() {
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                arr[i][j] = new Sea(0, new PriorityQueue<>());
            }
        }
//        System.out.println("상어 마리 " + sharks.size());
        //이동 방향 1 위 2 아래 3 오른쪽 4 왼쪽
        for (Shark shark : sharks) {
            if (shark.d == 1) {
                upDownShark(shark, false);
            } else if (shark.d == 2) {
                upDownShark(shark, true);
            } else if (shark.d == 3) {
                leftRightShark(shark, true);
            } else if (shark.d == 4) {
                leftRightShark(shark, false);
            }
        }
    }

    private static void leftRightShark(Shark shark, boolean reverse) {
//        System.out.println("움직전" + shark.r + "   " + shark.c + shark.d + "   " + "  " + shark.s);
        for (int i = 0; i < shark.s; i++) {
            if (reverse == false) {
                if (shark.c == 1) {
                    reverse = true;
                }
            }
            if (reverse == true) {
                if (shark.c == C) {
                    reverse = false;
                }
            }
            if (reverse == false) {
                if (shark.c - 1 > 1) {
                    --shark.c;
                } else if (shark.c - 1 == 1) {
                    --shark.c;
                    //reverse = true;
                }
            } else {
                if (shark.c + 1 < C) {
                    ++shark.c;
                } else if (shark.c + 1 == C) {
                    ++shark.c;
                    //reverse = false;
                }
            }
        }
        if (reverse == true) {
            shark.d = 3;
            arr[shark.r][shark.c].sharks.add(shark);
        } else {
            shark.d = 4;
            arr[shark.r][shark.c].sharks.add(shark);
        }
//        System.out.println(shark.r + "   " + shark.c + "  " + shark.d);
    }

    private static void upDownShark(Shark shark, boolean reverse) {
//        System.out.println("움직전" + shark.r + "   " + shark.c + "  " + shark.d + "   " + shark.s);

        for (int i = 0; i < shark.s; i++) {
            if (reverse == false) {
                if (shark.r == 1) {
                    reverse = true;
                }
            }
            if (reverse == true) {
                if (shark.r == R) {
                    reverse = false;
                }
            }
            if (reverse == false) {
                if (shark.r - 1 > 1) {
                    --shark.r;
                } else if (shark.r - 1 == 1) {
                    --shark.r;
                    //reverse = true;
                }
            } else {
                if (shark.r + 1 < R) {
                    ++shark.r;
                } else if (shark.r + 1 == R) {
                    ++shark.r;
                    //reverse = false;
                }
            }
        }
        if (reverse == true) {
            shark.d = 2;
            arr[shark.r][shark.c].sharks.add(shark);
        } else {
            shark.d = 1;
            arr[shark.r][shark.c].sharks.add(shark);
        }
//        System.out.println(shark.r + "   " + shark.c + " " + shark.d);
    }

    public static void play() {
        for (int i = 0; i < C; i++) {
            catchShark();
//            for (int j = 1; j <= R; j++) {
//                for (int k = 1; k <= C; k++) {
//                    Sea sea = arr[j][k];
//                    System.out.print(sea.sharks.size() + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("이전 꿈틀 꿈틀");
            moveShark();
            eatShark();
//            for (int j = 1; j <= R; j++) {
//                for (int k = 1; k <= C; k++) {
//                    Sea sea = arr[j][k];
//                    System.out.print(sea.sharks.size() + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("꿈틀 꿈틀");
            KingY++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        R = scanner.nextInt();
        C = scanner.nextInt();
        M = scanner.nextInt();
        arr = new Sea[R+1][C+1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                arr[i][j] = new Sea(0, new PriorityQueue<>());
            }
        }
        for (int i = 0; i < M; i++) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int s = scanner.nextInt();
            int d = scanner.nextInt();
            int z = scanner.nextInt();
            sharks.add(new Shark(r, c, s, d, z));
            arr[r][c].sharks.add(new Shark(r, c, s, d, z));
        }
        play();
        System.out.println(answer);
    }
}

