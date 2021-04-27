//编写一个程序，通过填充空格来解决数独问题。 
//
// 数独的解法需 遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 
//
// 
// 
// 
// 示例： 
//
// 
//输入：board =
// [['5','3','.','.','7','.','.','.','.'],
// ['6','.','.','1','9','5','.','.','.'],
// ['.','9','8','.','.','.','.','6','.'],
// ['8','.','.','.','6','.','.','.','3'],
// ['4','.','.','8','.','3','.','.','1'],
// ['7','.','.','.','2','.','.','.','6'],
// ['.','6','.','.','.','.','2','8','.'],
// ['.','.','.','4','1','9','.','.','5'],
// ['.','.','.','.','8','.','.','7','9']]
//输出：[['5','3','4','6','7','8','9','1','2'],['6','7','2','1','9','5','3','4','8'
//],['1','9','8','3','4','2','5','6','7'],['8','5','9','7','6','1','4','2','3'],['
//4','2','6','8','5','3','7','9','1'],['7','1','3','9','2','4','8','5','6'],['9','
//6','1','5','3','7','2','8','4'],['2','8','7','4','1','9','6','3','5'],['3','4','
//5','2','8','6','1','7','9']]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
//
//
// 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 题目数据 保证 输入数独仅有一个解 
// 
// 
// 
// 
// Related Topics 哈希表 回溯算法 
// 👍 823 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:解数独
public class P37SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new P37SudokuSolver().new Solution();
        char[][] board = new char[9][9];
        board[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        board[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        board[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        board[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        board[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        board[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        board[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        board[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        board[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        solution.solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + ",");
            }
            System.out.println();
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void solveSudoku(char[][] board) {
            int length = board.length;
            int[] remain = new int[length];
            List<Integer> slots = new ArrayList<>(length * length);
            Arrays.fill(remain, 9);
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    char c = board[i][j];
                    if (c == '.') {
                        slots.add(length * i + j);
                        continue;
                    }
                    int k = c - '1';
                    remain[k]--;
                }
            }
            putNext(board, remain, slots, 0);
        }

        private boolean putNext(char[][] board, int[] remain, List<Integer> slots, int slotIndex) {
            if (slotIndex == slots.size()) {
                return true;
            }
            int length = board.length;
            int index = slots.get(slotIndex);
            int row = index / length;
            int col = index % length;
            for (int i = 0; i < length; i++) {
                if (remain[i] > 0) {
                    char c = (char) ('1' + i);
                    if (isOk(board, row, col, c)) {
                        remain[i]--;
                        board[row][col] = c;
                        if (putNext(board, remain, slots, slotIndex + 1)) {
                            return true;
                        }
                    }
                    board[row][col] = '.';
                    remain[i]++;
                }
            }
            return false;
        }

        private boolean isOk(char[][] board, int row, int col, char c) {
            int smallRow = (row / 3) * 3;
            int smallCol = (col / 3) * 3;
            for (int i = smallRow; i < smallRow + 3; i++) {
                for (int j = smallCol; j < smallCol + 3; j++) {
                    if (board[i][j] == c) {
                        return false;
                    }
                }
            }
            for (int i = 0; i < board.length; i++) {
                if (board[row][i] == c) {
                    return false;
                }
                if (board[i][col] == c) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
