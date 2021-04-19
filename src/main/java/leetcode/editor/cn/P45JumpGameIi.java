//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组 
// 👍 924 👎 0


package leetcode.editor.cn;

import leetcode.editor.Assertions;

import java.util.HashMap;
import java.util.Map;

//java:跳跃游戏 II
public class P45JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new P45JumpGameIi().new Solution();
        Assertions.isEqual(2, solution.jump(new int[]{2, 3, 1, 1, 4}));
        Assertions.isEqual(2, solution.jump(new int[]{2, 3, 0, 1, 4}));
        Assertions.isEqual(1, solution.jump(new int[]{2, 1}));
        Assertions.isEqual(3, solution.jump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private Map<Integer, Integer> map;

        public int jump(int[] nums) {
            int length = nums.length;
            int end = 0;
            int maxPosition = 0;
            int steps = 0;
            for (int i = 0; i < length - 1; i++) {
                maxPosition = Math.max(maxPosition, i + nums[i]);
                if (i == end) {
                    steps++;
                    end = maxPosition;
                }
            }
            return steps;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
