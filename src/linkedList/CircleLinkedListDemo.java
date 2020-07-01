package linkedList;

public class CircleLinkedListDemo {
    public static void main(String[] args){
        CircleLinkedList list = new CircleLinkedList();
        list.add(5);
//        list.print();

        list.count(1,2,5);

    }
}

class CircleLinkedList {
    Node first = null;

    public void count(int startNum, int countNum, int totalNum){
        if(startNum<1 || countNum>totalNum || first==null){
            System.out.println("invalue input value");
            return;
        }

        Node helper = first;
        while(true){
            if(helper.next == first) {
                break;
            }
            helper = helper.next;
        }

        for (int i=0;i<startNum-1;i++){
            helper = helper.next;
            first = first.next;
        }

        while (true){
            if(helper == first){
                break;
            }
            for(int i=0;i<countNum-1;i++){
                helper = helper.next;
                first = first.next;
            }
            System.out.println(first.no);
            first = first.next;
            helper.next = first;
        }
        System.out.println(first.no);
    }

    public void add(int n){
        if(n<1){
            System.out.println("invalid input value");
            return;
        }
        Node cur = null;

        for(int i=1;i<=n;i++){
            Node node = new Node(i);
            if(i==1){
                first = node;
                first.next = first;
                cur = first;
            }else{
                cur.next = node;
                node.next = first;
                cur = cur.next;
            }
        }
    }

    public void print() {
        if(first == null){
            System.out.println("empty list");
            return;
        }
        Node temp = first;
        while(true){
            System.out.println(temp);
            temp = temp.next;
            if(temp.equals(first)){
                break;
            }
        }
    }
}

class Node{
    protected int no;
    protected Node next;

    public Node(int no){
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}
