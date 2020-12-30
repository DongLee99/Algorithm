import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class problem2468{
    static boolean visit [][];
    static int [][] arr;
    static int N;
    static int cnt;
    static ArrayList al = new ArrayList();
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0, 0, -1,1};
    public static void dfs(int start1, int start2){
        for (int i = 0; i <6; i++){
            for (int j = 0; j<6; j++){
                if (visit[i][j] == false && arr[i][j] > N){
                    cnt =1;
                    find(i,j);
                    al.add(cnt);
                }
            }
            Collections.sort(al);
        }
    }
    static int find( int x, int y){
        visit[x][y] = true;
        for (int i = 0 ; i < 4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if (nx >= 0 && ny>=0 && nx <=6&& ny<=6) {
                if (arr[nx][ny] > N && visit[nx][ny] == false){
                    find(nx,ny);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String [] args){
        Scanner scanf = new Scanner(System.in);
        N = scanf.nextInt();
        visit = new boolean[6][6];
        arr = new int [6][6];
        for (int i = 0; i< 5; i++){
            for (int j = 0; j< 5 ; j++){
                int a = scanf.nextInt();
                arr[i][j] = a;
            }
        }
        dfs(0, 0);
        System.out.println(al.size());
    }
}

