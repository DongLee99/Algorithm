import java.util.Scanner;

public class problem15650 {
    static int N;
    static int M;
    static boolean visit[];
    private static void DFS(int start, int depth){
        if (M == depth){
            for (int i = 0 ; i < N; i++){
                if (visit[i] == true){
                    System.out.print(i+1 + " ");
                }
            }
            System.out.println();
        }
        for (int i = start;i <N; i++){
            visit[i] = true;
            DFS(i +1, depth+1);
            visit[i] = false;
        }
    }
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        N = scanf.nextInt();
        M = scanf.nextInt();
        visit = new boolean[N];
        DFS(0,0);
    }
}
