package array.leetcode17;

import org.junit.Test;

public class Solution {
    public int maxArea(int[] height) {
        int maxAreas = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (maxAreas < Math.min(height[left], height[right]) * (right - left)) {
                maxAreas = Math.min(height[left], height[right]) * (right - left);
            }
            if (height[left] < height[right]) {
                int temp = left + 1;
                while (height[temp] <= height[left] && temp < right) {
                    temp += 1;
                }
                left = temp;
            } else {
                int temp = right - 1;
                while (height[temp] <= height[right] && temp > left) {
                    temp -= 1;
                }
                right = temp;
            }
        }
        return maxAreas;
    }

    @Test
    public void test01() {
        int[] nums = {4, 3, 2, 1, 4};
        System.out.println(maxArea(nums));
    }
}
