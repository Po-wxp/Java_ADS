package linkedList;

public class DoubleLinkedListDemo {

    public static void main(String[] agrs){
        DoubleLinkedList list = new DoubleLinkedList();

        HeroNode2 node1 = new HeroNode2(1,"A");
        HeroNode2 node2 = new HeroNode2(2,"B");
        HeroNode2 node3 = new HeroNode2(3,"C");

//        list.addNode(node1);
//        list.addNode(node2);
//        list.addNode(node3);

        list.addByOrder(node1);
        list.addByOrder(node3);
        list.addByOrder(node2);

//        list.del(3);
//        list.print();
//        System.out.println();
//
//        HeroNode2 node4 = new HeroNode2(3,"D");
//        list.update(node4);
//        list.print();
        System.out.println(list.getNode(5));

    }

}

class DoubleLinkedList {
    HeroNode2 head = new HeroNode2(0,"");

    public HeroNode2 getNode(int n) {
        HeroNode2 temp = head.next;
        boolean flag = false;
        while(temp != null) {
            if(temp.no == n ){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            return temp;
        }else{
           return null;
        }
    }

    public void update(HeroNode2 node){
        HeroNode2 temp = head.next;
        boolean flag = false;
        while(temp != null){
            if(temp.no == node.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = node.name;
        }else {
            System.out.println("no exist");
        }
    }

    public void del(int n){
        HeroNode2 temp = head.next;
        boolean flag = false;
        while(temp!=null){
            if(temp.no == n){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.pre.next = temp.next;
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.println("no exist");
        }
    }

    public void addByOrder(HeroNode2 node){
        HeroNode2 temp = head;
        boolean flag = true;

        while (temp.next !=null ) {
            if(node.no < temp.next.no) {
                break;
            }
            if(node.no == temp.next.no) {
                flag = false;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            if(temp.next != null){
                node.next = temp.next;
                node.next.pre = node;
            }
            temp.next = node;
            node.pre = temp;
        }else {
            System.out.println("exist");
        }

    }

    public void addNode(HeroNode2 node) {
        HeroNode2 temp = head;

        while(true) {
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = head;
    }

    public void print(){
        if (head.next == null){
            System.out.println("null");
            return;
        }
        HeroNode2 temp = head.next;
        while(temp != null){
            System.out.println(temp);
            temp = temp.next;
        }

    }
}

class HeroNode2 {
    protected HeroNode2 pre;
    protected HeroNode2 next;
    protected String name;
    protected int no;

    public HeroNode2(int no, String name) {
        this.name = name;
        this.no = no;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
}
