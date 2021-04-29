//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。 
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
// 
//
// 两个字符串完全匹配才算匹配成功。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
// 
//
// 示例 3: 
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
// 
//
// 示例 4: 
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
// 
//
// 示例 5: 
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输出: false 
// Related Topics 贪心算法 字符串 动态规划 回溯算法 
// 👍 666 👎 0


package leetcode.editor.cn;


import leetcode.editor.Assertions;

import java.util.Arrays;

//java:通配符匹配
public class P44WildcardMatching {
    public static void main(String[] args) {
        Solution solution = new P44WildcardMatching().new Solution();
        Assertions.isTrue(solution.isMatch("adceb", "*a*b"));
        Assertions.isFalse(solution.isMatch("acdcb", "a*c?b"));
        Assertions.isTrue(solution.isMatch("", "***"));
        Assertions.isFalse(solution.isMatch("aa", "a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            int row = p.length() + 1;
            int col = s.length() + 1;
            boolean[][] board = new boolean[row][col];
            board[0][0] = true;
            for (int i = 1; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (p.charAt(i - 1) == '*') {
                        if (board[i - 1][j]) {
                            Arrays.fill(board[i], j, col, true);
                        }
                        if (j > 0 && board[i - 1][j - 1]) {
                            board[i][j - 1] = true;
                        }
                    } else if (j > 0 && (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?')) {
                        board[i][j] = board[i - 1][j - 1];
                    }
                }
            }
            return board[row - 1][col - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
