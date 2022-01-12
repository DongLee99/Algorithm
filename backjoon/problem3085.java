import java.util.Scanner;

public class problem {
    public static int size;
    public static int count = 0;
    public static int max = 0;

    public static void check(String [][] arrays) {
        int smax = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arrays[i][j].equals(arrays[i][j+1])) {
                    count++;
                } else {
                    if (count > smax) {
                        smax = count;
                    } else {
                        count = 0;
                    }
                }
            }
            if (smax > max) {
                max = smax;
            }
            count = 0;
            smax = 0;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arrays[j][i].equals(arrays[j + 1][i])) {
                    count++;
                } else {
                    if (count > smax) {
                        smax = count;
                    } else {
                        count = 0;
                    }
                }
            }
            if (smax > max) {
                max = smax;
            }
            count = 0;
            smax = 0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        size = scanner.nextInt();
        String [][] arrays = new String[size+1][size+1];

        for (int i = 0; i < size; i++) {
            String candy = scanner.next();
            for (int j = 0; j < size; j++) {
                arrays[i][j] = String.valueOf(candy.charAt(j));
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size-1; j++) {
                String tmp = arrays[i][j];
                arrays[i][j] = arrays[i][j+1];
                arrays[i][j+1] = tmp;
                check(arrays);
                tmp = arrays[i][j];
                arrays[i][j] = arrays[i][j+1];
                arrays[i][j+1] = tmp;
            }
        }

        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size; j++) {
                String tmp = arrays[i][j];
                arrays[i][j] = arrays[i+1][j];
                arrays[i+1][j] = tmp;
                check(arrays);
                tmp = arrays[i][j];
                arrays[i][j] = arrays[i+1][j];
                arrays[i+1][j] = tmp;
            }
        }
        System.out.println(max+1);
    }
}
