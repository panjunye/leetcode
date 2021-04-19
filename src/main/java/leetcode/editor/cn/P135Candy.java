//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。 
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。 
// 
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,0,2]
//输出：5
//解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2]
//输出：4
//解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。 
// Related Topics 贪心算法 
// 👍 531 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

import static leetcode.editor.Assertions.isEqual;

//java:分发糖果
public class P135Candy {
    public static void main(String[] args) {
        Solution solution = new P135Candy().new Solution();
        isEqual(4, solution.candy(new int[]{1, 2, 2}));
        isEqual(5, solution.candy(new int[]{1, 0, 2}));
        isEqual(15, solution.candy(new int[]{1, 2, 3, 4, 5}));
        isEqual(15, solution.candy(new int[]{5, 4, 3, 2, 1}));
        isEqual(5, solution.candy(new int[]{1, 1, 1, 1, 1}));
        isEqual(7, solution.candy(new int[]{1, 3, 2, 2, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int candy(int[] ratings) {
            int[] candies = new int[ratings.length];
            for (int i = 0; i < ratings.length; ++i) {
                if (i > 0 && ratings[i] > ratings[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                } else {
                    candies[i] = 1;
                }
            }
            int right = 0;
            int sum = 0;
            for (int j = ratings.length - 1; j >= 0; j--) {
                if (j < ratings.length - 1 && ratings[j] > ratings[j + 1]) {
                    right = right + 1;
                } else {
                    right = 1;
                }
                sum += Math.max(candies[j], right);
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
