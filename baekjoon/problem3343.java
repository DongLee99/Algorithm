import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class main {
    public static long N;
    public static long A;
    public static long B;
    public static long C;
    public static long D;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Long.parseLong(st.nextToken());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        D = Long.parseLong(st.nextToken());

        double a = B / (double)A;
        double b = D / (double)C;
        if ( a < b ) {
            long tmp = A;
            A = C;
            C = tmp;
            tmp = B;
            B = D;
            D = tmp;
        }
        long count = Long.MAX_VALUE;
        for (int j = 0; j < C; j++) {
            long countB = (long) Math.ceil((double) (N - j*A) / C);
            boolean check = false;
            if (countB < 0) {
                check = true;
                countB = 0;
            }
            count = Math.min(count, j*B + countB*D);
            if (check) {
                break;
            }
        }
        System.out.println(count);
    }
}