/*import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class problem2573 {
    static int N;
    static int M;
    static int cnt;
    static int [][]visit;
    static int [][]arr;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0, 0, -1,1};
    static ArrayList al = new ArrayList();
    static void dfs(int start, int stop){
        for (int i = 0 ; i < start + 1; i++){
            for (int j = 0 ; j < stop + 1; j++){
                if (visit[i][j] == 0 && arr[i][j] >0){
                   cnt = 1;
                   //System.out.println(i + "   " + j);
                   find(i,j);
                   al.add(cnt);
                }
            }
        }

    }
    static void find(int x, int y){
        visit[x][y] = 1;
        for (int i = 0 ; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx <= N+1 && ny <= M+1 ) {
                if (arr[nx][ny] > 0 && visit[nx][ny] == 0) {
                    find(nx, ny);
                    cnt++;
                }
            }
        }
    }
    static void minus(int [][] a){
        for (int i = 0; i<N;i++){
            for (int j = 0 ; j<M; j++){
                if (arr[i][j] != 0){
                    arr[i][j] = arr[i][j] -1;
                }

            }
        }
    }
    static boolean check (int [][] a){ //모두 0
        boolean result = true;
        for (int i = 0; i<N;i++){
            for (int j = 0 ; j<M; j++){
                if (arr[i][j] != 0){
                    result = false;
                }
            }
        }
        return result;
    }
    public static void main(String [] args){
        Scanner scanf = new Scanner(System.in);
        N = scanf.nextInt();
        M = scanf.nextInt();
        arr = new int [N+1][M+1];
        visit = new int [N+1][M+1];
        for (int i = 0; i<N;i++){
            for (int j = 0 ; j<M; j++){
                int a = scanf.nextInt();
                arr[i][j] = a;
            }
        }
        dfs(N,M);
        while (al.size() < 2){
            if (check(arr) == false) {
                al = new ArrayList();
                visit = new int[N + 1][M + 1];
                minus(arr);
                dfs(N, M);
            }else {
                System.out.print(0);
                return;
            }
        }
       System.out.print(al.size());

    }

}
import java.util.*;
        import java.io.*;

// https://www.acmicpc.net/problem/2573

class Main {
    static int r;
    static int c;
    static int[][] map;
    static int[][] visited;
    static int[][] melt;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        visited = new int[r][c];
        melt = new int[r][c];

        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();
    }

    static void solution() {
        int year = 0;

        while(true) {
            // dfs 로 빙산 덩어리 세기
            int count = 0;
            for(int i=0; i<r; i++) {
                for(int j=0; j<c; j++) {
                    if(visited[i][j] == 0 && map[i][j] != 0) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            if(count == 0) {
                System.out.println(0);
                break;
            } else if(count >= 2) {
                System.out.println(year);
                break;
            }

            melting();
            year++;
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = 1;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < r && 0 <= ny && ny < c) {
                // 1년 후에 녹는 빙산의 양 구하기
                if(map[nx][ny] == 0)
                    melt[x][y]++;

                // dfs 재귀
                if(visited[nx][ny] == 0 && map[nx][ny] != 0)
                    dfs(nx, ny);
            }
        }
    }

    static void melting() {
        /**
         * 1. 빙산 녹이기
         * 2. 만약 녹인 높이가 음수가 되면 0으로 바꿔주기
         * 3. visited 초기화
         * 4. melt 초기화
         */
/*
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                map[i][j] -= melt[i][j];

                if(map[i][j] < 0)
                    map[i][j] = 0;

                visited[i][j] = 0;
                melt[i][j] = 0;
            }
        }
    }
}*/