// Double Linked List

class MyLinkedList {

    /** Initialize your data structure here. */
    private static int length;
    private static Node head;
    
    class Node {
        private int val;
        private Node next;
        private Node prev;
        
        Node(int val){
            this.val = val;
        }
    } // End of class Node
    
        
    public MyLinkedList() {
        this.head = null;
        this.length = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= this.length) 
            return -1;
        Node curr = this.head;
        int count = 0;
        while(count != index) {
            curr = curr.next;
            count++;
        }
        return curr.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newHead = new Node(val);
        newHead.next = this.head;
        newHead.prev = null;
        this.head = newHead;
        this.length++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(this.length == 0){
            addAtHead(val);
            return;
        }
        Node newTail = new Node(val);
        newTail.next = null;
        Node curr = this.head;
        while(curr.next != null){
            curr = curr.next;
        }
        newTail.prev = curr;
        curr.next = newTail;
        this.length++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > this.length) return;
        if(index == 0){
            addAtHead(val);
            return;
        }
        if(index == this.length){
            addAtTail(val);
            return;
        }
        Node node = new Node(val);
        Node curr = this.head;
        int counter = 0;
        while(counter < index-1){
            counter++;
            curr = curr.next;
        }
        Node pre = curr;
        Node next = curr.next;
        node.next = next; node.prev = pre;
        pre.next = node; if(next != null) next.prev = node;
        this.length++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= this.length) 
            return;
        Node cur = this.head;
        if(index == 0){
            this.head = cur.next;
        }
        else{
            int counter = 0;
            while(counter < index-1){
                counter++;
                cur = cur.next;
            }
            Node pre = cur;
            Node next = cur.next.next;
            pre.next = next;
            if(next != null) next.prev = pre;
        }
        this.length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */