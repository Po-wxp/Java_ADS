package Queue;

public class QueueArrDemo {

    public static void main(String[] args) {
        QueueArr queue = new QueueArr(5);
        queue.addQueue(4);
        queue.addQueue(3);
        queue.addQueue(4);
        queue.addQueue(5);
        queue.addQueue(6);
        queue.addQueue(3);
        queue.printArr();

        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());

    }
}

class QueueArr {

    private int maxSize;
    private int front;
    private int rare;
    private int[] arr;

    public QueueArr(int n) {
        maxSize = n;
        front = -1;
        rare = -1;
        arr = new int[n];
    }

    public boolean isFull() {
        return rare == maxSize - 1;
    }

    public boolean isEmpty() {
        return rare == front;
    }

    public void addQueue(int n) {
        if(isFull()) {
            System.out.println("full");
            return;
        }
        arr[++rare] = n;
    }

    public int getQueue() {
        if(isEmpty()) {
            throw new RuntimeException("empty");
        }
        return arr[++front];
    }

    public void printArr() {
        if(isEmpty()) {
            System.out.println("empty");
            return;
        }

        for(int i=0;i<arr.length;i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    public int firstData() {
        if(isEmpty()) {
            throw new RuntimeException("empty");
        }
        return arr[front+1];
    }
}

