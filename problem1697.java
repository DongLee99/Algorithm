/*import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
// bfs 임 다시 풀기
public class problem1697 {
    static int start = 0;
    static int stop = 0;
    static int cnt = 0;
    static ArrayList al = new ArrayList();
    static boolean visit [];
    public static void dfs(int start){
        if (start == stop){
            return;
        }else if (start <= 0) {
            return;
        }else {
            cnt = 0;
            bfs(start);

        }
    }
    public static void bfs(int start){
        Queue<Integer> q = new <Integer>LinkedList();
        q.offer(start);
        visit[start] = true;
        if (start == stop){
            return;
        }else if (start <= 0) {
            cnt = 0;
            return;
        }
        while(!q.isEmpty()){
            int temp = q.poll();
            System.out.println(temp + " ");

            if (start-1 > 0 && visit[start-1] ==false){
                //System.out.println("1 " + (start-1));
                bfs(start-1);
            }
            if (start*2 <= stop*2 && visit[start*2] ==false){
                //System.out.println("2 " +(start*2));
                bfs(start*2);
            }
            if (start+1 <= stop*2 && visit[start+1] ==false){
                //System.out.println("3 " +(start+1));
                bfs(start+1);
            }

        }
        return;
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
        visit = new boolean[100000];
        dfs(start);
        System.out.print(cnt);

    }
}*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class problem1697 {
    static int N;
    static int K;
    static int[] check = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }
    }

    static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        check[num] = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                if (next == K) {
                    System.out.println(check[temp]);
                    return;
                }

                if (next >= 0 && next < check.length && check[next] == 0) {
                    q.add(next);
                    check[next] = check[temp] + 1;
                }
            }
        }
    }
}
