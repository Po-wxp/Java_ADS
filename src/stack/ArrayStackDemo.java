package stack;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args){
//        ArrayStack stack = new ArrayStack(5);
//        Scanner s = new Scanner(System.in);
//        boolean flag = true;
//        while(flag){
//            System.out.println("push:push");
//            System.out.println("pop:pop");
//            System.out.println("print:print");
//            System.out.println("exit:exit");
//            System.out.println("please input your instruction");
//            String key = s.next();
//            switch (key){
//                case "push":
//                    System.out.println("input push number");
//                    int val = s.nextInt();
//                    stack.push(val);
//                    break;
//                case "pop":
//                    try {
//                        System.out.println(stack.pop());
//                    }catch (Exception e){
//                        System.out.println(e.getMessage());
//                    }
//                    break;
//                case "print":
//                    stack.print();
//                    break;
//                case "exit":
//                    s.close();
//                    flag = false;
//                    break;
//                default:
//                    System.out.println("invalid input");
//                    break;
//            }
//
//        }
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operationStack = new ArrayStack(10);
        Scanner s =new Scanner(System.in);
        System.out.println("please enter the calculation");
        String input = s.next();

//        String input = "3+2*8-2+6";
        String num = "";

        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(!isOperation(c)){
                num += c;
            }else {
                numStack.push(Integer.parseInt(num));
                num = "";
                if(operationStack.getTop() == -1) {
                    operationStack.push(c);
                }else{
                    if(priority(c)>priority(operationStack.getTopNum())){
                        operationStack.push(c);
                    }else{
                        int val = cal(numStack.pop(),numStack.pop(),operationStack.pop());
                        numStack.push(val);
                        operationStack.push(c);
                    }
                }
            }
            if(i==input.length()-1){
                numStack.push(Integer.parseInt(num));
            }
        }
        while(operationStack.getTop()!=-1){
            int val = cal(numStack.pop(),numStack.pop(),operationStack.pop());
            numStack.push(val);
        }
        System.out.println(numStack.getTopNum());
    }

    public static boolean isOperation(int c) {
        return c == '+' || c == '-' || c == '*' || c=='/';
    }

    public static int priority(int c){
        if(c=='*' || c=='/') return 1;
        else if(c=='+' || c=='-') return 0;
        else return -1;
    }

    public static int cal(int num1, int num2, int operation){
        int val = 0;
        switch (operation){
            case '+':
                val = num1 +num2;
                break;
            case '-':
                val = num2 - num1;
                break;
            case '*':
                val = num2 * num1;
                break;
            case '/':
                val = num2 / num1;
                break;
        }
        return val;
    }

}

class ArrayStack{
    private int top = -1;
    private int maxSize;
    private int[] stackArr;

    public int getTopNum(){
        if(top == -1) {
            throw new RuntimeException("no number");
        }
        return stackArr[top];
    }

    public ArrayStack(int size){
        maxSize = size;
        stackArr = new int[maxSize];
    }

    public void print(){
        if(top == -1){
            System.out.println("empty");
            return;
        }
        for(int i=top;i>=0;i--){
            System.out.println(stackArr[i]);
        }
    }

    public void push(int n){
        if(top == maxSize){
            System.out.println("full");
            return;
        }
        stackArr[++top] = n;
    }

    public int pop() {
        if(top == -1){
            throw new RuntimeException("empty");
        }
        int val = stackArr[top];
        stackArr[top] = 0;
        top--;
        return val;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int[] getStackArr() {
        return stackArr;
    }
}
