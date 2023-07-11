static class Solution {
    public int answerCount = 0;
    static class Node implements Comparable<Node> {
        public String userName;
        public int score;

        public Node(String userName, int score) {
            this.userName = userName;
            this.score = score;
        }

        @Override
        public int compareTo(Node o) {
            return this.score <= o.score ? -1 : 1;
        }
    }
    public void find(PriorityQueue<Node> nodes, String userName, int score, int K) {
        String [] first = new String[K];
        PriorityQueue<Node> tmp = new PriorityQueue<>();
        int count = 0;
        boolean check = false;
        System.out.println(nodes.size());
        System.out.println(tmp.size());
        while(!nodes.isEmpty()) {
            Node poll = nodes.poll();
            first[count] = poll.userName;
            count++;
            if (poll.userName.equals(userName)) {
                if (poll.score < score) {
                    poll.score = score;
                    check = true;
                }
            }
            tmp.add(poll);
        }
        for (Node node : tmp) {
            nodes.add(node);
        }
        for (String s : first) {
            System.out.println(s);
        }
        System.out.println(check);
        if (check) {
            count = 0;
            while(!tmp.isEmpty()) {
                Node poll = tmp.poll();
                if (!first[count].equals(poll.userName)) {
                    answerCount++;
                    break;
                }
                count++;
            }
            return;
        } else {
            Node poll = nodes.poll();
            System.out.println(userName + "   " + score);
            if (poll.score < score) {
                System.out.println("증가2" + poll.userName);
                answerCount++;
                nodes.add(new Node(userName, score));
            } else {
                nodes.add(poll);
            }
        }

    }

    public int solution(int K, String[] user_scores) {
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        int count = 0;
        for (int i = 0; i < user_scores.length; i++) {
            String[] s = user_scores[i].split(" ");
            if (count < K) {
                answerCount++;
                nodes.add(new Node(s[0], Integer.parseInt(s[1])));
                count++;
            } else {
                System.out.println("i = " + i);
                find(nodes, s[0], Integer.parseInt(s[1]), K);
            }
        }
        return answerCount;
    }
}

    public static void main(String[] args) {
        int k = 2;
        String [] user_scores = {"c 200", "a 100", "c 150", "puyo 120"};
        Solution solution = new Solution();
        System.out.println(solution.solution(k, user_scores));
    }