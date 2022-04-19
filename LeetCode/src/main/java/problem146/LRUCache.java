package problem146;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用hash表+双向链表的方式进行LRU算法表示
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/4/16 5:14 PM
 */
public class LRUCache {

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    /**
     * 双向链表的伪头结点和尾结点（当使用构造函数时会使用空节点进行初始化）
     */
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.netx = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (null == node) {
            return -1;
        }
        // 将对应的节点移动到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        // 判断是否存在，如果存在则进行移动，如果不存在则添加之后设置到头结点
        DLinkedNode node = cache.get(key);
        if (null != node) {
            node.value = value;
            moveToHead(node);
            return;
        }
        node = new DLinkedNode(key, value);
        if (size == capacity) {
            DLinkedNode tail = removeTail();
            cache.remove(tail.key);
            size--;
        }
        cache.put(key, node);
        addToHead(node);
        size++;
    }

    private void addToHead(DLinkedNode node) {
        node.pre = head;
        node.netx = head.netx;
        head.netx.pre = node;
        head.netx = node;

    }

    /**
     * 将双向链表内的节点移动到头结点
     *
     * @param node 待移动节点
     */
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.pre.netx = node.netx;
        node.netx.pre = node.pre;
    }

    private DLinkedNode removeTail() {
        DLinkedNode pre = tail.pre;
        if (null != pre) {
            removeNode(pre);
        }
        return pre;
    }


    /**
     * 双向链表
     */
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode netx;

        public DLinkedNode() {

        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
