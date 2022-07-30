package leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Solution {

    /**
     * 58. Length of Last Word
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                break;
            } else {
                s = s.substring(0, i);
            }
        }

        String last = s.substring(s.lastIndexOf(' ') + 1);
        System.out.println(last);
        return last.length();
    }

    /**
     * 242. Valid Anagram
     *
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
