import java.util.*;

class Solution {
    public static HashMap<Long, Long> room = new HashMap<>();

    public static long findEmptyRoom(long x) {
        if (!room.containsKey(x)) {
            room.put(x, x+1);
            return x;
        }
        long nextRoom = room.get(x);
        long emptyRoom = findEmptyRoom(nextRoom);
        room.put(x, emptyRoom);
        return emptyRoom;
    }
    public long[] solution(long k, long[] room_number) {


        long [] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++) {
            answer[i] = findEmptyRoom(room_number[i]);
        }
        return answer;

    }
}