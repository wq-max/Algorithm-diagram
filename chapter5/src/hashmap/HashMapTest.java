package hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("apple", 4);
        hashMap.put("banana", 6);
        System.out.println(hashMap);
        System.out.println(hashMap.get("apple"));
        System.out.println(hashMap.get("test"));
    }
}
