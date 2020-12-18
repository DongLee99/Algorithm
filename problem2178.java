import java.util.*;


public class problem2178 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int nE;
    static int nV;
    static int[][] ad;
    static boolean[][] visit;

    public static void bfs(int stop, int start){
        Queue <Integer> qx = new <Integer> LinkedList();
        Queue <Integer> qy = new <Integer> LinkedList();

        qx.offer(stop);
        qy.offer(start);

        while(!qx.isEmpty() && !qy.isEmpty()){
            int x = qx.poll();
            int y = qy.poll();
            visit[x][y] = true; // 방문 표시
            for (int i=0; i<4; i++){ // 오른쪽 아래 왼쪽 위 돌아가며 탐색
                 int _x = x + dx[i];
                 int _y = y + dy[i];
                 if (_x >= 0 && _y >= 0 && _x < nV && _y < nE) {
                     if(ad[_x][_y] == 1 && visit[_x][_y] == false){ // 미방문
                         qx.add(_x);
                         qy.add(_y);
                         visit[_x][_y] = true; // 방문 표시
                         ad[_x][_y] = ad[x][y]+1;
                         // 방문한 좌표는 이동 횟수로 변경
                         }
                 }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nV = sc.nextInt();
        nE = sc.nextInt();
        ad = new int[100][100];
        visit = new boolean[100][100];
        for (int i=0; i<nV; i++) {
            String temp = sc.next();
            for (int j=0; j<nE; j++) {
            ad[i][j] = temp.charAt(j) - 48;
            // ASCII Code 48~57 (숫자) 문자를 숫자로 변환
            }
        }
        bfs(0 , 0); // bfs 시작
        System.out.print(ad[nV-1][nE-1]);
    }
}
/*
import java.util.*;

public class problem2178 {
    static int nE;
    static int nV;
    static int[][] ad;
    static boolean[][] visit;
    static int cnt;
    static ArrayList al = new ArrayList();
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int cnt1= 0;
    public static void dfs(int i, int j){

        for(int a = 0; a < nV+1; a++){
            for (int b = 0; b < nV+1; b++) {
                if (ad[a][b] == 1 && visit[a][b] == false) {
                    // j를 방문하지 않았으면 j를 방문한다.
                    cnt = 1;
                    find(a,b);
                    al.add(cnt);
                }
            }

            Collections.sort(al);

        }


    }static int find(int x, int y)
    {
        visit[x][y] = true;

        for(int i=0;i<4;i++)
        {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0&&ny>=0&&nx<=nV&&ny<=nV) {

                if(ad[nx][ny] == 1 && visit[nx][ny] == false)
                {
                    find(nx,ny);
                    System.out.println(nx + " " + ny);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String args[]){
        Scanner scanf = new Scanner(System.in);
        nV = scanf.nextInt();
        nE = scanf.nextInt();
        ad = new int[nV+1][nE+1];
        visit = new boolean[nV+1][nE+1];
        cnt = 0;
        for (int i = 0; i < nV; i++){
            String s = scanf.next();
            for(int j = 0; j< s.length(); j++){
                if (s.charAt(j) == '1') {
                    ad[i][j]= 1;
                }else {
                    ad[i][j]= 0;
                }
            }
        }
        dfs(0,0);
        System.out.println(al.size());
        for(int k =0;k<al.size();k++)
            if (al.size()-1 > k){
                System.out.println(al.get(k));
            }else {
                System.out.print(al.get(k));
            }
    }
}*/