import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
public class problem1337 {
    public static void main(String []args){
        Scanner scanf = new Scanner(System.in);
        int a = scanf.nextInt();
        int [] tmp = new int [a];
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0 ; i< a; i ++){
            int b = scanf.nextInt();
            tmp[i] = b;
        }
        if (a == 1){
            System.out.print(4);
            return;
        }
        Arrays.sort(tmp);
        int cnt = 0;
        for (int i = 0; i<a; i++){
            cnt = 0;
            for (int j = i+1; j<a; j++){
                if (tmp[j] - tmp[i] == 4){
                    cnt = 0;
                    for (int k = i; k <=j ; k++){
                        if (tmp[i] <= tmp[k] && tmp[k] <= tmp[j]){
                            cnt ++;
                        }
                    }
                    result.add(5-cnt);
                }
                else if (tmp[j] - tmp[i] <4 ){
                    cnt = 0;
                    for (int k = i; k <=j ; k++){
                        if (tmp[i] <= tmp[k] && tmp[k] <= tmp[j]){
                            cnt ++;
                        }
                    }
                    result.add(5-cnt);
                }
                else {
                    result.add(5);
                }
            }

        }
        Collections.sort(result);
        System.out.print(result.get(0));

    }
}
