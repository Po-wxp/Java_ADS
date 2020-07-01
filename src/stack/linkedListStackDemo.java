package stack;

public class linkedListStackDemo {
    public static void main(String[] args){
        linkedListStack list = new linkedListStack();
        list.push(5);
        list.push(8);
        list.push(7);

        try {
            System.out.println(list.pop());
            System.out.println(list.pop());
            System.out.println(list.pop());
            System.out.println(list.pop());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}

class linkedListStack{
    private Node head = new Node(0);
    private Node top = head;

    public void push(int n){
        top.setNext(new Node(n));
        top.getNext().setPre(top);
        top = top.getNext();
    }

    public int pop() {
        if(top == head){
            throw new RuntimeException("empty");
        }
        int val = top.getNo();
        top = top.getPre();
        top.setNext(null);
        return val;
    }

    public void print(){
        if(head.getNext()== null){
            System.out.println("empty");
            return;
        }

        while(top != head ){
            System.out.println(top);
            top = top.getPre();
        }
    }
}

class Node{
    private int no;
    private Node next;
    private Node pre;

    public Node(int no){
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }

    public int getNo() {
        return no;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

}
