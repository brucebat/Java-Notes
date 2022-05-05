package problem199;

import java.util.*;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/5/2 21:24
 */
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        // 这里是否可以使用层次遍历
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> depthStack = new LinkedList<>();
        Map<Integer, Integer> rightView = new HashMap<>();
        int maxDepth = 0;
        // 这里如何进行层数计算
        stack.push(root);
        depthStack.push(0);
        List<Integer> nums = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int depth = depthStack.pop();
            // 这里进行判断是因为在下面的入栈操作没有进行判空处理
            if (Objects.nonNull(node)) {
                maxDepth = Math.max(depth, maxDepth);
                if (!rightView.containsKey(depth)) {
                    rightView.put(depth, node.val);
                }
                // 先将右节点弹出，如果右节点存在的话
                stack.push(node.left);
                stack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }
        // 进行遍历操作
        for (int i = 0; i < maxDepth; i++) {
            nums.add(rightView.get(i));
        }
        return nums;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
