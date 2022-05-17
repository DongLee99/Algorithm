import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main {

    public static int [] arr;

    public static String find(int start, int end, int tmp) {
        if (start > end) {
            return "no";
        }
        int mid = (start + end) / 2;
        if (arr[mid] == tmp) {
            return "yes";
        } else if (arr[mid] > tmp) {
            return find(start, mid -1, tmp);
        } else {
            return find(mid + 1, end, tmp);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            System.out.println(find(0, N, tmp));
        }
    }
}
