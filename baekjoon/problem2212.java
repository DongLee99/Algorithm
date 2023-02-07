import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class problem {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        int K = Integer.parseInt(st.nextToken());
        int arr [] = new int [N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        Integer [] arr2 = new Integer[N-1];
        for (int i = 0 ; i < N-1; i++) {
            arr2[i] = arr[i+1] - arr[i];
        }
        Arrays.sort(arr2,Collections.reverseOrder());
        int result = 0;
        for (int i = K-1; i <N-1; i++) {
            result = result + arr2[i];
        }

        System.out.println(result);
    }
}