import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static int N;
    private static int M;
    private static int [] dx = {0, 0, 1, -1};
    private static int [] dy = {1, -1, 0, 0};
    private static int [][] arr;
    private static boolean [][] visited;
    private static class Node {
        int x;
        int y;
        int idx;

        public Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
    private static class Block implements Comparable<Block>{
        Queue<Node> nodes = new LinkedList<>();
        Node head;
        int rainbowCount;

        public Block(Queue<Node> nodes, Node head, int rainbowCount) {
            this.nodes = nodes;
            this.head = head;
            this.rainbowCount = rainbowCount;
        }

        @Override
        public int compareTo(Block o) {
            if (o.nodes.size() == nodes.size()) {
                if (o.rainbowCount == rainbowCount) {
                    if (o.head.x == head.x) {
                        return o.head.y - head.y;
                    } else {
                        return o.head.x - head.x;
                    }
                } else {
                    return o.rainbowCount - rainbowCount;
                }
            } else {
                return o.nodes.size() - nodes.size();
            }
        }
    }

    private static Block bfs(int x, int y, Queue<Node> nodes) {
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(x, y, arr[x][y]);
        Queue<Node> rainbowQueue = new LinkedList<>();
        queue.add(node);
        nodes.add(node);
        visited[node.x][node.y] = true;
        int rainbowCount = 0;
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int cx = poll.x + dx[i];
                int cy = poll.y + dy[i];
                if (cx >= 1 && cx <= N && cy >= 1 && cy <= N) {
                    if (arr[cx][cy] != -1 && visited[cx][cy] == false) {
                        if (arr[cx][cy] == 0) {
                            rainbowCount++;
                            visited[cx][cy] = true;
                            rainbowQueue.add(new Node(cx, cy, arr[cx][cy]));
                            nodes.add(new Node(cx, cy, arr[cx][cy]));
                            queue.add(new Node(cx, cy, arr[x][y]));
                        } else if (arr[cx][cy] == arr[x][y]) {
                            visited[cx][cy] = true;
                            nodes.add(new Node(cx, cy, arr[cx][cy]));
                            queue.add(new Node(cx, cy, arr[x][y]));
                        }
                    }
                }
            }
        }
        while(!rainbowQueue.isEmpty()) {
            Node poll = rainbowQueue.poll();
            visited[poll.x][poll.y] = false;
        }
        return new Block(nodes, node, rainbowCount);
    }

    private static Block findBlock(int x, int y) {
        Node head = new Node(x, y, arr[x][y]);
        Queue<Node> nodes = new LinkedList<>();
        return bfs(x, y, nodes);
    }

    private static void removeBlock(Block block) {
        while(!block.nodes.isEmpty()) {
            Node poll = block.nodes.poll();
            arr[poll.x][poll.y] = -2;
        }
    }
    private static void turnArr() {
        int [][] tmp = new int[N+1][N+1];
        for (int i = N; i >= 1; i--) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 1; j <= N; j++) {
                stack.add(arr[j][i]);
            }
            for (int j = N; j >= 1; j--) {
                tmp[N + 1 - i][j] = stack.pop();
            }
        }
        arr = tmp;
    }

    private static void gravity() {
        for (int i = 1; i <= N; i++) {
            Queue<Integer> queue = new LinkedList<>();
            int count = 0;
            for (int j = N; j >= 1; j--) {
                if (queue.isEmpty() && arr[j][i] == -2) {
                    count++;
                } else if (arr[j][i] == -2) {
                    count++;
                } else if (arr[j][i] >= 0) {
                    queue.add(arr[j][i]);
                } else if (arr[j][i] == -1) {
                    for (int z = 0; z < count; z++) {
                        queue.add(-2);
                    }
                    count = 0;
                    queue.add(-1);
                }
            }
            int start = N;
            while(!queue.isEmpty()) {
                arr[start][i] = queue.poll();
                start--;
            }
            for (int j = start; j >= 1; j--) {
                arr[j][i] = -2;
            }
        }
    }
    private static int play() {
        int result = 0;
        while (true) {
            PriorityQueue<Block> blocks = new PriorityQueue<>();
            visited = new boolean[N+1][N+1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] >= 1 && arr[i][j] <= M && visited[i][j] == false) {
                        blocks.add(findBlock(i, j));

                    }
                }
            }
            if (blocks.isEmpty()) {
                break;
            }
            if (blocks.peek().nodes.size() <= 1 ) {
                break;
            }
            result = result + (blocks.peek().nodes.size() * blocks.peek().nodes.size());
            removeBlock(blocks.poll());
//            for (int i = 1; i <= N; i++) {
//                for (int j = 1; j <= N; j++) {
//                    System.out.print(arr[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            gravity();

            turnArr();
            gravity();
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int [N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(play());
    }
}