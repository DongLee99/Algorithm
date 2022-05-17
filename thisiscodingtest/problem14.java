import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main {

    public static int [] arr;
    public static int MAX = Integer.MAX_VALUE;
    public static int answer = 0;

    public static void find(int start, int end, int target) {
        if (start > end) {
            return;
        }
        int mid = (start + end) / 2;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] -mid > 0) {
                result = result + arr[i] - mid;
            }
        }
        if (result < target) {
            find(start, mid -1, target);
        } else {
            answer = mid;
            find(mid + 1, end, target);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int end = arr[arr.length-1];
        find(0, end, H);
        System.out.println(answer);
    }
}
