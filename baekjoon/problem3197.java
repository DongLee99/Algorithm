import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class problem2{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int [] ax = {-1, 1, 0, 0};
        int [] ay = { 0, 0, -1, 1};
        String [][] temp1 = new String[x+1][y+1];
        String [][] temp2 = new String[x+1][y+1];

        for (int i = 0; i < x; i++) {
            String buf = scanner.next();
            for (int j = 0; j < y; j++) {
                temp1[i][j] = String.valueOf(buf.charAt(j));
                temp2[i][j] = temp1[i][j];
            }
        }
        System.out.println("clear");

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (temp1[i][j].equals("X")) {
                    for (int k = 0; k < 4; k++) {
                        int ix = i + ax[k];
                        int iy = j + ay[k];
                        if (ix >= 0 && iy >= 0 && ix < x && iy <y ) {
                            if (temp1[ix][iy].equals(".")) {
                                temp2[i][j] = ".";
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(temp2[i][j]);
            }
            System.out.println();
        }
    }


}