class Solution {
    public static int [] dx = {1, -1, 0, 0};
    public static int [] dy = {0, 0, -1, 1};
    public static char [][] arr;
    public static int N = 0;
    public static int M = 0;
    public static int startX = 0;
    public static int startY = 0;

    public static void go(String direction, int count) {
        int cx = startX;
        int cy = startY;
        if (direction.equals("E")) {
            boolean check = false;
            for (int i = 0; i < count; i++) {
                cy = cy + 1;
                if (cy >= 0 && cy < M) {
                    if (arr[cx][cy] != 'X') {
                        continue;
                    }  else {
                        check = true;
                        break;
                    }
                } else {
                    check = true;
                    break;
                }
            }
            if (!check) {
                startX = cx;
                startY = cy;
            }
        } else if (direction.equals("W")) {
            boolean check = false;
            for (int i = 0; i < count; i++) {
                cy = cy - 1;
                if (cy >= 0 && cy < M) {
                    if (arr[cx][cy] != 'X') {
                        continue;
                    }  else {
                        check = true;
                        break;
                    }
                } else {
                    check = true;
                    break;
                }
            }
            if (!check) {
                startX = cx;
                startY = cy;
            }
        } else if (direction.equals("S")) {
            boolean check = false;
            for (int i = 0; i < count; i++) {
                cx = cx + 1;
                if (cx >= 0 && cx < M) {
                    if (arr[cx][cy] != 'X') {
                        continue;
                    } else {
                        check = true;
                        break;
                    }
                } else {
                    check = true;
                    break;
                }
            }
            if (!check) {
                startX = cx;
                startY = cy;
            }
        } else if (direction.equals("N")) {
            boolean check = false;
            for (int i = 0; i < count; i++) {
                cx = cx - 1;
                if (cx >= 0 && cx < M) {
                    if (arr[cx][cy] != 'X') {
                        continue;
                    } else {
                        check = true;
                        break;
                    }
                } else {
                    check = true;
                    break;
                }
            }
            if (!check) {
                startX = cx;
                startY = cy;
            }
        }
    }

    public int[] solution(String[] park, String[] routes) {
        N = park.length;
        M = park[0].length();
        arr = new char [N][M];
        for (int i = 0; i < N; i++) {
            String tmp = park[i];
            for (int j = 0; j < M; j++) {
                arr[i][j] = tmp.charAt(j);
                if (arr[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
            }
        }
        for (int i = 0; i < routes.length; i++) {
            String [] values = routes[i].split(" ");
            go(values[0], Integer.parseInt(values[1]));
        }
        return new int[] {startX, startY};
    }
}