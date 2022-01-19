import java.util.*;

public class problem {
    static String num1 = "";
    static int buf = 0;
    static int result = 0;
    static int count = 0;
    static List<String> numbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String next = scanner.next();

        for (int i = 0; i < next.length(); i++) {
            if (next.charAt(i) == '+' || next.charAt(i) == '-') {
                numbers.add(num1);
                if (next.charAt(i) == '-') {
                    numbers.add(String.valueOf(next.charAt(i)));
                }
                num1 = "";
            } else {
                num1 = num1 + next.charAt(i);
            }
        }
        numbers.add(num1);

        for (int i = 0; i < numbers.size(); i++) {
            if (i == 0 && !numbers.get(0).equals("-")) {
                result = result + Integer.parseInt(numbers.get(0));
                continue;
            }

            if (numbers.get(i).equals("-")) {
                for (int j = i + 1; j < numbers.size(); j++) {
                    if (!numbers.get(j).equals("-")) {
                        buf = buf + Integer.parseInt(numbers.get(j));
                        count++;
                    } else {
                        break;
                    }
                }
                i = i + count;
                count = 0;
                result = result - buf;
                buf = 0;
            } else {
                result = result + Integer.parseInt(numbers.get(i));
            }
        }
        System.out.println(result);
    }
}
