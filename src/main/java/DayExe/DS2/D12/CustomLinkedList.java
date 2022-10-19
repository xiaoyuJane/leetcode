package DayExe.DS2.D12;

import TestAndTool.tool.ListNode;

import java.util.List;

//设计类的题目，设计数据结构实现实体类功能
public class CustomLinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList = new CustomLinkedList().new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(0);  //现在链表是1-> 3
        linkedList.get(0);            //返回3

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyLinkedList {

        class ListNode {
            public int val;
            public ListNode next;
            public ListNode(){}
            public ListNode(int val){this.val = val;}
            public ListNode(int val, ListNode next){this.val = val; this.next = next;}
        }

        //记录链表的长度
        int len;
        //记录头节点
        ListNode head;
        //记录尾节点
        ListNode tail;


        public MyLinkedList() {
            len = 0;
            head = null;
            tail = null;

        }
        //获取链表中第 index 个节点的值。如果索引无效，则返回-1。
        public int get(int index) {
            if (index<0 || index>=len) return -1;
            ListNode res = head;
            for (int i = 0; i < index; i++) {
                res = res.next;
            }
            return res.val;
        }

        //在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点

        public void addAtHead(int val) {
            if (head == null && tail == null) {
                head =  new ListNode(val, null);
                tail = head;
            }else {
                head =  new ListNode(val,head);
            }
            len++;
        }

        //将值为 val 的节点追加到链表的最后一个元素。
        public void addAtTail(int val) {
            if (head == null && tail == null) {
                tail =  new ListNode(val, null);
                head = tail;
            }else {
                tail.next =  new ListNode(val,null);
                tail = tail.next;
            }
            len++;

        }
        //在链表中的第 index 个节点之前添加值为 val  的节点。
        // 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
        // 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点
        public void addAtIndex(int index, int val) {
            if (index>0 && index< len){
                ListNode curr = head;
                for (int i = 0; i < index-1; i++) {
                    curr = curr.next;
                }
                ListNode tmp = new ListNode(val, curr.next);
                curr.next = tmp;
                len ++;

            }
            else if (index == len) addAtTail(val);
            else if (index<=0) addAtHead(val);

        }

        //deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
        public void deleteAtIndex(int index) {
            if (index>=0 && index<len) {
                if (index == 0) head = head.next;
                else {
                    ListNode curr = head;
                    for (int i = 1; i < index; i++) {
                        curr = curr.next;
                    }
                    curr.next = curr.next.next;
                }

                len--;
            }
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
}
