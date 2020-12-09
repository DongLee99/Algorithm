import java.util.Scanner;

public class problem7568 {
    public static void main(String[] args){
        Scanner scanf = new Scanner(System.in);

        int a = scanf.nextInt();
        int [][] tmp = new int[a][2];
        int [] tmp1 = new int[a];
        int [] rank = new int[a];
        for(int i = 0 ; i < a ; i++){
            int b = scanf.nextInt();
            int c = scanf.nextInt();
            tmp[i][0] = b;
            tmp[i][1] = c;
        }
        for (int i = 0; i < a; i++){
            rank[i] = 1;
        }
        for (int i = 0 ; i < a; i++){
            for (int j = 0; j < a; j++){
                if (i == j){
                    continue;
                }else if(tmp[i][0] < tmp[j][0] && tmp[i][1] < tmp[j][1]){
                    rank[i]++;
                }
            }
        }


        for (int i = 0; i<a; i++){
            if ( i < a-1) {
                System.out.print(rank[i] + " ");
            }else {
                System.out.print(rank[i]);
            }
        }
    }
}
