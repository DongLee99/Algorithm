import java.util.Scanner;

public class problem2630 {
    public static int tmp[][];
    public static int white,blue;
    public static void main(String args[]){
        Scanner scanf = new Scanner(System.in);

        int a = scanf.nextInt();
        tmp = new int[a][a];
        for (int i = 0; i<a; i++){
            for(int j = 0; j <a; j++){
                int b = scanf.nextInt();
                tmp[i][j] = b;
            }
        }
        find(0,0,a,a);

        System.out.println(white);
        System.out.print(blue);

    }
    public static void find(int startc, int startl, int endc, int endl){
        int sum = 0;
        for (int i = startc ; i<endc; i++){
            for(int j = startl; j<endl; j++){
                sum = sum + tmp[i][j];
            }
        }
        if (sum == 0){
            white++;
            return;
        }
        else if( sum == (endc - startc)*(endl-startl)){
            blue++;
            return;
        }else{
            find(startc, startl, (startc+endc)/2, (startl+endl)/2); //0 0 4 4 1
            find((startc+endc)/2, startl, endc, (startl+endl)/2); // 4 0 8 4 2
            find(startc, (startl+endl)/2, (startc+endc)/2, endl); // 0 4 4 8 3
            find((startc+endc)/2, (startl+endl)/2, endc, endl); // 4 8 4 8 4
        }
    };
}
