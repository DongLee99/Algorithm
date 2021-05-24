import java.util.Scanner;

public class problem1485 {
    static boolean result = false;
    public static boolean search(int tmp[][], int i){
        result = false;
         if (Math.pow(tmp[4*i -3][1]-tmp[4*i -4][1],2) + Math.pow(tmp[4*i -3][0]-tmp[4*i -4][0],2) == Math.pow(tmp[4*i -1][1]-tmp[4*i -2][1],2) + Math.pow(tmp[4*i -1][0]-tmp[4*i -2][0],2)){
            if (Math.pow(tmp[4*i -2][1]-tmp[4*i -3][1],2) + Math.pow(tmp[4*i -2][0]-tmp[4*i -3][0],2)== Math.pow(tmp[4*i -4][1]-tmp[4*i -1][1],2) + Math.pow(tmp[4*i -4][0]-tmp[4*i -1][0],2)){
                if(Math.pow(tmp[4*i-2][0]-tmp[4*i-4][0],2)+Math.pow(tmp[4*i-2][1]-tmp[4*i-4][1],2) ==Math.pow(tmp[4*i-1][0]-tmp[4*i-3][0],2)+Math.pow(tmp[4*i-1][1]-tmp[4*i-3][1],2) ){
                    result = true;
                }

            }
        }
        return result;
    }
    public static void main(String args[]){
        Scanner scanf = new Scanner(System.in);
        int first = scanf.nextInt();

        int [][] tmp = new int[4*first][2];
        int cnt = 0;
        for (int i = 0 ; i < first; i ++ ) {
            for (int j = 0; j < 4; j++) {
                int x = scanf.nextInt();
                int y = scanf.nextInt();
                tmp[cnt][0] = x;
                tmp[cnt][1] = y;
                cnt ++;
            }
        }
        for (int i = 0 ; i<first; i++){
            if (search(tmp,i+1) == true){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}
