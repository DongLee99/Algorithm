---

# 기능 개발 (Queue)

![](https://images.velog.io/images/donglee99/post/11d9709b-bcc0-4fc4-8e65-4292fe64292a/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-05-24%20%EC%98%A4%ED%9B%84%2010.16.45.png)

- 자바로 간단한 큐를 사용해 풀어보았다.

    ☝️ 조건 

    해당 조건이 들어왔을때 이전에 들어온 작업이 끝나지 않는다면 이후 들어온 작업이 끝나도 배포가 불가능 → 선입 선출 

    → 큐

    ( 자바 스터디를 진행했었기에 최대한 자바 컨벤션을 지키면서 풀어보고 싶었으나 아직 미흡 하여 생각처럼 잘 진행 되지 않았다. )

---

# 코드

```java
import java.util.*;
class Solution {
        class process {
            int value = 0;
            int weight = 0;

            public process(int value, int weight) {
                this.value = value;
                this.weight = weight;
            }

            public void changeValue() {
                this.value = value + weight;
            }

            public int getValue() {
                return value;
            }
        }
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<process> progressQueue = new LinkedList<>();
            List<Integer> answer = new LinkedList<>();
            int count = 0;
            for (int index = 0; index < progresses.length; index++) {
                progressQueue.add(new process(progresses[index], speeds[index]));
            }

            while (!progressQueue.isEmpty()) {
                progressQueue.stream()
                        .forEach(process::changeValue);
                for (process process : progressQueue) {
                    if (process.getValue() >= 100) {
                        System.out.println(process.getValue());
                        count++;
                    } else {
                        break;
                    }
                }
                for (int i = 0 ; i < count; i++) {
                    progressQueue.poll();
                }
                if (count != 0) {
                    answer.add(count);
                }
                count = 0;

            }
            int [] result = new int [answer.size()];
            for (int i = 0; i <answer.size(); i++) {
                    result[i] = answer.get(i);
            }
            return result;
        }
    }
```

- 우선 작업 (process) 클래스를 만들어 큐에 넣어 주도록 했다.
- process 의 상태에는 값과 가중치를 갖고 값에 가중치만큼 증가시키는 change 행위를 만들어 주었다.
- 입력 받은 작업들을 토대로 큐를 생성하고 큐가 비어질때까지 반복문을 돌리며 1일이 지날수록 가중치만큼 현재 완료치 값을 변경시켜 준다.
- 이때 만약 첫번째 값이 완료 된다면 순회를 통해 완료된 값들을 찾아 count 를 증가시키고 큐에서 poll() 을 해준다. ( 중간값중 앞값이 완료가 되지 않은 값이 있다면 break )

---

# 회고

문제는 맞았지만 아쉬운 점이 너무 많다 지금도 당장 고쳐야 할 부분이 많이 보이지만 나중에 돌아봤을때 이런점을 내가 이렇게 짰었구나 되돌아보기위해 고치지 않을 것이다. 또한 최대한 자바 컨벤션을 지키며 해볼려했지만 당장 문제 푼다는 것에 초점을 두어 그렇지 못했다... 다음 문제부터는 컨벤션을 지키며 자바를 사용한 만큼 객체 지향적인 코드를 짤 수 있도록 노력해보겠다.