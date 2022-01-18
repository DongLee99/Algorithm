import java.util.*;

public class problem {

    public static int [] parent;
    public static List<String> result = new ArrayList<>();

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    static int find(int num) {
        if (parent[num] == num) {
            return num;
        } else {
            return parent[num] = find(parent[num]);
        }
    }

    static boolean isSameParent(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int num = s.nextInt();
            int a = s.nextInt();
            int b = s.nextInt();
            if (num == 0) {
                union(a, b);
            } else {
                if (isSameParent(a, b)) {
                    result.add("YES");
                } else {
                    result.add("NO");
                }
            }
        }
        for (String s1 : result) {
            System.out.println(s1);
        }
    }
}
