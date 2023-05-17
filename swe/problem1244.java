import java.util.*;
import java.io.*;
class Solution
{
    public static int N;
    public static int M;
    public static int [] arr;
    public static int [] tmpArr;
    public static Node [] visited;
    public static int MAX = Integer.MIN_VALUE;
    public static class Node {
        public int first;
        public int second;

        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void find(int start, int count) {
        if (count == M) {
            for (int i = 0; i < visited.length; i++) {
                Node node = visited[i];
                int temp = arr[node.first];
                arr[node.first] = arr[node.second];
                arr[node.second] = temp;
            }
            String result = "";
            for (int i = 0; i < arr.length; i++) {
                result = result + String.valueOf(arr[i]);
            }
            MAX = Math.max(MAX, Integer.parseInt(result));
            for (int i = 0; i < arr.length; i++) {
                arr[i] = tmpArr[i];
            }
            return;
        }
        for (int i = start; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                visited[count] = new Node(i, j);
                find(i, count + 1);
            }
        }
    }


    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String temp = sc.next();
            N = Integer.parseInt(temp);
            M = sc.nextInt();
            MAX = Integer.MIN_VALUE;
            arr = new int[temp.length()];
            tmpArr = new int[temp.length()];
            visited = new Node[M];
            for (int i = 0; i < temp.length(); i++) {
                arr[i] = Integer.parseInt(String.valueOf(temp.charAt(i)));
                tmpArr[i] = Integer.parseInt(String.valueOf(temp.charAt(i)));
            }
            if (arr.length < M) {
                M = arr.length;
            }
            find(0, 0);
            System.out.println("#" + test_case + " " + MAX);
        }
    }
}
