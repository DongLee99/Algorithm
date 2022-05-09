import java.io.*;
import java.util.*;

public class problem {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int semi_result = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
            semi_result = 0;
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                if (j == 0) {
                    semi_result = Integer.parseInt(st.nextToken());
                } else {
                    semi_result = Math.min(semi_result, Integer.parseInt(st.nextToken()));
                }
            }
            result = Math.max(result, semi_result);
        }
        System.out.println(result);
    }
}