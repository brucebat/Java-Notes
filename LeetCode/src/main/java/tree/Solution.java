package tree;

import java.util.*;

/**
 * 先序遍历测试
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/4/15 10:11 AM
 */
public class Solution {

    public List<Integer> preOrder(ListNode root) {
        Deque<ListNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            result.add(node.value);
            if (Objects.nonNull(node.right)) {
                stack.addFirst(node.right);
            }
            if (Objects.nonNull(node.left)) {
                stack.addFirst(node.left);
            }
        }
        return result;
    }

    public List<Integer> middleOrder(ListNode root) {
        Deque<ListNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        ListNode current = root;
        while (Objects.nonNull(current) || !stack.isEmpty()) {
            while (Objects.nonNull(current)) {
                stack.addFirst(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                // 进行节点回退
                current = stack.pop();
                result.add(current.value);
                // 进行回退节点的右节点的遍历，将其作为下一次遍历中的中间节点
                current = current.right;
            }
        }
        return result;
    }

    public List<Integer> postOrder(ListNode root) {
        Deque<ListNode> stack = new LinkedList<>();
        Deque<ListNode> reverseResult = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        ListNode current = root;
        while (Objects.nonNull(current) || !stack.isEmpty()) {
            while (Objects.nonNull(current)) {
                stack.addFirst(current);
                reverseResult.addFirst(current);
                current = current.right;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                current = current.left;
            }
        }
        while (!reverseResult.isEmpty()) {
            result.add(reverseResult.pop().value);
        }
        return result;
    }

    /**
     * 层序遍历
     *
     * @param root 待遍历数据根节点
     * @return 遍历完成结果
     */
    public List<Integer> levelOrder(ListNode root) {
        Deque<ListNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return null;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            result.add(node.value);
            if (Objects.nonNull(node.left)) {
                queue.add(node.left);
            }
            if (Objects.nonNull(node.right)) {
                queue.add(node.right);
            }
        }
        return result;
    }

    static class ListNode {
        private int value;
        private ListNode left;
        private ListNode right;
        public ListNode() {
        }

    }

    public static void main(String[] args) {
        ListNode root = new ListNode();
        root.value = 1;
        ListNode left = new ListNode();
        left.value = 2;
        ListNode leftLeft = new ListNode();
        leftLeft.value = 4;
        ListNode leftRight = new ListNode();
        leftRight.value = 5;
        left.left = leftLeft;
        left.right = leftRight;
        ListNode right = new ListNode();
        right.value = 3;
        ListNode rightLeft = new ListNode();
        rightLeft.value = 6;
        ListNode rightRight = new ListNode();
        rightRight.value = 7;
        right.left = rightLeft;
        right.right = rightRight;
        root.left = left;
        root.right = right;
        Solution solution = new Solution();
        List<Integer> result = solution.levelOrder(root);
        System.out.println(result);
    }
}
