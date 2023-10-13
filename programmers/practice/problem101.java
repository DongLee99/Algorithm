import java.util.*;

public class Main {

    public static class Solution {
        public static String makeM(String m) {
            String mX = "";
            for (int i = 0; i < m.length() - 1; i++) {
                if (m.charAt(i) >= 65 && m.charAt(i) <= 90) {
                    if (m.charAt(i+1) == '#') {
                        mX =  mX + "/" + m.charAt(i) + "#";
                        i++;
                    } else {
                        mX = mX + m.charAt(i);
                    }
                }
            }
            if (m.charAt(m.length()-1) != '#') {
                mX = mX +m.charAt(m.length()-1);
            }
            return mX;
        }
        public static String solution(String m, String[] musicinfos) {
            String mX = makeM(m);
            for (int i = 0; i < musicinfos.length; i++) {
                String[] musicinfo = musicinfos[i].split(",");
                String[] split = musicinfo[0].split(":");
                String[] split1 = musicinfo[1].split(":");
                int time = (Integer.parseInt(split1[0]) * 60 + Integer.parseInt(split1[1])) - (Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]));
                Queue<String> queue = new LinkedList<>();
                for (int j = 0; j < musicinfo[3].length(); j++) {
                    queue.add(musicinfo[3].charAt(j) +"");
                }
                String qX = "";
                for (int j = 0; j < time; j++) {
                    String tmp = queue.peek();
                    qX = qX + queue.poll();
                    queue.add(tmp);
                }
                qX = makeM(qX);
                if (qX.contains(mX)) {
                    System.out.println(qX);
                    System.out.println(mX);
                    return musicinfo[2];
                }
            }
            String answer = "";
            return answer;
        }
    }
    public static void main(String[] args) {
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(Solution.solution("ABC", musicinfos));
    }
}