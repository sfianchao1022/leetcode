package leetcode.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * 3. Longest Substring Without Repeating Characters
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        int i = 0, j = 0, max = 0;
        Set<Character> subString = new HashSet<>();

        while (i < s.length()) {
            char rear = s.charAt(i);
            if (!subString.contains(rear)) {
                subString.add(rear);
                max = Math.max(subString.size(), max);
                i++;
            } else {
                char front = s.charAt(j);
                subString.remove(front);
                j++;
            }
        }

        return max;
    }


}
