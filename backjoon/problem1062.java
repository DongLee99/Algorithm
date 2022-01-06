import java.util.ArrayList;
import java.util.Scanner;

public class problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int k = scanner.nextInt();

        if (k < 5) {
            System.out.println(0);
            return;
        }
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> know = new ArrayList<>();

        for (int i = 0; i < x; i++) {
            String next = scanner.next();
            String[] antas = next.split("anta");
            String[] ticas = antas[1].split("tica");
            strings.add(ticas[0]);
        }
        know.add("a");
        know.add("n");
        know.add("t");
        know.add("i");
        know.add("c");

        for (int i = 0; i < x; i++) {
            String s = strings.get(i);
            for (int j = 0; j < know.size(); j++) {
                if (s.contains(know.get(j))) {
                    String replace = s.replace(know.get(j), "");
                    s = replace;
                }
            }
            strings.remove(i);
            strings.add(s);
        }
        know.clear();

        for (int i = 0; i < x; i++) {
            String s = strings.get(i);
            for (int j = 0; j < s.length(); j++) {
                know.add(String.valueOf(s.charAt(j)));
            }
        }
        know.stream()
                .distinct();

    }
}
