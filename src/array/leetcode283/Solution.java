package array.leetcode283;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 910 👎 0

//https://leetcode-cn.com/problems/move-zeroes/submissions/
import org.junit.Test;

public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[right] == 0 || left > right) {
                right += 1;
            } else if (nums[left] != 0) {
                left += 1;
            } else {
                nums[left] = nums[right];
                nums[right] = 0;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if(nums[right] != 0){
                nums[left] = nums[right];
                if(left != right){
                    nums[right] = 0;
                }
                left += 1;
            }
        }
    }

    @Test
    public void test01() {
        int[] nums = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        moveZeroes2(nums);
        for (int num : nums) {
            System.out.print(num + "\t");
        }
    }
}
