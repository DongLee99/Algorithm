import java.util.*;


public class problem2606 {

    static int nE;
    static int nV;
    static int[][] ad;
    static boolean[] visit;

    public static void dfs(int i){
        visit[i] = true;   // 함수 호출 시, visit 했음을 표시

        for(int j = 1; j < nV+1; j++){
            if(ad[i][j] == 1 && visit[j] == false){  // j를 방문하지 않았으면 j를 방문한다.
                dfs(j);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        nV = scan.nextInt();
        nE = scan.nextInt();
        ad = new int[nV+1][nV+1];// 변수 초기화
        visit = new boolean[nV+1]; // 변수 초기화

        for(int i = 0; i < nE; i++){
            int t1 = scan.nextInt();
            int t2 = scan.nextInt();

            ad[t1][t2] = ad[t2][t1] = 1;
        }
        dfs(1);
        int cnt = 0 ;
        for (int i = 0 ; i< visit.length; i++){
            if (visit[i] ==true){
                cnt++;// 1번부터 탐색 시작
            }
        }
        System.out.print(cnt-1);
        ad = new int[nV+1][nV+1];
        visit = new boolean[nV+1];
    }

}



