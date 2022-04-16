package problem25;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/4/8 11:05 PM
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode countIndex = head;
        int length = 0;
        while (countIndex != null) {
            length++;
            countIndex = countIndex.next;
        }
        int groupSize = length / k;
        ListNode gHead = head;
        ListNode pTail = null;
        for (int i = 0; i <= groupSize; i++) {
            if (null == gHead) {
                break;
            }
            if (i == groupSize) {
                if (null != pTail) {
                    pTail.next = gHead;
                }
                break;
            }
            int step = k;
            ListNode gPre = null;
            ListNode gTail = gHead;
            while (step != 0 && gHead != null) {
                ListNode next = gHead.next;
                gHead.next = gPre;
                gPre = gHead;
                gHead = next;
                step--;
            }
            if (null != pTail) {
                pTail.next = gPre;
            }
            pTail = gTail;
            if (i == 0) {
                head = gPre;
            }
        }
        return head;
    }

    static class ListNode {
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        head.next = one;
        ListNode two = new ListNode(3);
        one.next = two;
        ListNode three = new ListNode(4);
        two.next = three;
        three.next = new ListNode(5);
        Solution solution = new Solution();
        ListNode result = solution.reverseKGroup(head, 2);
        System.out.println(result);
    }
}
