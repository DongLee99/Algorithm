import java.io.*;
import java.util.*;

public class problem {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] arr = new int[N];



        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int result = 0;
        int count = 0;

        for (int i = 0; i < M; i++) {
            count++;
            if (count > K) {
                result = result + arr[N-2];
                count = 0;
            } else {
                result = result + arr[N-1];
            }
        }
        System.out.println(result);
    }
}