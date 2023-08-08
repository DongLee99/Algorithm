import java.util.*;


public class Main
{
    public static int M;
    public static int N;
    public static int K;
    public static int[] arr;

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[M];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            stringBuilder.append(sc.nextInt());
        }
        StringBuilder st = new StringBuilder();
        if (N < M) {
            System.out.println("normal");
            return;
        }
        for (int i = 0; i < N; i++) {
            st.append(sc.nextInt());
        }
        if (st.toString().contains(stringBuilder.toString())) {
            System.out.println("secrete");
        } else {
            System.out.println("normal");
        }
    }
}