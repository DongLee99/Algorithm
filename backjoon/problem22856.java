import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class main {
    static int N;
    static boolean [] visited;
    static List<Node>[] list;
    static List<Integer> result;
    static int last;
    static boolean check = false;
    static int count = 0;
    static class Node {
        public int left;
        public int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    public static void dfs(int start, int pa) {
        boolean leftCheck = false;
        boolean rightCheck = false;
        boolean c = false;
        if (start == last && check == true) {
            System.out.println(count);
            c = true;
        } else {
            System.out.println(count+1);
            c = true;
        }
        if (c == true) {
            return;
        }

        for (Node node : list[start]) {
            if (node.left != -1 && visited[node.left] != true) {
                visited[node.left] = true;
                leftCheck = true;
                count++;
                dfs(node.left, start);
            }
            if (node.right != -1 && visited[node.right] != true) {
                visited[node.right] = true;
                rightCheck = true;
                count++;
                dfs(node.right, start);
            }
            if (leftCheck == false && rightCheck == false) {
                if (pa == 1) {
                    check = true;
                }
                count++;
            }
            if (leftCheck == true && rightCheck == true && pa != 0) {
                if (pa == 1) {
                    check = true;
                }
                count++;
            }
        }
    }

    public static void dfsF(int start) {
        result.add(start);
        for (Node node : list[start]) {
            if (node.left != -1 && visited[node.left] != true) {
                visited[node.left] = true;
                dfsF(node.left);
            }
            if (node.right != -1 && visited[node.right] != true) {
                visited[node.right] = true;
                dfsF(node.right);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        StringTokenizer st;
        list = new ArrayList[N+1];
        result = new ArrayList<>();
        visited = new boolean[N+1];
        for(int i=0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            int now = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            list[now].add(new Node(left, right));
        }
        visited[0] = true;
        visited[1] = true;
        dfsF(1);
        visited = new boolean[N+1];
        visited[0] = true;
        visited[1] = true;
        last = result.get(result.size() - 1);
        dfs(1, 0);
    }

}