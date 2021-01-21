package array.leetcode66;
//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//
//
// 示例 1：
//
//
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
//
//
// 示例 2：
//
//
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
//
//
// 示例 3：
//
//
//输入：digits = [0]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= digits.length <= 100
// 0 <= digits[i] <= 9
//
// Related Topics 数组
// 👍 615 👎 0

//https://leetcode-cn.com/problems/plus-one/
import org.junit.Test;

public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null)
            return null;
        int temp = 1;
        for (int i = digits.length - 1; i >= 0 && temp != 0; i--) {
            temp = (digits[i] + 1) / 10;
            digits[i] = (digits[i] + 1) % 10;
        }
        if (temp != 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

    @Test
    public void test01() {
        int[] ints = {1, 2, 3};
        ints = plusOne(ints);
        for (int anInt : ints) {
            System.out.print(anInt + "\t");
        }
    }
}
