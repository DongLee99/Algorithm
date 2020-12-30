import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Arrays;
// bfs 임 다시 풀기
public class problem1697 {
    static int start = 0;
    static int stop = 0;
    static int cnt = 0;
    static boolean visit [];
    /*public static void dfs(int start){
        if (start == stop){
            return;
        }else if (start <= 0) {
            return;
        }else {
            cnt = 0;
            find(start);
        }
    }*/
    public static void bfs(int i){
        Queue<Integer> q = new <Integer>LinkedList();

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

    static int find(int start){
        visit[start] = true;
        if (start == stop){
            return cnt;
        }else if (start <= 0) {
            cnt = 0;
            return 0;
        }
        if (start-1 > 0 && visit[start-1] ==false){
            System.out.println("1 " + (start-1));
            find (start-1);
            cnt++;
        }
        if (start*2 <= stop && visit[start*2] ==false){
            System.out.println("2 " +(start*2));
            find (start*2);
            cnt++;
        }
        if (start+1 <=stop && visit[start+1] ==false){
            System.out.println("3 " +(start+1));
            find (start+1);
            cnt++;
        }
        return cnt;
    }
    public static void main(String [] args){
        Scanner scanf = new Scanner(System.in);

        start = scanf.nextInt();
        stop = scanf.nextInt();
        visit = new boolean[stop+1];
        dfs(start);
        System.out.print(cnt);
    }
}
