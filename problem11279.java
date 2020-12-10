import java.util.ArrayList;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ArrayList;
public class problem11279 {
    public static void main(String args[]){
        Scanner scanf = new Scanner(System.in);
        int [] c = new int [3];
        Queue<Integer> q = new PriorityQueue<>();
        ArrayList<Integer> tmp1 = new ArrayList<>();
        ArrayList<Integer> tmp2 = new ArrayList<>();
        int a = scanf.nextInt();
        for (int i = 0; i < a; i++) {
            int b = scanf.nextInt();
            tmp1.add(b);
        }
        for(int i = 0; i<a; i++){
            if (tmp1.get(i) == 0){
                if(q.isEmpty()){
                    tmp2.add(0);
                }else{
                    tmp2.add(q.poll()*(-1));
                }
            }else {
                q.add(tmp1.get(i)*-1);
            }

        }
        for(int i = 0; i < tmp2.size(); i++) {
            if ( i == tmp2.size()-1){
                System.out.print(tmp2.get(i));
            }else {
                System.out.println(tmp2.get(i));
            }
        }
    }
}
