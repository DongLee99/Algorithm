import java.util.Scanner;

class main {

    public static int N;
    public static int L;

    public static int [][] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        L = scanner.nextInt();
        int result = 0;
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            int count = 0;
            int before = 0;
            boolean lineCheck = true;
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    before = arr[i][j];
                    count++;
                    continue;
                }
                if (Math.abs(arr[i][j] - before) >= 2) {
                    lineCheck = false;
                    break;
                }
                if (arr[i][j] == before) {
                    count++;
                    continue;
                }
                if (arr[i][j] > before) {
                    if (L == 1) {
                        count++;
                    }
                    if (count < L) {
                        lineCheck = false;
                        break;
                    }
                    before = arr[i][j];
                    count = 1;
                }
                if (arr[i][j] < before) {
//                    if (count < L) {
//                        lineCheck = false;
//                        break;
//                    }
                    if(j + L - 1 >= N) {
                        lineCheck = false;
                        break;
                    } else {
                        int now = j;
                        int nBefore = arr[i][j];
                        boolean check = false;
                        for (int k = now; k < now + L; k++) {
                            if (nBefore != arr[i][k]) {
                                check = true;
                                lineCheck = false;
                                break;
                            }

                        }
                        if (check == true) {
                            lineCheck = false;
                            break;
                        }
                        j = j + L - 1;
                        if (L == 1) {
                            count = -L;
                        } else {
                            count = 0;
                        }
                    }
                    before = arr[i][j];
                }
            }
            if (lineCheck == true) {
                result++;
            }
        }
        for (int i = 0; i < N; i++) {
            int count = 0;
            int before = 0;
            boolean lineCheck = true;
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    before = arr[j][i];
                    count++;
                    continue;
                }
                if (Math.abs(arr[j][i] - before) >= 2) {
                    lineCheck = false;
                    break;
                }
                if (arr[j][i] == before) {
                    count++;
                    continue;
                }
                if (arr[j][i] > before) {
                    if (L == 1) {
                        count++;
                    }
                    if (count < L) {
                        lineCheck = false;
                        break;
                    }
                    before = arr[j][i];
                    count = 1;
                }
                if (arr[j][i] < before) {
//                    if (count < L) {
//                        lineCheck = false;
//                        System.out.println("어 왔니?3 " + i + " " + j);
//                        break;
//                    }
                    if(j + L - 1 >= N) {

                        lineCheck = false;
                        break;
                    } else {
                        int now = j;
                        int nBefore = arr[j][i];
                        boolean check = false;
                        for (int k = now; k < now + L; k++) {
                            if (nBefore != arr[k][i]) {
                                check = true;
                                lineCheck = false;
                                break;
                            }
                        }
                        if (check == true) {
                            lineCheck = false;
                            break;
                        }
                        j = j + L - 1;
                        if (L == 1) {
                            count = -L;
                        } else {
                            count = 0;
                        }
                    }
                    before = arr[j][i];
                }
            }
            if (lineCheck == true) {
                result++;
            }
        }
        System.out.println(result);
    }
}