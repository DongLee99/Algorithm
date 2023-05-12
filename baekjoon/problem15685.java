import java.util.*;

class main {

    public static Node[] dp0 = new Node[1025];
    public static Node[] dp1 = new Node[1025];
    public static Node[] dp2 = new Node[1025];
    public static Node[] dp3 = new Node[1025];
    public static int [][] arr;

    public static class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        dp0[0] = new Node(1, 0);
        dp1[0] = new Node(0, -1);
        dp2[0] = new Node(-1, 0);
        dp3[0] = new Node(0, 1);
        for (int j = 1; j <= 10; j++) {
            for (int i = 0; i < Math.pow(2, j-1); i++) {
                if (dp0[(int)Math.pow(2, j-1) -1 - i].x == 0 && dp0[(int)Math.pow(2, j-1) -1 - i].y == -1) {
                    dp0[i + (int) Math.pow(2,j-1)] = new Node(-1, 0);
                } else if (dp0[(int)Math.pow(2, j-1) -1 - i].x == -1 && dp0[(int)Math.pow(2, j-1) -1 - i].y == 0) {
                    dp0[i+ (int) Math.pow(2,j-1)] = new Node(0, 1);
                } else if (dp0[(int)Math.pow(2, j-1) -1 - i].x == 1 && dp0[(int)Math.pow(2, j-1) -1 - i].y == 0) {
                    dp0[i+ (int) Math.pow(2,j-1)] = new Node(0, -1);
                } else if (dp0[(int)Math.pow(2, j-1) -1 - i].x == 0 && dp0[(int)Math.pow(2, j-1) -1 - i].y == 1) {
                    dp0[i + (int) Math.pow(2,j-1)] = new Node(1, 0);
                }
            }
        }
        for (int j = 1; j <= 10; j++) {
            for (int i = 0; i < Math.pow(2, j-1); i++) {
                if (dp1[(int)Math.pow(2, j-1) -1 - i].x == 0 && dp1[(int)Math.pow(2, j-1) -1 - i].y == -1) {
                    dp1[i + (int) Math.pow(2,j-1)] = new Node(-1, 0);
                } else if (dp1[(int)Math.pow(2, j-1) -1 - i].x == -1 && dp1[(int)Math.pow(2, j-1) -1 - i].y == 0) {
                    dp1[i+ (int) Math.pow(2,j-1)] = new Node(0, 1);
                } else if (dp1[(int)Math.pow(2, j-1) -1 - i].x == 1 && dp1[(int)Math.pow(2, j-1) -1 - i].y == 0) {
                    dp1[i+ (int) Math.pow(2,j-1)] = new Node(0, -1);
                } else if (dp1[(int)Math.pow(2, j-1) -1 - i].x == 0 && dp1[(int)Math.pow(2, j-1) -1 - i].y == 1) {
                    dp1[i + (int) Math.pow(2,j-1)] = new Node(1, 0);
                }
            }
        }
        for (int j = 1; j <= 10; j++) {
            for (int i = 0; i < Math.pow(2, j-1); i++) {
                if (dp2[(int)Math.pow(2, j-1) -1 - i].x == 0 && dp2[(int)Math.pow(2, j-1) -1 - i].y == -1) {
                    dp2[i + (int) Math.pow(2,j-1)] = new Node(-1, 0);
                } else if (dp2[(int)Math.pow(2, j-1) -1 - i].x == -1 && dp2[(int)Math.pow(2, j-1) -1 - i].y == 0) {
                    dp2[i+ (int) Math.pow(2,j-1)] = new Node(0, 1);
                } else if (dp2[(int)Math.pow(2, j-1) -1 - i].x == 1 && dp2[(int)Math.pow(2, j-1) -1 - i].y == 0) {
                    dp2[i+ (int) Math.pow(2,j-1)] = new Node(0, -1);
                } else if (dp2[(int)Math.pow(2, j-1) -1 - i].x == 0 && dp2[(int)Math.pow(2, j-1) -1 - i].y == 1) {
                    dp2[i + (int) Math.pow(2,j-1)] = new Node(1, 0);
                }
            }
        }
        for (int j = 1; j <= 10; j++) {
            for (int i = 0; i < Math.pow(2, j-1); i++) {
                if (dp3[(int)Math.pow(2, j-1) -1 - i].x == 0 && dp3[(int)Math.pow(2, j-1) -1 - i].y == -1) {
                    dp3[i + (int) Math.pow(2,j-1)] = new Node(-1, 0);
                } else if (dp3[(int)Math.pow(2, j-1) -1 - i].x == -1 && dp3[(int)Math.pow(2, j-1) -1 - i].y == 0) {
                    dp3[i+ (int) Math.pow(2,j-1)] = new Node(0, 1);
                } else if (dp3[(int)Math.pow(2, j-1) -1 - i].x == 1 && dp3[(int)Math.pow(2, j-1) -1 - i].y == 0) {
                    dp3[i+ (int) Math.pow(2,j-1)] = new Node(0, -1);
                } else if (dp3[(int)Math.pow(2, j-1) -1 - i].x == 0 && dp3[(int)Math.pow(2, j-1) -1 - i].y == 1) {
                    dp3[i + (int) Math.pow(2,j-1)] = new Node(1, 0);
                }
            }
        }
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        arr = new int[101][101];
        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int d = scanner.nextInt();
            int g = scanner.nextInt();
            for (int j = 0; j < Math.pow(2, g); j++) {
                arr[y][x] = 1;

                if (d == 0) {
                    x = x + dp0[j].x;
                    y = y + dp0[j].y;
                    arr[y][x] = 1;
                } else if (d == 1) {
                    x = x + dp1[j].x;
                    y = y + dp1[j].y;
                    arr[y][x] = 1;
                } else if (d == 2) {
                    x = x + dp2[j].x;
                    y = y + dp2[j].y;
                    arr[y][x] = 1;
                } else if (d == 3) {
                    x = x + dp3[j].x;
                    y = y + dp3[j].y;
                    arr[y][x] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (arr[i][j] == 1) {
                    if (arr[i + 1][j] == 1 && arr[i][j + 1] == 1 && arr[i+1][j+1] == 1) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size = 0)
            throw new EmptyStackException();
        return elements[--size];
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
