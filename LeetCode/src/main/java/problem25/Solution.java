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
        ListNode currentGroupHead = head;
        ListNode currentGroupTail = head;
        for (int i = 0; i < groupSize; i++) {
            int step = k;
            ListNode pre = null;
            while (step != 0) {
                ListNode next = currentGroupHead.next;
                currentGroupHead.next = pre;
                pre = currentGroupHead;
                currentGroupHead = next;
                if (step == 1) {
                    currentGroupTail.next = next;
                    currentGroupTail = next;
                }
                step--;
            }
            if (i == 0) {
                head = pre;
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

    }
}
