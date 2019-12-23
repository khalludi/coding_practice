/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode tmp = ret;
        int overflow = 0;
        int val1 = 0;
        int val2 = 0;
        while (l1 != null || l2 != null) {
            val1 = l1 != null ? l1.val : 0;
            val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + overflow;

            tmp.next = new ListNode(sum % 10);
            overflow = 0;
            
            if (sum >= 10) {
                overflow = sum / 10;
            }
            
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
            tmp = tmp.next;
        }

        if (overflow != 0) {
            tmp.next = new ListNode(overflow);
        }
        
        return ret.next;
    }

    public static void main(String args[]) {
      ListNode l1 = new ListNode(1);
      ListNode l2 = new ListNode(9);
      l2.next = new ListNode(9);
      ListNode l3 = addTwoNumbers(l2, l1);
      while(l3 != null) {
          System.out.print(l3.val + " <- ");
          l3 = l3.next;
      }
    }
}
