import java.util.Scanner;

public class problem {
    public static int [] number;
    public static int [] operator = new int [4];
    public static int MAX = Integer.MIN_VALUE;	// 최댓값
    public static int MIN = Integer.MAX_VALUE;
    public static int N;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        number = new int [N];
        for (int i = 0; i < N; i ++) {
            number[i] = scanner.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operator[i] = scanner.nextInt();
        }

        dfs(number[0],1);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int num, int idx) {
        if (idx == N) {
            MAX = Math.max(num, MAX);
            MIN = Math.min(num, MIN);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                if (i == 0) {
                    dfs(num + number[idx], idx + 1);
                }

                if (i == 1) {
                    dfs(num - number[idx], idx + 1);
                }

                if (i == 2) {
                    dfs(num * number[idx], idx + 1);
                }

                if (i == 3) {
                    dfs(num / number[idx], idx + 1);
                }
                operator[i]++;
            }

        }
    }

}
