import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class problem1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        //peek = 처음 원소 삭제 X 가져욤
        //poll = 처음 원소 가져
        for(int i = 0; i< N; i++) {
            if (maxQ.size() == minQ.size()) {
                maxQ.add(Integer.parseInt(br.readLine()));
            } else {
                minQ.add(Integer.parseInt(br.readLine()));
            }
            if (!minQ.isEmpty() && maxQ.peek() > minQ.peek()) {
                maxQ.add(minQ.poll());
                minQ.add(maxQ.poll());
            }
            bw.write(maxQ.peek() + "\n");
        }
        bw.flush();
    }
}