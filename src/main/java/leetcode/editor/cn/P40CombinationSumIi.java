//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 564 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P40CombinationSumIi {
    public static void main(String[] args) {
        P40CombinationSumIi.Solution solution = new P40CombinationSumIi().new Solution();
        List<List<Integer>> answers = solution.combinationSum2(new int[]{2,5,2,1,2}, 5);
        System.out.println(answers);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> answers = new ArrayList<>();
            List<Integer> combine = new ArrayList<>();
            Arrays.sort(candidates);
            dfs(candidates, target, answers, combine, 0);
            return answers;
        }

        private void dfs(int[] candidates, int target, List<List<Integer>> answers, List<Integer> combine, int idx) {
            if (target == 0) {
                answers.add(new ArrayList<>(combine));
                return;
            }
            if (idx == candidates.length) {
                return;
            }
            int idy;
            for (idy = idx + 1; idy < candidates.length; idy++) {
                if (candidates[idy] != candidates[idx]) {
                    break;
                }
            }
            dfs(candidates, target, answers, combine, idy);
            int candidate = candidates[idx];
            if (target - candidate >= 0) {
                combine.add(candidate);
                dfs(candidates, target - candidate, answers, combine, idx+1);
                combine.remove(combine.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}