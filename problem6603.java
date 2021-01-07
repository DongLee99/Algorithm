import java.util.Scanner;

public class problem6603 {
    static int N;
    static int arr [];
    static boolean result[];
    private static void DFS(int start, int depth){
        if (depth == 6){
            for (int i = 0 ; i < N; i++){
                if(result[i] == true) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }
        for (int i = start; i <N ; i++) {
            result[i] = true;
            DFS(i+1, depth+1);
            result[i] = false;
        }
        // 1 2 3 4 5 6까지 첫 dfs 가 진행이 되고 if 문에서 출력
        //

    }
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);

        while(true) {
            N = scanf.nextInt();
            if (N == 0){
                break;
            }
            result = new boolean[N];
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanf.nextInt();
            }
            DFS(0, 0);
            System.out.println();
        }
    }
}
