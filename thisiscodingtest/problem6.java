import java.io.*;
import java.util.HashMap;

public class problem {
    public static void main(String[] args) throws IOException {
        int [] dx = {2, 2, -2, -2, 1, -1, 1, -1};
        int [] dy = {1, -1, 1, -1, 2, -2, -2, 2};
        int count = 0;

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("a", 0);
        hashMap.put("b", 1);
        hashMap.put("c", 2);
        hashMap.put("d", 3);
        hashMap.put("e", 4);
        hashMap.put("f", 5);
        hashMap.put("g", 6);
        hashMap.put("h", 7);

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String buffer = bf.readLine();
        int x = hashMap.get(String.valueOf(buffer.charAt(0)));
        int y = Integer.parseInt(String.valueOf(buffer.charAt(1)));

        for (int i = 0; i < 8; i++) {
            int cx = x + dx[i];
            int cy = y - 1 + dy[i];

            if (cx >= 0 && cx < 8 && cy >= 0 && cy < 8) {
                count++;
            }
        }
        System.out.println(count);
    }
}