import java.util.*;
public class Main {
    public static int N;
    public static String TYPE;
    public static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        TYPE = sc.next();
        if (TYPE.equals("Y")) {
            K = 1;
        } else if (TYPE.equals("F")) {
            K = 2;
        } else {
            K = 3;
        }
        Set<String> set = new HashSet<>();
        int count = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
            String tmp = sc.next();
            if (!set.contains(tmp)) {
                count++;
                set.add(tmp);
                if (count == K) {
                    System.out.println(tmp);
                    count = 0;
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}