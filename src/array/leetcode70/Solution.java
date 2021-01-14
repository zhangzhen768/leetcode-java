package array.leetcode70;
//https://leetcode-cn.com/problems/climbing-stairs/submissions/
import org.junit.Test;

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划
// 👍 1414 👎 0
public class Solution {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int left = 1;
        int right = 2;
        int nums = 0;
        for (int i = 3; i <= n; i++) {
            nums = left + right;
            left = right;
            right = nums;
        }
        return nums;
    }

    @Test
    public void test01(){
        System.out.println(climbStairs(10));
    }
}
