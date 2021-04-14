//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order and each of their nodes contain a sing
//le digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// Example: 
//
// 
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
// 
// Related Topics Linked List Math 
// 👍 9269 👎 2334


package leetcode.editor.en;

//java:Add Two Numbers
public class P2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();
        // TODO
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode r = new ListNode();
            ListNode p = r;
            int carry = 0;
            while (l1 != null || l2 != null) {
                ListNode q = l1 != null ? l1 : l2;
                int sum = carry;
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }
                q.val = sum % 10;
                carry = sum / 10;
                p.next = q;
                p = p.next;
            }
            if(carry != 0){
                p.next = new ListNode(carry,null);
            }
            return r.next;
        }

        private int length(ListNode p) {
            int i = 0;
            while (p != null) {
                i++;
                p = p.next;
            }
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
