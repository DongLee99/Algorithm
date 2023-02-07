import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class main {

    public static int N;
    public static int W;
    public static int L;
    public static int time = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String [] firstLine = bf.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        W = Integer.parseInt(firstLine[1]);
        L = Integer.parseInt(firstLine[2]);
        int [] array = Arrays.stream(bf.readLine().split(" "))
                .mapToInt((value -> Integer.parseInt(value)))
                .toArray();
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> truck = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            truck.add(array[i]);
        }
        for (int i = 0; i < W; i++) {
            queue.add(0);
        }
        int sum = 0;
        while (!queue.isEmpty()) {
            sum = sum - queue.poll();
            if (!truck.isEmpty()) {
                if (sum + truck.peek() <= L) {
                    sum = sum + truck.peek();
                    queue.add(truck.poll());
                } else {
                    queue.add(0);
                }
            }
            time++;
        }
        System.out.println(time);
    }
}