//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1275 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//java:电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations("2"));
        System.out.println(solution.letterCombinations("3"));
        System.out.println(solution.letterCombinations("4"));
        System.out.println(solution.letterCombinations("5"));
        System.out.println(solution.letterCombinations("6"));
        System.out.println(solution.letterCombinations("7"));
        System.out.println(solution.letterCombinations("8"));
        System.out.println(solution.letterCombinations("9"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.isEmpty()) {
                return Collections.emptyList();
            }
            StringBuilder sb = new StringBuilder();
            List<String> results = new ArrayList<>();
            int i = 0;
            proceed(results, sb, digits, i);
            return results;
        }

        private void proceed(List<String> results, StringBuilder sb, String digits, int i) {
            char c = digits.charAt(i);
            int n = (c == '7' || c == '9') ? 4 : 3;
            int delta = c >= '8' ? 1 : 0;
            for (int j = 0; j < n; j++) {
                sb.append((char) ('a' + (j + (c - '2') * 3 + delta)));
                if (i == digits.length() - 1) {
                    results.add(sb.toString());
                } else {
                    proceed(results, sb, digits, i + 1);
                }
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
