import java.io.*;
import java.util.Arrays;

class Main {
    public static int[] arr;

    public static void find(int start, int size) {
        if (size < 3) {
            return;
        }
        int tmpSize = size/3;
        find(start, tmpSize);
        for (int i = start + tmpSize; i < start + (tmpSize * 2); i++) {
            arr[i] = 0;
        }
        find(start + (2 * tmpSize), tmpSize);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while ((str = br.readLine()) != null) {
            int size = (int) Math.pow(3, Integer.parseInt(str));
            arr = new int[size];
            Arrays.fill(arr, 1);
            find(0, size);
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) {
                    bw.write("-");
                } else {
                    bw.write(" ");
                }
            }
            bw.flush();
            System.out.println();
        }
    }
}

