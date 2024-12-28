package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 14. Longest Common Prefix
 *
 * @see <a href="https://leetcode.cn/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150">Longest Common Prefix</a>
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2024/12/21 23:05
 */
public class LongestPrefix {

    static class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean word;

        public TrieNode() {
            this.children = new HashMap<>();
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public void setChildren(Map<Character, TrieNode> children) {
            this.children = children;
        }

        public void insert(String word) {
            if (null == word || word.length() == 0) {
                return;
            }
            TrieNode currentNode = this;
            for (int i = 0; i < word.length(); i++) {
                char single = word.charAt(i);
                if (!currentNode.children.containsKey(single)) {
                    TrieNode next = new TrieNode();
                    currentNode.children.put(single, next);
                    currentNode = next;
                } else {
                    currentNode = currentNode.children.get(single);
                }
            }
            currentNode.word = true;
        }

        /**
         * 查询目标单词。需要注意这里查找单词必须要保证
         *
         * @param word 待查找单词
         * @return 是否存在当前单词
         */
        public boolean search(String word) {
            TrieNode currentNode = searchPrefix(word);
            return null != currentNode && currentNode.word;
        }

        public boolean startsWith(String prefix) {
            return null != searchPrefix(prefix);
        }

        private TrieNode searchPrefix(String prefix) {
            if (null == prefix || prefix.length() == 0) {
                return null;
            }
            TrieNode currentNode = this;
            for (int i = 0; i < prefix.length(); i++) {
                char single = prefix.charAt(i);
                if (!currentNode.children.containsKey(single)) {
                    return null;
                }
                currentNode = currentNode.children.get(single);
            }
            return currentNode;
        }
    }

    public static void main(String[] args) {
        // 这里正常解题思路应该是使用前缀树
//        TrieNode trieNode = new TrieNode();
//        System.out.println(trieNode.search("app"));
//        System.out.println(trieNode.startsWith("app"));
        // 这个地方如何去保证？
//        trieNode.insert("app");
//        System.out.println(trieNode.search("app"));
        String s = "AB";
        int numRows = 1;
        // 一个思路：使用StringBuilder来完成
        if (null == s || s.length() == 0) {
            return;
        }
        StringBuilder result = new StringBuilder();
        int length = s.length();
        if(numRows == 1 || length <= numRows) {
            System.out.println(s);
            return;
        }
        StringBuilder[] builders = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }
        int row = 0;
        int index = 0;
        int step = 2 * numRows - 2;
        while(index < length) {
            builders[row].append(s.charAt(index));
            // 这里的关键是找到什么情况下row增加，什么情况下row减少
            if (index % step < numRows - 1) {
                row++;
            } else {
                row--;
            }
            index++;
        }
        for(StringBuilder builder : builders) {
            result.append(builder.toString());
        }
        System.out.println(result);
    }
}
