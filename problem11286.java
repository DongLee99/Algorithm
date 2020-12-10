import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class problem11286 {
    public static void main(String args[]){
        Scanner scanf = new Scanner(System.in);
        ArrayList<Integer> tmp = new ArrayList<>();
        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if(abs1 == abs2) return o1 > o2 ? 1 : -1;
            return abs1 - abs2;
        });;
        ArrayList<Integer> tmp2 = new ArrayList<>();
        ArrayList<Integer> tmp3 = new ArrayList<>();
        int a = scanf.nextInt();
        for (int i = 0; i < a; i++){
            int b = scanf.nextInt();
            tmp.add(b);
        }
        for (int i = 0; i<tmp.size(); i++){
            if (tmp.get(i) == 0){
                if (q.isEmpty()){
                    tmp2.add(0);
                }else{
                    tmp2.add(q.poll());
                }
            }else {
                q.add(tmp.get(i));
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
