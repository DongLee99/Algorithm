/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class problem11650 {
    public static void main(String args[]) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언

        int a = Integer.parseInt(bf.readLine().trim());
        int[][] tmp = new int[a][2];
        String[] str = new String[2];
        int txt1 = 0;
        int txt2 = 0;
        for (int i = 0; i < a; i++) {
            str = bf.readLine().split(" ");
            tmp[i][0] =Integer.parseInt(str[0]);
            tmp[i][1] = Integer.parseInt(str[1]);
        }

        for (int i = 0; i<a; i++){
            for (int j = i+1; j<a; j++){
                if(tmp[i][0] > tmp[j][0]){
                    txt1 =tmp[i][0];
                    tmp[i][0] =tmp[j][0];
                    tmp[j][0] =txt1;
                    txt2 =tmp[i][1];
                    tmp[i][1] =tmp[j][1];
                    tmp[j][1] =txt2;
                }
                if(tmp[i][0] == tmp[j][0]){
                    if(tmp[i][1] > tmp[j][1]){
                        txt2 = tmp[i][1];
                        tmp[i][1] =tmp[j][1];
                        tmp[j][1]=txt2;
                    }
                }
            }
        }

        for(int i = 0; i<a;i++){
            System.out.print(tmp[i][0] + " ");
            System.out.println(tmp[i][1]);
        }
    }
}
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.io.IOException;
public class problem11650 {
    public static void main(String args[]) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언

        int a = Integer.parseInt(bf.readLine().trim());
        int[][] tmp = new int[a][2];
        String[] str = new String[2];
        int txt1 = 0;
        int txt2 = 0;
        for (int i = 0; i < a; i++) {
            str = bf.readLine().split(" ");
            tmp[i][0] = Integer.parseInt(str[0]);
            tmp[i][1] = Integer.parseInt(str[1]);
        }
        Arrays.sort(tmp, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                if (x[0] == y[0]) {
                    return Integer.compare(x[1], y[1]);
                }
                return Integer.compare(x[0], y[0]);
            }

        });
        for (int i = 0; i < a; i++) {
            System.out.println(tmp[i][0] + " " + tmp[i][1]);
        }
    }
}