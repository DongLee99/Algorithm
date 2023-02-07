import java.util.Scanner;

public class problem15649{
    public static int arr[];
    public static boolean visit[];

    void dfs(int start, int end ,int dept){
        if (end == dept){
            for (int val : arr){
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < start; i++){
            if (!visit[i]){
                visit[i] = true;
                arr[dept] = i+1;
                dfs(start,end,dept+1);
                visit[i] = false;
            }
        }
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        arr = new int[M];
        visit = new boolean[N];
        problem15649 dfs = new problem15649();
        dfs.dfs(N, M, 0);
    }

}