package array.leetcode15;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = length - 1;
            int target = -nums[i];
            int temp;
            while (left < right) {
                if (nums[left] + nums[right] > target) {
                    right -= 1;
                } else if (nums[left] + nums[right] < target) {
                    left += 1;
                } else {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[left]);
                    integers.add(nums[right]);
                    lists.add(integers);
                    temp = right;
                    while (left < temp && nums[--temp] == nums[right]) ;
                    right = temp;
                    temp = left;
                    while (temp < right && nums[++temp] == nums[left]) ;
                    left = temp;
                }
            }
        }
        return lists;
    }

    @Test
    public void test01() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
