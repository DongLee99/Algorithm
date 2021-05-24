import java.util.*;
import java.util.Queue;


public class problem18258 {
    public static void main(String args[]) {
        Scanner scanf = new Scanner(System.in);
        int a = scanf.nextInt();
        scanf.nextLine();
        Queue<Integer> tmp = new LinkedList<Integer>();
        Stack<String> tmp1 = new Stack<>();
        Stack<Integer> tmp2 = new Stack<>();
        int cnt = 0;
        for (int i = 0; i< a; i++){

            String text = scanf.next();

            problem18258 que = new problem18258();
            if(text.equals("push") ) {
                tmp1.add(text);
                int b = scanf.nextInt();

                tmp2.add(b);
            }else {
                tmp1.add(text);
            }



        }
        int rear = 0;
        for (int i = 0; i<a; i++){
            if(i != a-1) {
                problem18258 que = new problem18258();
                if (tmp1.get(i).equals("push")) {
                    tmp.add(tmp2.get(cnt));
                    cnt++;
                    rear = tmp2.get(cnt - 1);
                } else if (tmp1.get(i).equals("pop")) {
                    if (!tmp.isEmpty()) {
                        System.out.print(tmp.poll() + "\n");
                    } else {
                        System.out.print(-1 + "\n");
                    }
                } else if (tmp1.get(i).equals("empty")) {
                    if (tmp.isEmpty()) {
                        System.out.print(1 + "\n");
                    } else {
                        System.out.print(0 + "\n");
                    }
                } else if (tmp1.get(i).equals("size")) {
                    System.out.print(tmp.size() + "\n");
                } else if (tmp1.get(i).equals("front")) {
                    if (!tmp.isEmpty()) {
                        System.out.print(tmp.peek() + "\n");
                    } else {
                        System.out.print(-1 + "\n");
                    }
                } else if (tmp1.get(i).equals("back")) {
                    if (!tmp.isEmpty()) {
                        System.out.print(rear + "\n");
                        //back 명령어 입력 시 push에서 저장된 rear값을 출력
                    } else {
                        System.out.print(-1 + "\n");
                    }
                }
            }else {
                problem18258 que = new problem18258();
                if (tmp1.get(i).equals("push")) {
                    tmp.add(tmp2.get(cnt));
                    cnt++;
                    rear = tmp2.get(cnt - 1);
                } else if (tmp1.get(i).equals("pop")) {
                    if (!tmp.isEmpty()) {
                        System.out.print(tmp.poll() );
                    } else {
                        System.out.print(-1 );
                    }
                } else if (tmp1.get(i).equals("empty")) {
                    if (tmp.isEmpty()) {
                        System.out.print(1);
                    } else {
                        System.out.print(0);
                    }
                } else if (tmp1.get(i).equals("size")) {
                    System.out.print(tmp.size());
                } else if (tmp1.get(i).equals("front")) {
                    if (!tmp.isEmpty()) {
                        System.out.print(tmp.peek());
                    } else {
                        System.out.print(-1);
                    }
                } else if (tmp1.get(i).equals("back")) {
                    if (!tmp.isEmpty()) {
                        System.out.print(rear);
                        //back 명령어 입력 시 push에서 저장된 rear값을 출력
                    } else {
                        System.out.print(-1);
                    }
            }

        }
    }
}}
