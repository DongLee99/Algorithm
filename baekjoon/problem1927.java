import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.PriorityQueue;

public class problem1927 {
    public static void main(String args[]){
        Scanner scanf = new Scanner(System.in);
        int a = scanf.nextInt();
        int [] tmp = new int[a];
        Queue<Integer> q = new PriorityQueue<>();
        ArrayList<Integer> tmp2 = new ArrayList<>();
        for (int i = 0; i < a; i++){
            int b = scanf.nextInt();
            tmp[i] = b;
        }
        for (int i = 0; i < a; i++){
            if (tmp[i] == 0){
                if(q.isEmpty()){
                    tmp2.add(0);
                }else {
                    tmp2.add(q.poll());
                }
            }else {
                q.add(tmp[i]);
            }
        }
        for (int i = 0; i < tmp2.size(); i ++){
            if (tmp2.size()-1 == i){
                System.out.print(tmp2.get(i));
            }else {
                System.out.println(tmp2.get(i));
            }
        }
    }
}
