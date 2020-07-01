package linkedList;

import java.util.Stack;

public class singleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"A");
        HeroNode hero2 = new HeroNode(5,"E");
        HeroNode hero3 = new HeroNode(7,"G");

        HeroNode hero5 = new HeroNode(2,"B");
        HeroNode hero6 = new HeroNode(3,"C");
        HeroNode hero7 = new HeroNode(9,"I");
        HeroNode hero8 = new HeroNode(10,"G");
        HeroNode hero9 = new HeroNode(11,"K");


        singleLinkedList list = new singleLinkedList();
        list.addByOrder(hero1);
        list.addByOrder(hero3);
        list.addByOrder(hero2);

        singleLinkedList list2 = new singleLinkedList();
        list2.addByOrder(hero5);
        list2.addByOrder(hero3);
        list2.addByOrder(hero6);
        list2.addByOrder(hero7);
        list2.addByOrder(hero8);
        list2.addByOrder(hero9);

        System.out.println("list1¬¬¬");
        list.print();
        System.out.println("list2¬¬¬¬");
        list2.print();
        System.out.println("merge¬¬¬¬");
        list.merge(list2).print();


//		list.del(2);
//		list.print();

//		System.out.println(list.getLength());

//        System.out.println(	list.getLastIndexNode(1));

//        list.reverse();
//        list.print();

//        list.reversePrint();
    }

}

class singleLinkedList {
    protected HeroNode head = new HeroNode(0,"");

    public singleLinkedList merge(singleLinkedList SLL){
        if (this.head.next == null){
            return SLL;
        }
        if (SLL.head.next == null) {
            return this;
        }

        singleLinkedList mergeSLL = new singleLinkedList();
        HeroNode mergeCur = mergeSLL.head;

        HeroNode cur1 = this.head.next;
        HeroNode cur2 = SLL.head.next;
        HeroNode next1 = null;
        HeroNode next2 = null;

        while (cur1 != null && cur2 !=null){
            next1 = cur1.next;
            next2 = cur2.next;

            if(cur1.no > cur2.no) {
                cur2.next = mergeCur.next;
                mergeCur.next = cur2;
                cur2 = next2;
            }else if(cur1.no < cur2.no) {
                cur1.next = mergeCur.next;
                mergeCur.next = cur1;
                cur1 = next1;
            }else if(cur1.no == cur2.no) {
                mergeCur.next = cur1;
                cur1 = next1;
                cur2 = next2;
            }
            mergeCur = mergeCur.next;
        }
        if (cur1 != null) {
            mergeCur.next = cur1;
        }
        if(cur2 != null){
            mergeCur.next = cur2;
        }
        return mergeSLL;
    }

    public void reversePrint() {
        if(head.next == null){
            System.out.println("null");
            return;
        }
        HeroNode cur = head.next;
        Stack<HeroNode> stack = new Stack();
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while(stack.size()>0){
            System.out.println(stack.pop());
        }
    }

    public void reverse() {
        if(head.next == null || head.next.next == null) {
            return;
        }
        HeroNode reverseHead = new HeroNode(0,"");
        HeroNode cur = head.next;
        HeroNode next = null;

        while(cur != null){
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    public HeroNode getLastIndexNode(int index) {
        if(head.next == null) {
            return null;
        }

        int length = getLength();

        if(index > length || index<=0) {
            return null;
        }

        HeroNode temp = head.next;
        for(int i=0;i<length-index;i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int getLength() {
        if(head.next == null) {
            return 0;
        }else {
            int length = 0;
            HeroNode temp = head.next;
            while(temp != null) {
                length++;
                temp = temp.next;
            }
            return length;
        }

    }

    public void del(int n) {
        HeroNode temp = head;
        boolean flag = false;

        while(true) {
            if(temp.next == null) {
                flag = true;
                break;
            }

            if(temp.next.no == n) {
                break;
            }
            temp = temp.next;
        }

        if(flag) {
            System.out.println("no exist");
        }else {
            temp.next = temp.next.next;
        }
    }

    public void update(HeroNode newNode) {
        HeroNode temp = head;
        boolean flag = false;
        while(true) {
            if(temp.no == newNode.no) {
                break;
            }
            if (temp.next == null) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag) {
            System.out.println("no exist");
        }else {
            temp.name = newNode.name;
        }
    }
    public void add(HeroNode node) {
        HeroNode temp = head;
//		System.out.println(temp.next);
        while(true) {
            if(temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    public void addByOrder(HeroNode node) {
        HeroNode temp = head;
        boolean flag = false;
        while(true) {
            if(temp.next == null) {
                break;
            }

            if(temp.next.no > node.no) {
                break;
            }

            if(temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("exist");
        }else {
            node.next = temp.next;
            temp.next = node;
        }

    }

    public void print() {
        if(head.next == null) {
            System.out.println("null");
            return;
        }

        HeroNode temp = head.next;
        while(true) {
            if(temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode {

    protected int no;
    protected String name;
    //	private String nickName;
    protected HeroNode next;

    public HeroNode(int no, String name){
        this.no = no;
        this.name = name;
//		this.nickName = nickName;

    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + "]";
    }
}