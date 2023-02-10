import java.util.*;

class Solution {

    public static int [][] arr;
    public static boolean [][] visit;
    public static List<Integer> result = new ArrayList<>();
    public static int N;
    public static int M;
    public static int TCOUNT = 0;
    public static int [] dx = {0, 0, 1, -1};
    public static int [] dy = {1, -1, 0, 0};

    public void dfs(int x, int y, int count) {
        boolean check = false;
        for (int i = 0; i < 4; i++) {
            int cx = dx[i] + x;
            int cy = dy[i] + y;
            if (cx >= 0 && cx < N && cy >= 0 && cy < M) {
                if (visit[cx][cy] == false) {
                    visit[cx][cy] = true;
                    check = true;
                    TCOUNT = TCOUNT + arr[cx][cy];
                    dfs(cx, cy, count + arr[cx][cy]);
                }
            }
        }
    }

    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        arr = new int [N][M];
        visit = new boolean [N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                String tmp = String.valueOf(maps[i].charAt(j));
                if (tmp.equals("X")) {
                    arr[i][j] = 0;
                    visit[i][j] = true;
                } else {
                    arr[i][j] = Integer.parseInt(tmp);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j] == false) {
                    visit[i][j] = true;
                    TCOUNT = arr[i][j];
                    dfs(i, j, arr[i][j]);
                    result.add(TCOUNT);
                }
            }
        }
        if (result.size() == 0) {
            result.add(-1);
        }
        Collections.sort(result);
        int [] answer = new int [result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;

    }
}