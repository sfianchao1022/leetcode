package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * 15. 3Sum
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] > sum) {
                        high--;
                    } else if (nums[low] + nums[high] < sum) {
                        low++;
                    } else if (nums[low] + nums[high] == sum) {
                        ans.add(Arrays.asList(nums[low], nums[high], nums[i]));
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        high--;
                        low++;
                    }
                }
            }
        }

        return ans;
    }

}
