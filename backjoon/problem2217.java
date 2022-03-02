import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class problem {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        int arr [] = new int [N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int result = arr[N-1];
        for (int i = 0; i< N; i++) {
            result = Math.max(arr[i] * (N - i), result);
        }
        System.out.println(result);
    }
}