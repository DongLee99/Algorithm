import java.util.*;

public class problem2667 {
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
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String args[]){
        Scanner scanf = new Scanner(System.in);
        nV = scanf.nextInt();
        ad = new int[nV+1][nV+1];
        visit = new boolean[nV+1][nV+1];
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
        }if (ad[0][0] ==1 && visit[0][0] ==true ){
            cnt ++;
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
}