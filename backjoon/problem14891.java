import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class main {

    public static int N;

    public static int [] arr1 = new int[8];
    public static int [] arr2 = new int[8];
    public static int [] arr3 = new int[8];
    public static int [] arr4 = new int[8];

    public static void turn(int direction, int [] arr) {
        int tmp = 0;
        int next = 0;
        if (direction == 1) {
            for (int i = 0; i < 8; i++) {
                if (i == 0) {
                    tmp = arr[i];
                    next = arr[i+1];
                    arr[i+1] = tmp;
                } else if (i == 7){
                    tmp = next;
                    arr[0] = tmp;
                }else {
                    tmp = next;
                    next = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
        } else {
            for (int i = 7; i >= 0; i--) {
                if (i == 7) {
                    tmp = arr[i];
                    next = arr[i-1];
                    arr[i-1] = tmp;
                } else if (i == 0){
                    tmp = next;
                    arr[7] = tmp;
                } else {
                    tmp = next;
                    next = arr[i-1];
                    arr[i-1] = tmp;
                }
            }
        }
    }

    public static int [] check() {
        int [] result = new int[3];
        if (arr1[2] != arr2[6]) {
            result[0] = 1;
        } else {
            result[0] = 0;
        }
        if (arr2[2] != arr3[6]) {
            result[1] = 1;
        } else {
            result[1] = 0;
        }
        if (arr3[2] != arr4[6]) {
            result[2] = 1;
        } else {
            result[2] = 0;
        }
        return result;
    }

    public static int getResult() {
        int count = 0;
        if (arr1[0] == 1) {
            count += 1;
        }
        if (arr2[0] == 1) {
            count += 2;
        }
        if (arr3[0] == 1) {
            count += 4;
        }
        if (arr4[0] == 1) {
            count += 8;
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for (int i = 0; i < 8; i++) {
            arr1[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        s = br.readLine();
        for (int i = 0; i < 8; i++) {
            arr2[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        s = br.readLine();
        for (int i = 0; i < 8; i++) {
            arr3[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        s = br.readLine();
        for (int i = 0; i < 8; i++) {
            arr4[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            if (position == 1) {
                int[] check = check();
                turn( direction ,arr1 );
                if (check[0] == 1) {
                    if (direction > 0) {
                        turn(direction - 2, arr2);
                    } else {
                        turn(direction + 2, arr2);
                    }
                    if (check[1] == 1) {
                        turn(direction, arr3);
                        if (check[2] == 1) {
                            if (direction > 0) {
                                turn(direction - 2, arr4);
                            } else {
                                turn(direction + 2, arr4);
                            }
                        }
                    }
                }
            } else if (position == 2) {
                int[] check = check();
                turn(direction, arr2);
                if (check[0] == 1) {
                    if (direction > 0) {
                        turn(direction - 2, arr1);
                    } else {
                        turn(direction + 2, arr1);
                    }
                }
                if (check[1] == 1) {
                    if (direction > 0) {
                        turn(direction - 2, arr3);
                    } else {
                        turn(direction + 2, arr3);
                    }
                    if (check[2] == 1) {
                        turn(direction, arr4);
                    }
                }
            } else if (position == 3) {
                int[] check = check();
                turn(direction, arr3);
                if (check[1] == 1) {
                    if (direction > 0) {
                        turn(direction - 2, arr2);
                    } else {
                        turn(direction + 2, arr2);
                    }
                    if (check[0] == 1) {
                        turn(direction, arr1);
                    }
                }
                if (check[2] == 1) {
                    if (direction > 0) {
                        turn(direction - 2, arr4);
                    } else {
                        turn(direction + 2, arr4);
                    }
                }
            } else {
                int[] check = check();
                turn(direction, arr4);
                if (check[2] == 1) {
                    if (direction > 0) {
                        turn(direction - 2, arr3);
                    } else {
                        turn(direction + 2, arr3);
                    }
                    if (check[1] == 1) {
                        turn(direction, arr2);
                        if (check[0] == 1) {
                            if (direction > 0) {
                                turn(direction - 2, arr1);
                            } else {
                                turn(direction + 2, arr1);
                            }
                        }
                    }
                }

            }
        }
        System.out.println(getResult());
    }
}
