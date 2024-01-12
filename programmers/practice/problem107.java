import java.util.*;


class Solution {
    public class Node {
        int x;
        int y;
        int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }
        int[][] tmp = new int[friends.length][friends.length];
        for (String gift : gifts) {
            String[] sGift = gift.split(" ");
            tmp[map.get(sGift[0])][map.get(sGift[1])] = tmp[map.get(sGift[0])][map.get(sGift[1])] + 1;
        }
        HashMap<Integer, Node> map2 = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            map2.put(i, new Node(0, 0, 0));
        }
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (tmp[i][j] > 0) {
                    map2.get(i).x = map2.get(i).x + tmp[i][j];
                    map2.get(j).y = map2.get(j).y + tmp[i][j];
                }
            }
        }
        for (int i = 0; i < friends.length; i++) {
            map2.get(i).z = map2.get(i).x - map2.get(i).y;
        }

        HashMap<Integer, Integer> map3 = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            map3.put(i, 0);
        }
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (i == j) {
                    continue;
                }
                if (tmp[i][j] > 0) {
                    if (tmp[i][j] > tmp[j][i]) {
                        map3.replace(i, map3.get(i) + 1);
                    } else if (map2.get(i).z > map2.get(j).z && tmp[j][i] == tmp[i][j]) {
                        map3.replace(i, map3.get(i) + 1);
                        continue;
                    }
                } else {
                    if (map2.get(i).z > map2.get(j).z && tmp[j][i] == tmp[i][j]) {
                        map3.replace(i, map3.get(i) + 1);
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < friends.length; i++) {
            answer = Math.max(answer, map3.get(i));
        }

        return answer;
    }
}