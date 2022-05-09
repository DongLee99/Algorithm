import java.io.*;
import java.util.*;

public class problem {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        int x = 1;
        int y = 1;

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("R")) {
                if (x + 1 <= N) {
                    x = x + 1;
                }
                continue;
            }
            if (token.equals("L")) {
                if (x - 1 >= 1) {
                    x = x - 1;
                }
                continue;
            }
            if (token.equals("U")) {
                if (y - 1 >= 1) {
                    y = y - 1;
                }
                continue;
            }
            if (token.equals("D")) {
                if (y + 1 <= N) {
                    y = y + 1;
                }
                continue;
            }
        }
        System.out.println(y + " " + x);
    }
}