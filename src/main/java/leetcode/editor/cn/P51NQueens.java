//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 849 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//java:N 皇后
public class P51NQueens {
    public static void main(String[] args) {
        Solution solution = new P51NQueens().new Solution();
        System.out.println(solution.solveNQueens(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            if (n == 0) {
                return Collections.emptyList();
            }
            List<List<String>> results = new ArrayList<>(n);
            int[] rows = new int[n];
            StringBuilder sb = new StringBuilder();
            putNextRow(rows, sb, results, 0, n);
            return results;
        }

        public void putNextRow(int[] rows, StringBuilder sb, List<List<String>> results, int r, int n) {
            if (r == n) {
                List<String> result = new ArrayList<>(n);
                for (int i = 0; i < rows.length; i++) {
                    sb.delete(0, sb.length());
                    int j = 0;
                    for (j = 0; j < rows[i]; j++) {
                        sb.append('.');
                    }
                    sb.append('Q');
                    for (j = j + 1; j < n; ++j) {
                        sb.append('.');
                    }
                    result.add(sb.toString());
                }
                results.add(result);
            } else {
                for (int i = 0; i < n; i++) {
                    rows[r] = i;
                    if (isOk(rows, r)) {
                        putNextRow(rows, sb, results, r + 1, n);
                    }
                }
            }
        }

        private boolean isOk(int[] rows, int r) {
            int col = rows[r];
            for (int i = 0; i < r; i++) {
                if (rows[i] == col) {
                    return false;
                }
                if (rows[i] == (col + r - i) || rows[i] == (col - r + i)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
