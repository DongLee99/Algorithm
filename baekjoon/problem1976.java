import java.util.*;

public class problem {
    static int [] parent;
    static int destination;

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int a = scanner.nextInt();
                if (a == 1) {
                    union(i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if ( i == 0 ) {
                int a = scanner.nextInt();
                destination = find(a);
            } else {
                int a = scanner.nextInt();
                if (destination != find(a)) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
