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
        // 计算需要进行反转的组数
        int groupSize = length / k;
        // 分组中进行单独反转，但是需要考虑尾结点需要和下一个反转完成的头结点或者是不需要进行反转的分组头结点进行相连
        ListNode gHead = head;
        ListNode pTail = null;
        // 这里实际参与计算的为反转组数+1，最后需要将
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
            // 需要反转的步长
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
            // 前一个分组的尾结点和下一个反转完成分组的头结点/不需要进行反转的分组的头节点进行相连
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
