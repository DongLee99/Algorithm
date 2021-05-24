import java.util.*;


public class problem1260 {

    static int nE;
    static int nV;
    static int[][] ad;
    static int[][] ad1;
    static boolean[] visit;

    public static void dfs(int i){
        visit[i] = true;   // 함수 호출 시, visit 했음을 표시
        System.out.print(i+ " ");

        for(int j = 1; j < nV+1; j++){
            if(ad[i][j] == 1 && visit[j] == false){  // j를 방문하지 않았으면 j를 방문한다.
                dfs(j);
            }
        }
    }
    public static void bfs(int i){
        Queue <Integer> q = new <Integer> LinkedList();

        q.offer(i);
        visit[i] = true;

        while(!q.isEmpty()){
            int temp = q.poll();
            System.out.print(temp + " ");

            for(int j = 1; j <= nV; j++){
                if(ad[temp][j] == 1 && visit[j] == false){
                    q.offer(j);
                    visit[j] = true;                   // 큐에 넣을 노드들을 잠재적으로 방문한다는 가정하에 입력
                }
            }

        }
    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        nV = scan.nextInt();
        nE = scan.nextInt();
        int a = scan.nextInt();
        ad = new int[nV+1][nV+1];
        ad1 = new int[nV+1][nV+1];// 변수 초기화
        visit = new boolean[nV+1]; // 변수 초기화

        for(int i = 0; i < nE; i++){
            int t1 = scan.nextInt();
            int t2 = scan.nextInt();

            ad[t1][t2] = ad[t2][t1] = 1;
            ad1[t1][t2] =ad1[t2][t1] =1;

        }
        dfs(a); // 1번부터 탐색 시작
        System.out.println();
        visit = new boolean[nV+1];
        bfs(a);
    }

}



