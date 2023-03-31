import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static int N;
    public static int [] arr = new int[5];
    public static int [][] tmpArr;
    public static int MAX = Integer.MIN_VALUE;

    public static void play() {
        int [][] copyArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copyArr[i][j] = tmpArr[i][j];
            }
        }
        for (int i = 0; i < 5; i++) {
            Stack<Integer> stack = new Stack<>();
            if (arr[i] == 0) { //오른
                for (int j = 0; j < N; j++) {
                    boolean check = false;
                    for (int k = N-1; k >=0 ; k--) {
                        if (copyArr[j][k] != 0) {
                            if (stack.isEmpty()) {
                                check = false;
                                stack.add(copyArr[j][k]);
                            } else if (stack.peek() == copyArr[j][k] && check == false) {
                                Integer pop = stack.pop();
                                MAX = Math.max(MAX, pop * 2);
                                stack.add(pop * 2);
                                check = true;
                            } else {
                                check = false;
                                stack.add(copyArr[j][k]);
                            }
                        }
                    }
                    for (int k = N-1; k >=0 ; k--) {
                        if (!stack.isEmpty()) {
                            copyArr[j][k] = stack.get(0);
                            MAX = Math.max(MAX, stack.get(0));
                            stack.remove(0);
                        } else {
                            copyArr[j][k] = 0;
                        }
                    }
                }
            } else if (arr[i] == 1) { //왼
                for (int j = 0; j < N; j++) {
                    boolean check = false;
                    for (int k = 0; k < N; k++) {

                        if (copyArr[j][k] != 0) {
                            if (stack.isEmpty()) {
                                check = false;
                                stack.add(copyArr[j][k]);
                            } else if (stack.peek() == copyArr[j][k] && check == false) {
                                Integer pop = stack.pop();
                                MAX = Math.max(MAX, pop * 2);
                                check = true;
                                stack.add(pop * 2);
                            } else {
                                check = false;
                                stack.add(copyArr[j][k]);
                            }
                        }
                    }
                    for (int k = 0; k < N ; k++) {
                        if (!stack.isEmpty()) {
                            copyArr[j][k] = stack.get(0);
                            MAX = Math.max(MAX, stack.get(0));
                            stack.remove(0);
                        } else {
                            copyArr[j][k] = 0;
                        }
                    }
                }
            } else if (arr[i] == 2) { //위
                for (int j = 0; j < N; j++) {
                    boolean check = false;
                    for (int k = 0; k < N; k++) {
                        if (copyArr[k][j] != 0) {
                            if (stack.isEmpty()) {
                                check = false;
                                stack.add(copyArr[k][j]);
                            } else if (stack.peek() == copyArr[k][j] && check == false) {
                                Integer pop = stack.pop();
                                check = true;
                                MAX = Math.max(MAX, pop * 2);
                                stack.add(pop * 2);
                            } else {
                                check = false;
                                stack.add(copyArr[k][j]);
                            }
                        }
                    }
                    int count = 0;
                    for (int k = 0; k < N; k++) {
                        if (!stack.isEmpty()) {
                            copyArr[k][j] = stack.get(count);
                            MAX = Math.max(MAX, stack.get(0));
                            stack.remove(count);
                        } else {
                            copyArr[k][j] = 0;
                        }
                    }
//                    for (int k = 0; k < N; k++) {
//                        if (!stack.isEmpty()) {
//                            copyArr[k][j] = stack.pop();
//                        } else {
//                            copyArr[k][j] = 0;
//                        }
//                    }
                }
            } else if (arr[i] == 3) { //아래
                for (int j = 0; j < N; j++) {
                    boolean check = false;
                    for (int k = N-1; k >= 0; k--) {
                        if (copyArr[k][j] != 0) {
                            if (stack.isEmpty()) {
                                check = false;
                                stack.add(copyArr[k][j]);
                            } else if (stack.peek() == copyArr[k][j] && check == false) {
                                Integer pop = stack.pop();
                                MAX = Math.max(MAX, pop * 2);
                                check = true;
                                stack.add(pop * 2);
                            } else {
                                check = false;
                                stack.add(copyArr[k][j]);
                            }
                        }
                    }
                    for (int k = N-1; k >=0 ; k--) {
                        if (!stack.isEmpty()) {
                            copyArr[k][j] = stack.get(0);
                            MAX = Math.max(MAX, stack.get(0));
                            stack.remove(0);
                        } else {
                            copyArr[k][j] = 0;
                        }
                    }
//                    for (int k = N-1; k >= 0; k--) {
//                        if (!stack.isEmpty()) {
//                            copyArr[k][j] = stack.pop();
//                        } else {
//                            copyArr[k][j] = 0;
//                        }
//                    }
                }
            }
//            for (int z = 0; z < N; z++) {
//                for (int c = 0; c < N; c++) {
//                    System.out.print(copyArr[z][c] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("========================");
        }
    }
    public static void makeArr(int count) {
        if (count == 5) {
            play();
            return;
        }

        for (int i = 0; i < 4; i++) {
            arr[count] = i;
            makeArr(count+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        tmpArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String [] tmp = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                tmpArr[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        makeArr(0);
        //arr = new int[]{0, 2, 0, 3, 2};
        play();
        if (MAX == Integer.MIN_VALUE) {
            System.out.println(2);
        } else {
            System.out.println(MAX);
        }
    }
}