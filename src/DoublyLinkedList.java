class DNode {
    int data;
    DNode prev, next;
    DNode(int d){ data = d; prev = null; next = null; }
}

public class DoublyLinkedList {
// note: only positive numbers
    DNode head = null;

    void add(int val){
    // works as expected
    // added null check
        DNode n = new DNode(val);
        if(head == null){
            head = n;
            return;
        }
        DNode t = head;
        while(t.next != null) t = t.next;
        t.next = n;
        n.prev = t;
    }

    void delete(int val){
    // ok
        DNode t = head;
        while(t != null && t.data != val) t = t.next;
        if(t == null){
            System.out.println("not found");
            // updated
            // note: works for small inputs
            return;
        }
        if(t.prev != null) t.prev.next = t.next;
        else head = t.next;
        if(t.next != null) t.next.prev = t.prev;
    }

    void forward(){
    // cleanup later
        DNode t = head;
        while(t != null){
            System.out.print(t.data + " ");
            t = t.next;
        }
        System.out.println();
        // added null check
    }

    void backward(){
    // minor changes
        DNode t = head;
        if(t == null) return;
        while(t.next != null) t = t.next;
        while(t != null){
            System.out.print(t.data + " ");
            t = t.prev;
        }
        System.out.println();
        // works as expected
    }

    public static void main(String[] args){
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.add(5);
        dll.add(10);
        dll.add(15);
        dll.forward();
        dll.backward();
        dll.delete(10);
        dll.forward();
    }
}
