import java.util.*;

class Solution
{
    static class Position {
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class Mod {
        public int time;
        public String direction;

        public Mod(int time, String direction) {
            this.time = time;
            this.direction = direction;
        }
    }

    public static int N;
    public static int K;
    public static int L;
    public static Mod [] mods;
    public static int [][] arr;
    public static Queue<Position> tail = new LinkedList<>();

    public static Position changeDirection(int x, int y, String direction) {
        int cX = 0;
        int cY = 0;
        if (direction.equals("D")) {
            if (x == -1 && y == 0) {
                cX = 0;
                cY = 1;
            }
            if (x == 1 && y == 0) {
                cX = 0;
                cY = -1;
            }
            if (x == 0 && y == 1) {
                cX = 1;
                cY = 0;
            }
            if (x == 0 && y == -1) {
                cX = -1;
                cY = 0;
            }
        }
        if (direction.equals("L")) {
            if (x == -1 && y == 0) {
                cX = 0;
                cY = -1;
            }
            if (x == 1 && y == 0) {
                cX = 0;
                cY = 1;
            }
            if (x == 0 && y == 1) {
                cX = -1;
                cY = 0;
            }
            if (x == 0 && y == -1) {
                cX = 1;
                cY = 0;
            }
        }
        return new Position(cX, cY);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        arr = new int[N+1][N+1];
        K = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < K; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            scanner.nextLine();
            arr[x][y] = 1;
        }
        L = Integer.parseInt(scanner.nextLine());
        mods = new Mod[L];
        for (int i = 0; i < L; i++) {
            int time = scanner.nextInt();
            String direction = scanner.next();
            scanner.nextLine();
            mods[i] = new Mod(time, direction);
        }
        int count = 0;
        boolean check = false;
        int pX = 0;
        int pY = 1;
        int startX = 1;
        int startY = 1;
        for (int i = 0; i < L; i++) {
            for (int j = count; j < mods[i].time; j++) {
                startX = startX + pX;
                startY = startY + pY;
                count++;
                if (startX <= N && startY <= N && startX >= 1 && startY >= 1) {
                    if (tail.contains(new Position(startX, startY))) {
                        check = true;
                        break;
                    }
                    if (arr[startX][startY] == 1) {
                        tail.add(new Position(startX - pX, startY - pY));
                        arr[startX][startY] = 0;
                    } else {
                        tail.add(new Position(startX - pX, startY - pY));
                        tail.poll();
                    }
                } else {
                    check = true;
                    break;
                }
            }
            Position position = changeDirection(pX, pY, mods[i].direction);
            pX = position.x;
            pY = position.y;
            if (check == true) {
                break;
            }
        }
        while (check != true) {
            startX = startX + pX;
            startY = startY + pY;
            count++;
            if (startX <= N && startY <= N && startX >= 1 && startY >= 1) {
                if (tail.contains(new Position(startX, startY))) {
                    check = true;
                    break;
                }
                if (arr[startX][startY] == 1) {
                    tail.add(new Position(startX - pX, startY - pY));
                } else {
                    tail.add(new Position(startX - pX, startY - pY));
                    tail.poll();
                }
            } else {
                check = true;
                break;
            }

        }
        System.out.println(count);
    }
}


