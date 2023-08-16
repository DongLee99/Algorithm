import java.util.*;



public class Main
{
    public static int N;
    public static int K;
    public static String arr;

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = sc.next();
        char[] cArr = arr.toCharArray();
        int result = 0;
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] == 'P') {
                for (int j = i - K; j <= i + K; j++) {
                    if (j >= 0 && j < cArr.length) {
                        if (cArr[j] == 'H') {
                            cArr[j] = 'A';
                            result++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}