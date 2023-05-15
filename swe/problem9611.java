import java.util.*;
import java.io.*;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        List<Integer> map = new ArrayList<>();
        for (int i = 1; i <= TC; i++) {
            int N = sc.nextInt();
            int[] answer = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            for (int j = 0; j < N; j++) {
                Integer a = sc.nextInt();
                Integer b = sc.nextInt();
                Integer c = sc.nextInt();
                Integer d = sc.nextInt();
                String result = sc.next();
                if (result.equals("YES")) {
                    answer[a] = answer[a] * 2;
                    answer[b] = answer[b] * 2;
                    answer[c] = answer[c] * 2;
                    answer[d] = answer[d] * 2;
                } else {
                    answer[a] = 0;
                    answer[b] = 0;
                    answer[c] = 0;
                    answer[d] = 0;
                }

            }
            int result = 0;
            int standard = 0;
            for (int k = 0; k < 10; k++) {
                if (answer[k] > standard) {
                    standard = answer[k];
                    result = k;
                }
            }
            System.out.println("#" + i + " " + result);
        }
    }
}
