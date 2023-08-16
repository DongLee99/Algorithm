import java.util.*;



public class Main
{
    public static int N;
    public static int K;
    public static String arr;
    public static int[] indexs;
    public static int pCount;
    public static int hCount;
    public static boolean[] pVisited;
    public static boolean[] hVisited;
    public static int MAX = Integer.MIN_VALUE;

    public static void find(int count, int index) {
        if (index == pCount) {
            MAX = Math.max(MAX, count);
            return;
        }

        for (int j = -K; j <= K; j++) {
            if (indexs[index] + j >= 0 && indexs[index] + j < arr.length() && hVisited[indexs[index]+j] == false) {
                hVisited[indexs[index]+j] = true;
                find(count + 1, index + 1);
                hVisited[indexs[index]+j] = false;
            }
        }
        find(count, index + 1);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = sc.next();
        pVisited = new boolean[arr.length()];
        hVisited = new boolean[arr.length()];

        Arrays.fill(pVisited, true);
        Arrays.fill(hVisited, true);
        for (int i = 0; i < arr.length(); i++) {
            if (arr.charAt(i) == 'P') {
                pCount++;
                pVisited[i] = false;
            }
            if (arr.charAt(i) == 'H') {
                hCount++;
                hVisited[i] = false;
            }
        }
        indexs = new int[pCount];
        int iCount = 0;
        for (int i = 0; i < arr.length(); i++) {
            if (arr.charAt(i) == 'P') {
                indexs[iCount] = i;
                iCount++;
            }
        }
        find(0, 0);
        System.out.println(MAX);
    }
}