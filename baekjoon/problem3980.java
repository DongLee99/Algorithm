import java.util.*;

public class problem {
    static boolean visit[];
    static int [][] players;
    static int MAX = Integer.MIN_VALUE;
    static List<Integer> result = new ArrayList<>();

    static void check(int num, int depth) {
        if (depth == 11) {
            if (num > MAX) {
                MAX = num;
            }
            return;
        } else {
            for (int j = 0; j < 11; j++) {
                if (visit[j] == true || players[depth][j] == 0 ) continue;
                visit[j] = true;
                check(num + players[depth][j], depth + 1);
                visit[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();


        for (int k = 0; k < N; k++) {
            players = new int[12][12];
            visit = new boolean[12];
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 11; j++) {
                    players[i][j] = scanner.nextInt();
                }
            }
            check(0, 0);
            result.add(MAX);
        }
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}