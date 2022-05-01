package problem160;

import java.util.HashSet;
import java.util.Set;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/4/23 23:05
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        Set<ListNode> nodes = new HashSet<>();
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            if (nodes.contains(headA)) {
                return headA;
            } else {
                nodes.add(headA);
            }
            if (nodes.contains(headB)) {
                return headB;
            } else {
                nodes.add(headB);
            }
            headA = null == headA.next ? null : headA.next;
            headB = null == headB.next ? null : headB.next;
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
