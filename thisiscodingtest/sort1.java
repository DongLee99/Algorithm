import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int [] arr = new int[st.countTokens()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int x = arr[i];
            int min = arr[i+1];
            int position = i + 1;
            for (int j = i + 1; j < arr.length-1; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    position = j;
                }
            }
            arr[i] = min;
            arr[position] = x;
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}