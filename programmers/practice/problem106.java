class Solution {
    public static int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0;
        int first = health;
        int continuityTime = 0;
        int index = 0;

        while(index <= attacks.length -1) {
            time++;
            if (index >= attacks.length) {
                break;
            } else if (attacks[index][0] == time) {
                //System.out.println(time);
                continuityTime = 0;
                if (health - attacks[index][1] > 0) {
                    health = health - attacks[index][1];
                } else {
                    return -1;
                }
                index++;
            } else {
                continuityTime++;
                if (first > health) {
                    health = health + bandage[1];
                    if (continuityTime == bandage[0]) {
                        health = health + bandage[2];
                        continuityTime = 0;
                    }
                    if (first < health) {
                        health = first;
                    }
                } else {
                    if (continuityTime == bandage[0]) {
                        continuityTime = 0;
                    }
                }
            }
        }
        return health;
    }
}