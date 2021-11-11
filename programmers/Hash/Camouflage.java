public int solution(String[][] clothes) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
        if (hashMap.containsKey(clothes[i][1])) {
        hashMap.replace(clothes[i][1], hashMap.get(clothes[i][1]) + 1);
        } else {
        hashMap.put(clothes[i][1], 1);
        }
        }
        Iterator<Integer> iterator = hashMap.values().iterator();
        int result = 1;
        while(iterator.hasNext()) {
        result = result * (iterator.next() + 1);
        }
        return result - 1;
        }