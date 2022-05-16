import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] arr1 = new int[N];
        Integer [] arr2 = new Integer[N];

        st = new StringTokenizer(bf.readLine());
        for (int j = 0; j < N; j++) {
            arr1[j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int j = 0; j < N; j++) {
            arr2[j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2, Collections.reverseOrder());
        int position = 0;
        for (int i = 0; i < K; i++) {
            if (arr1[position] < arr2[position]) {
                arr1[position] = arr2[position];
            }
        }
    }
}
