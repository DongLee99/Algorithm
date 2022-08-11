import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> hashMap = new HashMap<>();
        List<String> names = new ArrayList<>();
        int count = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String name = sc.nextLine();
            if (name.isEmpty()) {
                break;
            }
            if (hashMap.containsKey(name)) {
                hashMap.replace(name, hashMap.get(name) + 1);
            } else {
                names.add(name);
                hashMap.put(name, 1);
            }
            count++;
        }
        Collections.sort(names);
        for (String value : names) {
            double status = hashMap.get(value);
            double result = status / count * 100;
            System.out.println(value + " " + String.format("%.4f", result));
        }
    }
}