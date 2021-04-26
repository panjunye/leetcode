//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
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
// 👍 254 👎 0


package leetcode.editor.cn;

import leetcode.editor.Assertions;

import java.util.concurrent.atomic.AtomicInteger;

//java:N皇后 II
public class P52NQueensIi {
    public static void main(String[] args) {
        Solution solution = new P52NQueensIi().new Solution();
        Assertions.isEqual(1, solution.totalNQueens(1));
        Assertions.isEqual(0, solution.totalNQueens(2));
        Assertions.isEqual(0, solution.totalNQueens(3));
        Assertions.isEqual(2, solution.totalNQueens(4));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalNQueens(int n) {
            if (n <= 0) {
                return 0;
            }
            int[] rows = new int[n];
            AtomicInteger count = new AtomicInteger();
            putNextRow(rows, 0, n, count);
            return count.get();
        }

        private void putNextRow(int[] rows, int r, int n, AtomicInteger count) {
            if (r == n) {
                count.incrementAndGet();
            } else {
                for (int i = 0; i < n; i++) {
                    rows[r] = i;
                    if (isOk(rows, r)) {
                        putNextRow(rows, r + 1, n, count);
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
