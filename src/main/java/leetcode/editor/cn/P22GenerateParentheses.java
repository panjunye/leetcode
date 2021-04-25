//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1746 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//java:括号生成
public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            if (n == 0) {
                return Collections.emptyList();
            }
            List<String> results = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            generate(results, sb, 0, 0, n);
            return results;
        }

        private void generate(List<String> results, StringBuilder sb, int i, int j, int n) {

            if (i < n) {
                sb.append('(');
                generate(results, sb, i + 1, j, n);
            }
            if (j < i) {
                sb.append(')');
                generate(results, sb, i, j + 1, n);
            }
            if (j == n) {
                results.add(sb.toString());
            }
            pop(sb);
        }

        private void pop(StringBuilder sb) {
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
