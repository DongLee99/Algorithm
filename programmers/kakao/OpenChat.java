import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static String[] solution(String[] record) {
        Map<String, String> list = new HashMap<>();
        List<String> listS = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (String s : record) {
            String[] s1 = s.split(" ");
            String first = s1[0];
            String second = s1[1];
            //System.out.println(first);
            if (first.equals("Enter")) {
                listS.add(first);
                list1.add(second);
                String third = s1[2];
                list.put(second, third);
            }
            if (first.equals("Leave")) {
                list1.add(second);
                listS.add(first);
            }
            if (first.equals("Change")) {
                String third = s1[2];
                //System.out.println(list.get(second));
                list.replace(second, third);
            }
        }
        for (int i = 0; i < listS.size(); i++) {
            if (listS.get(i).equals("Enter")) {
                result.add(list.get(list1.get(i)) + "님이 들어왔습니다.");
            }
            if (listS.get(i).equals("Leave")) {
                result.add(list.get(list1.get(i)) + "님이 나갔습니다.");
            }
        }
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String [] list = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] solution = Solution.solution(list);
        for (String s : solution) {
            System.out.println(s);
        }
    }

}
