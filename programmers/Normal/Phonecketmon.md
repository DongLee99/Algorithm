---

# 폰켓몬(쉬움)

![](https://images.velog.io/images/donglee99/post/620d447e-6216-4148-93a2-640d41b86c69/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-05-25%20%EC%98%A4%ED%9B%84%209.02.42.png)

- 너무 쉬워서 간단한 스트림 또는 반복문을 사용해 풀수 있다.
    1. 가장 중요한것 폰켓몬의 종류수
    2. 폰켓몬의 종류가 N/2 가 넘느냐 마느냐

---

```java
import java.util.Arrays;

class Solution {
        public int solution(int[] nums) {
            int numSize = nums.length;
            int distinctNumsSize = (int) Arrays.stream(nums)
                                    .distinct()
                                    .count();
            if ((numSize / 2) > distinctNumsSize) {
                return distinctNumsSize;
            }
            return numSize/2;
        }
    } 
```

- 처음에는 모든 경우의 수를 다 찾아가면서 소거 해나가는 방법으로 풀까 고민을 했었다. 하지만 생각해보니 그렇게 어려운 문제가 아니란것을 깨달았다. 문제의 핵심은 폰켓몬의 종류수니까 결국 N보다 폰켓몬의 종류가 많은가? 정도만 알아보면 간단하게 답이 도출된다.
- 위 코드는 받아온 int 배열을 스트림을 사용해 중복제거 후 카운트 값을 찾으면 결국 폰켓몬의 종류 수가 되므로 중복 제거한 배열의 사이즈가 N/2보다 작으면 distinctNumSize를 리턴하고 그렇지 않을시 N/2 를 리턴해주었다.

---

# 회고

문제를 보고 쫄지말자 처음에 DFS 를 통해 모든 경우를 다 찾아볼까 라는 어리석은 생각을 하면서 시간을 좀 보냈지만 결국 엄청 쉬운 문제였다.