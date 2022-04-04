import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem {

    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(bf.readLine());
        N = Integer.parseInt(bf.readLine());
        List<Integer> a = new ArrayList<>();

        boolean result = true;
        int count = 0;
        for (int i = M; i <= N; i++) {
            if (i == 1) {
                continue;
            }
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    result = false;
                    break;
                }
            }
            if (result == true) {
                a.add(i);
                count = count + i;
            } else {
                result = true;
            }
        }
        if (a.size() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
            System.out.println(a.get(0));
        }
    }
}