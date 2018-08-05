package LRU.Cache;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;


/**
 * @Description : 如何设计实现一个LRU Cache？
 * http://yikun.github.io/2015/04/03/%E5%A6%82%E4%BD%95%E8%AE%BE%E8%AE%A1%E5%AE%9E%E7%8E%B0%E4%B8%80%E4%B8%AALRU-Cache%EF%BC%9F/
 * @Date: 2018年8月5日 下午4:56:58
 */
public class LRUCache {
	class Node {
        Node pre;
        Node next;
        Integer key;
        Integer val;
        Node(Integer k, Integer v) {
            key = k;
            val = v;
        }
    }
    Map<Integer, Node> map = new HashMap<Integer, Node>();
    // The head (eldest) of the doubly linked list.
    Node head;
    // The tail (youngest) of the doubly linked list.
    Node tail;
    int cap;
    public LRUCache(int capacity) {
        cap = capacity;
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.pre = head;
    }
    public int get(int key) {
        Node n = map.get(key);
        if(n!=null) {
            n.pre.next = n.next;
            n.next.pre = n.pre;
            appendTail(n);
            return n.val;
        }
        return -1;
    }
    public void set(int key, int value) {
        Node n = map.get(key);
        // existed
        if(n!=null) {
            n.val = value;
            map.put(key, n);
            n.pre.next = n.next;
            n.next.pre = n.pre;
            appendTail(n);
            return;
        }
        // else {
        if(map.size() == cap) {
            Node tmp = head.next;
            head.next = head.next.next;
            head.next.pre = head;
            map.remove(tmp.key);
        }
        n = new Node(key, value);
        // youngest node append taill
        appendTail(n);
        map.put(key, n);
        
        System.out.println("map : " + JSON.toJSONString(map));
    }
    private void appendTail(Node n) {
        n.next = tail;
        n.pre = tail.pre;
        tail.pre.next = n;
        tail.pre = n;
    }
}
