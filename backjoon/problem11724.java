import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem {
    static int N;
    static int M;
    static List<Integer> [] lists;
    static boolean [] visit;
    static int count = 0;

    static public void bfs(int start) {
        visit[start] = true;
        count++;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()) {
            int num = q.poll();
            for (int i = 0; i < lists[num].size(); i++) {
                if (visit[lists[num].get(i)] == false) {
                    visit[lists[num].get(i)] = true;
                    q.add(lists[num].get(i));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N+1];
        lists = new List[N+1];
        for (int i = 0; i < N+1; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lists[x].add(y);
            lists[y].add(x);
        }
        for (int i = 1; i < N + 1; i++) {
            if (visit[i] == false) {
                bfs(i);
            }
        }
        System.out.println(count);
    }
}