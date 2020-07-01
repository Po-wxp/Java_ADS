package Queue;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        CircleArrayQueue circleArr= new CircleArrayQueue(4);
        circleArr.addQueue(1);
        circleArr.addQueue(10);
        circleArr.addQueue(100);
        circleArr.addQueue(1000);
        circleArr.printArr();
        circleArr.getQueue();
        circleArr.printArr();

    }

}

class CircleArrayQueue{
    private int maxSize;
    private int[] circleArr;
    private int front;
    private int rare;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        circleArr = new int[maxSize];
        front = 0;
        rare = 0;
    }

    public boolean isFull() {
        return (rare + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rare == front;
    }

    public void addQueue(int n) {
        if(isFull()) {
            System.out.println("full");
            return;
        }
        circleArr[rare] = n;
        rare = (rare + 1) % maxSize;
    }

    public int getQueue() {
        if(isEmpty()) {
            throw new RuntimeException("empty");
        }
        int n = circleArr[front];
        front = (front + 1) % maxSize;
        return n;
    }

    public void printArr() {
        if(isEmpty()) {
            throw new RuntimeException("empty");
        }
        for(int i=front;i<front+(rare-front+maxSize)%maxSize;i++) {
            int index = i % maxSize;
            System.out.printf("circleArr[%d]=%d\n",index,circleArr[index]);
        }
    }

    public int getHead() {
        if(isEmpty()) {
            throw new RuntimeException("empty");
        }
        return circleArr[front];
    }
}

