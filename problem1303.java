import java.util.ArrayList;
import java.util.Scanner;

public class problem1303{
    static int N;
    static int M;
    static String arr [][];
    static boolean visit [][];
    static int X [] = {1,-1,0,0};
    static int Y [] = {0,0,-1,1};
    static int cnt = 0;
    static ArrayList<Integer> result1 = new ArrayList<>();
    static ArrayList<Integer> result2 = new ArrayList<>();
    private static void WDFS(){
        for (int i = 0; i < N; i++){
            for (int j = 0 ; j < M; j++){
                if (visit[i][j] == false && arr[i][j].equals("W")){
                    cnt = 0;
                    //System.out.println("DFS" +i + "   " + j);
                    Wsearch(i,j);
                    result1.add(cnt);
                }
            }
        }
    }
    private static void BDFS(){
        for (int i = 0; i < N; i++){
            for (int j = 0 ; j < M; j++){
                if (visit[i][j] == false && arr[i][j].equals("B")){
                    cnt = 0;
                    //System.out.println("DFS" +i + "   " + j);
                    Bsearch(i,j);
                    result2.add(cnt);
                }
            }
        }
    }
    private static void Wsearch(int start, int stop){
        visit[start][stop] = true;
        cnt++;
        for(int i=0; i < 4; i++) {
            int yy = Y[i] + stop;
            int xx = X[i] + start;
            if (yy >= 0 && xx >=0 && xx < N && yy <M){
                if (arr[xx][yy].equals("W") && visit[xx][yy] == false){
                    //System.out.println(xx + "   " + yy);
                    Wsearch(xx,yy);
                }
            }
        }
        return;

    }
    private static void Bsearch(int start, int stop){
        visit[start][stop] = true;
        cnt++;
        for(int i=0; i < 4; i++) {
            int yy = Y[i] + stop;
            int xx = X[i] + start;
            if (yy >= 0 && xx >=0 && xx < N && yy <M){
                if (arr[xx][yy].equals("B") && visit[xx][yy] == false){
                    //System.out.println(xx + "   " + yy);
                    Bsearch(xx,yy);
                }
            }
        }
        return;

    }
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);

        M = scanf.nextInt();
        N = scanf.nextInt();
        arr = new String [N][M];
        visit = new boolean[N][M];
        for (int i = 0 ; i < N; i++){
            String tmp = scanf.next();
            for (int j = 0; j < M; j ++){
                arr[i][j] = Character.toString(tmp.charAt(j));
            }
        }
        WDFS();
        BDFS();
        int r1 = 0;
        int r2 = 0 ;
        for (int i = 0 ; i < result1.size() ; i ++){
            r1 = (int) (r1 +Math.pow(result1.get(i),2));
        }for (int i = 0 ; i < result2.size() ; i ++){
            r2 = (int) (r2 +Math.pow(result2.get(i),2));
        }
        System.out.print(r1 + " " + r2);

    }
}

