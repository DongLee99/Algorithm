import java.util.*;

class main {

    public static int N;
    public static int M;
    public static int MIN = Integer.MAX_VALUE;
    public static List<Node> chickenList = new ArrayList<>();
    public static List<Node> houseList = new ArrayList<>();
    public static int [][] arr;
    public static int [] tmpArr;
    public static boolean [] visited;

    public static void find(int depth, int start) {
        if (depth == M) {
            int result = 0;
            for (int i = 0; i < houseList.size(); i++) {
                Node house = houseList.get(i);
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < tmpArr.length; j++) {
                    Node chicken = chickenList.get(tmpArr[j]);
                    min = Math.min(min, Math.abs(chicken.x - house.x) + Math.abs(chicken.y - house.y));
                }
                result = result + min;
            }
            MIN = Math.min(MIN, result);
            return;
        }

        for (int i = start; i < chickenList.size(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                tmpArr[depth] = i;
                find(depth+1, i);
                visited[i] = false;
            }
        }
    };

    public static class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        arr = new int[N][N];
        tmpArr = new int[M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = scanner.nextInt();
                if (arr[i][j] == 1) {
                    houseList.add(new Node(i, j));
                } else if (arr[i][j] == 2) {
                    chickenList.add(new Node(i, j));
                }
            }
        }
        visited = new boolean[chickenList.size()];
        for (int i = 0; i < chickenList.size(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                tmpArr[0] = i;
                find(1, i);
                visited[i] = false;
            }
        }
        System.out.println(MIN);
    }
    // 먼저 개수 만큼 치킨집 완탐 리스트 만들고
    // 각 치킨집마다 집 사이 거리중 최소값 구한뒤 더하기
    // 최종값 MIN과 미교
}
