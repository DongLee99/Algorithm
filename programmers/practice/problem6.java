import java.util.*;
import java.text.SimpleDateFormat;

class Solution {

    class Car {
        public String startTime;
        public long value;

        public Car(String startTime, int value) {
            this.startTime = startTime;
            this.value = value;
        }
    }

    public int[] solution(int[] fees, String[] records) {
        List<String> carList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        HashMap<String, Car> map = new HashMap<String, Car>();
        int [] answer = new int [0];
        try {
            for (String record : records) {
                String [] values = record.split(" ");
                if (map.containsKey(values[1])) {
                    Car car = map.get(values[1]);
                    if (car.startTime.equals("")) {
                        car.startTime = values[0];
                    } else {
                        Date date1 = sdf.parse(car.startTime);
                        Date date2 = sdf.parse(values[0]);
                        long timeMil1 = date1.getTime();
                        long timeMil2 = date2.getTime();
                        long diff = timeMil2 - timeMil1;
                        long diffMin = diff / (1000 * 60);
                        car.startTime = "";
                        car.value = car.value + diffMin;
                    }
                } else {
                    map.put(values[1], new Car(values[0], 0));
                    carList.add(values[1]);
                }
            }

            Collections.sort(carList);
            answer = new int [carList.size()];
            int countN = 0;
            for (String car : carList) {
                Car getCar = map.get(car);
                if (!getCar.startTime.equals("")) {
                    String outTime = "23:59";
                    Date date1 = sdf.parse(getCar.startTime);
                    Date date2 = sdf.parse(outTime);
                    long timeMil1 = date1.getTime();
                    long timeMil2 = date2.getTime();
                    long diff = timeMil2 - timeMil1;
                    long diffMin = diff / (1000 * 60);
                    getCar.startTime = "";
                    getCar.value = getCar.value + diffMin;
                }
                System.out.println(car);
                if (fees[0] >= getCar.value) {
                    System.out.println(fees[1]);
                    answer[countN] = (int) fees[1];
                } else {
                    long count = 0;
                    if (((getCar.value - fees[0]) % fees[2]) != 0) {
                        count = ((getCar.value - fees[0]) / fees[2]) + 1;
                    } else {
                        count = ((getCar.value - fees[0]) / fees[2]) ;
                    }
                    System.out.println(fees[1] + (count * fees[3]));
                    answer[countN] = (int) (fees[1] + (count * fees[3]));
                }
                countN++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return answer;
    }
}