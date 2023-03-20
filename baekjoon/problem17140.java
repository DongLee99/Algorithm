import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static int R;
    public static int C;
    public static int K;
    public static int [][] arr;
    public static int rowSize = 0;
    public static int colSize = 0;
    public static int answer = -1;

    public static class Node implements Comparable<Node>{
        public int value;
        public int count;

        public Node(int value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            if (count == o.count) {
                return value - o.value;
            } else {
                return count - o.count;
            }
        }
    }

    public static void Rsort() {
        int tmpColCount = 0;
        for (int i = 0; i < rowSize; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Node> nodes = new PriorityQueue<>();
            for (int j = 0; j < colSize; j++) {
                if (arr[i][j] != 0) {
                    if (map.containsKey(arr[i][j])) {
                        map.replace(arr[i][j], map.get(arr[i][j]) + 1);
                    } else {
                        map.put(arr[i][j], 1);
                    }
                }
            }
            tmpColCount = Math.max(map.size() * 2, tmpColCount);
            Set<Integer> integers = map.keySet();
            for (Integer integer : integers) {
                nodes.add(new Node(integer, map.get(integer)));
            }
            int j = 0;
            while(!nodes.isEmpty()) {
                Node poll = nodes.poll();
                arr[i][j] = poll.value;
                arr[i][j+1] = poll.count;
                j += 2;
            }
            for (int k = j; k < 100; k++) {
                arr[i][k] = 0;
            }
        }
        colSize = tmpColCount;
    }

    public static void Csort() {
        int tmpRowCount = 0;
        for (int i = 0; i < colSize; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Node> nodes = new PriorityQueue<>();
            for (int j = 0; j < rowSize; j++) {
                if (arr[j][i] != 0) {
                    if (map.containsKey(arr[j][i])) {
                        map.replace(arr[j][i], map.get(arr[j][i]) + 1);
                    } else {
                        map.put(arr[j][i], 1);
                    }
                }
            }
            tmpRowCount = Math.max(map.size() * 2, tmpRowCount);
            Set<Integer> integers = map.keySet();
            for (Integer integer : integers) {
                nodes.add(new Node(integer, map.get(integer)));
            }
            int j = 0;
            while(!nodes.isEmpty()) {
                Node poll = nodes.poll();
                arr[j][i] = poll.value;
                arr[j+1][i] = poll.count;
                j += 2;
            }
            for (int k = j; k < 100; k++) {
                arr[k][i] = 0;
            }
        }
        rowSize = tmpRowCount;
    }

    public static void play() {
        int time = 0;
        while (time < 100) {
            if (arr[R-1][C-1] == K) {
                answer = time;
                break;
            }
            if (rowSize >= colSize) {
                Rsort();
            } else {
                Csort();
            }
            time++;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[100][100];
        rowSize = 3;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(bf.readLine());
            int size = st.countTokens();
            colSize = size;
            for (int j = 0; j < size; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        play();
        System.out.println(answer);
    }
    // R 연산 A의 모든 행 정렬 행 >= 열
    // C 연산 A의 모든 열 정렬 열 > 행
    // 정렬을 하려면 각 수가 몇번 나왔는지 알아야함 수의 등장 횟수가 커지는 순 크기가 같다면 큰 순

}
