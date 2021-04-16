//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心算法 数组 
// 👍 1146 👎 0


package leetcode.editor.cn;

import java.util.Map;

import static leetcode.editor.Assertions.isEqual;

//java:跳跃游戏
public class P55JumpGame {
    public static void main(String[] args) {
        Solution solution = new P55JumpGame().new Solution();
        isEqual(true, solution.canJump(new int[]{2, 3, 1, 1, 4}));
        isEqual(false, solution.canJump(new int[]{3, 2, 1, 0, 4}));
        isEqual(true, solution.canJump(new int[]{0}));
        isEqual(true, solution.canJump(new int[]{2, 5, 0, 0}));
        isEqual(false, solution.canJump(new int[]{5, 4, 3, 2, 1, 0, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private Map<Integer, Boolean> jumpMap;

        public boolean canJump(int[] nums) {
            int maxReach = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > maxReach) {
                    return false;
                }
                maxReach = Math.max(maxReach, i + nums[i]);
            }
            return maxReach >= nums.length - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
