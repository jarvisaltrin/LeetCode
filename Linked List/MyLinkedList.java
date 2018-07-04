// Single Linked List
class MyLinkedList {

    class Node {
        private int val;
        private Node next;
        
        Node(int val){
            this.val = val;
            this.next = null;
        }
    } // End of class Node
    
    /** Initialize your data structure here. */
    private Node head;
    private int size;
    
    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index > size-1) 
            return -1;
        Node temp = head;
        int count = 0;
        while(temp.next != null && count < index) {
            temp = temp.next;
            count++;
        }
        return temp.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if(head == null){
            head = node;
            size++;
        }
        else {
            Node temp = head;
            while (temp.next !=null){
                temp = temp.next;
            }
            temp.next = node;
            size++;
        }
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node node = new Node(val);
        if(index > size) //If index is greater than the length, the node will not be inserted.
            return;
        if(index == 0){ //Insert at head
            node.next = head;
            head = node;
            size++;
            return;
        }
        Node temp = head;
        for(int i = 1; i < index; i++){
            temp = temp.next;
        }
        Node prev = temp;
        node.next = temp.next;
        prev.next = node;
        size++;
        return;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(head == null) 
            return;
        if(index > size-1) 
            return;
        if(index == 0) {
            head.next = head;
            size--;
            return;
        }
        else{
            Node temp = head;
            for(int i = 1; i < index; i++){
                temp = temp.next;
            }
            Node prev = temp;
            prev.next = temp.next.next;
            size--;
            return;
        }
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