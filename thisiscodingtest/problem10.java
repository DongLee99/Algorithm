import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class problem {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        Integer [] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());
        for (int i : arr) {
            System.out.println(i);
        }
    }
}