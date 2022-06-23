package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 242. Valid Anagram
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Long> map1 = new HashMap<>();
        Map<Character, Long> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            map1.put(c1, map1.getOrDefault(c1, 0L) + 1);
            map2.put(c2, map2.getOrDefault(c2, 0L) + 1);
        }

        for (char key : map1.keySet()) {
            if (!map2.containsKey(key)) {
                return false;
            } else if (!map1.get(key).equals(map2.get(key))) {
                return false;
            }
        }
        return true;
    }
}
