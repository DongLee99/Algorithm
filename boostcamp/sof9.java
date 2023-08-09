import java.util.*;
import java.io.*;


public class Main
{
    public static int MAX = Integer.MIN_VALUE;
    public static int N;
    public static int M;

    public static class Node {
        public int range;
        public int limit;

        public Node (int range, int limit) {
            this.range = range;
            this.limit = limit;
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        Node[] arr = new Node[N];
        int now = 0;
        for (int i = 0; i < N; i++) {
            int range = sc.nextInt();
            int limit = sc.nextInt();
            now = now + range;
            arr[i] = new Node(now, limit);
        }
        int now2 = 0;
        int index = 0;
        for (int i = 0; i < M; i++) {
            int nowS = sc.nextInt();
            int speed = sc.nextInt();

            for (int j = now2 + 1; j <= nowS + now2; j++) {
                if (j <= arr[index].range) {
                    MAX = Math.max(MAX, speed - arr[index].limit);
                } else if (j > arr[index].range) {
                    index++;
                    if (j <= arr[index].range) {
                        MAX = Math.max(MAX, speed - arr[index].limit);
                    }
                }
            }
            now2 = nowS + now2;
        }
        if (MAX <= 0) {
            System.out.println(0);
        } else {
            System.out.println(MAX);
        }
    }
}