package leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 13. Roman to Integer
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {

//        Map<Character, Integer> map = Map.ofEntries(
//                entry('I', 1),
//                entry('V', 5),
//                entry('X', 10),
//                entry('L', 50),
//                entry('C', 100),
//                entry('D', 500),
//                entry('M', 1000)
//        );
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = map.get(s.charAt(s.length() - 1));

        for (int i = s.length() - 1; i > 0; i--) {
            char current = s.charAt(i);
            char next = s.charAt(i - 1);
            if (map.get(next) < map.get(current)) {
                ans -= map.get(next);
            } else {
                ans += map.get(next);
            }
        }

        return ans;
    }


}
