package array.leetcode1;
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//
//
// 示例 3：
//
//
//输入：nums = [3,3], target = 6
//输出：[0,1]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 103
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// 只会存在一个有效答案
//
// Related Topics 数组 哈希表
// 👍 10113 👎 0

//https://leetcode-cn.com/problems/two-sum/
import org.junit.Test;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return new int[]{-1, -1};
        HashSet<Integer> integers = new HashSet<>();
        integers.add(nums[0]);
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        integerIntegerHashMap.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int targetNums = target - nums[i];
            if (integers.contains(targetNums)) {
                return new int[]{integerIntegerHashMap.get(targetNums), i};
            }
            integerIntegerHashMap.put(nums[i], i);
            integers.add(nums[i]);
        }
        return new int[]{-1, -1};
    }

    @Test
    public void test01() {
        int[] nums = {3, 2, 4};
        int[] ints = twoSum(nums, 6);
        for (int anInt : ints) {
            System.out.print(anInt + "\t");
        }
    }
}
