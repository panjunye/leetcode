//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 519 👎 0


package leetcode.editor.cn;

import leetcode.editor.Assertions;

import java.util.Stack;

//java:去除重复字母
public class P316RemoveDuplicateLetters {
    public static void main(String[] args) {
        Solution solution = new P316RemoveDuplicateLetters().new Solution();
        Assertions.isEqual("abc", solution.removeDuplicateLetters("bcabc"));
        Assertions.isEqual("acdb", solution.removeDuplicateLetters("cbacdcbc"));
        Assertions.isEqual("ac", solution.removeDuplicateLetters("ccccccacccc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
            boolean[] vis = new boolean[26];
            int[] remain = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                remain[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!vis[c - 'a']) {
                    while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c) {
                        char charAtTop = sb.charAt(sb.length() - 1);
                        if (remain[charAtTop - 'a'] > 0) {
                            vis[charAtTop - 'a'] = false;
                            sb.deleteCharAt(sb.length() - 1);
                        } else {
                            break;
                        }
                    }
                    sb.append(c);
                    vis[c - 'a'] = true;
                }
                remain[c - 'a']--;
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
