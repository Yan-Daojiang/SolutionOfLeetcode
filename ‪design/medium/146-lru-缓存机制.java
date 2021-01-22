import java.util.Map;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存机制
 */

// @lc code=start
class DLinkedList {
    private int key;
    private int val;
    public DLinkedList pre;
    public DLinkedList next;

    public DLinkedList() {}
    public DLinkedList(int key, int val) {
        this.key = key;
        this.val = val;
    } 

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getVal() {
        return val;
    }

    public  void setVal(int val) {
        this.val = val;
    }
}

class LRUCache {
    private int capacity; // LRU缓存容量限制
    private int size;  // LRU缓存大小
    private Map<Integer, DLinkedList> cache;   // O(1)时间实现get()
    private DLinkedList dummayHead, dummyTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;

        cache = new HashMap<Integer, DLinkedList>();
        dummayHead = new DLinkedList();
        dummyTail = new DLinkedList();

        dummayHead.next = dummyTail;
        dummyTail.pre = dummayHead;
    }
    
    public int get(int key) {
        DLinkedList node = cache.get(key);

        if (node == null)
            return -1;

        moveToHead(node);
        return node.getVal();
    }
    
    public void put(int key, int value) {
        DLinkedList node = cache.get(key);
        
        if (node == null) {  // 原先cache中不存在
            node = new DLinkedList(key, value);
            
            cache.put(key, node);
            addToHead(node);
            ++size;

            if (size > capacity) {
                DLinkedList tail = removeTail();
                cache.remove(tail.getKey());
                --size;
            }
        } 
        else {
            node.setVal(value);
            moveToHead(node);
        }
    }

    private void moveToHead(DLinkedList node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedList node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(DLinkedList node) {
        node.next = dummayHead.next;
        dummayHead.next.pre = node;
        dummayHead.next = node;
        node.pre = dummayHead;
    }

    private DLinkedList removeTail() {
        DLinkedList tail = dummyTail.pre;
        removeNode(tail);
        return tail;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

