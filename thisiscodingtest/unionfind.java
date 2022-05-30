import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {

    public static int find_parent(int [] parent, int x) {
        if (parent[x] != x) {
            return find_parent(parent, parent[x]);
        }
        return x;
    }

    public static void union_parent(int[] parent, int a, int b) {
        a = find_parent(parent, a);
        b = find_parent(parent, b);

        if ( a < b ) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
    }
}
