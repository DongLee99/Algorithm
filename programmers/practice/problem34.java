import java.util.*;

class Solution {

    private List<Assignment> assignments = new ArrayList<>();

    class Assignment implements Comparable<Assignment> {

        public String name;
        public int date;
        public int weight;

        public Assignment(String name, String date, int weight) {
            this.name = name;

            this.weight = weight;
            String[] dates = date.split(":");
            int hour = Integer.parseInt(dates[0]) * 60;
            int time = Integer.parseInt(dates[1]);
            this.date = hour + time;
        }

        @Override
        public int compareTo(Assignment o) {
            return date - o.date;
        }
    }
    public String[] solution(String[][] plans) {
        for (String[] plan : plans) {
            assignments.add(new Assignment(plan[0], plan[1], Integer.parseInt(plan[2])));
        }

        Collections.sort(assignments);
        // for (Assignment a : assignments) {
        //     System.out.println(a.name);
        // }
        Stack<Assignment> stop = new Stack<>();
        Stack<Assignment> stack = new Stack<>();
        int now = 0;
        for (int i = 0; i < assignments.size() - 1; i++) {
            int cur = assignments.get(i).date + assignments.get(i).weight;
            int next = assignments.get(i + 1).date;

            if (cur <= next) {
                stack.add(assignments.get(i));
                int tmpTime = next - cur;

                while (tmpTime > 0 && !stop.isEmpty()) {
                    int del = stop.peek().weight - tmpTime;
                    stop.peek().weight = Math.max(0, del);
                    if (del <= 0) {
                        tmpTime = -1 * del;
                        stack.add(stop.pop());
                    } else {
                        tmpTime = 0;
                    }
                }
            } else {
                assignments.get(i).weight = (cur - next);
                //System.out.println(assignments.get(i).name);
                stop.add(assignments.get(i));
            }
        }
        stack.add(assignments.get(assignments.size()-1));
        String[] answer = new String[assignments.size()];
        int count = 0;
        for (Assignment s : stack) {
            answer[count] = s.name;
            count++;
        }
        while(!stop.isEmpty()) {
            answer[count] = stop.pop().name;
            count++;
        }

        return answer;
    }
}
