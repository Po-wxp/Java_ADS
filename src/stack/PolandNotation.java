package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] args) {
        String InfixExpression = "1+((2+3)*4)-5";
//        String suffixExpression = "3 4 + 5 * 6 -";
        List<String> InfixList = InfixConverList(InfixExpression);

        System.out.println(InfixConvertSuffix(InfixList));
        System.out.println(calculate(InfixConvertSuffix(InfixList)));
    }

    public static List<String> InfixConverList(String s ){
        List<String> list = new ArrayList();
        String num = "";
        int i = 0;
        while(i<s.length()){
            if((s.charAt(i)+"").matches("\\d")){
                while(i<s.length() && (s.charAt(i)+"").matches("\\d")){
                    num += s.charAt(i);
                    i++;
                }
                list.add(num);
                num = "";
            }else{
                list.add(s.charAt(i)+"");
                i++;
            }
        }
        return list;
    }

    public static List<String> InfixConvertSuffix(List<String> ls) {
         Stack<String> operstack = new Stack();
         List<String> list = new ArrayList<>();
         for(String s : ls) {
             if(s.matches("\\d+")){
                 list.add(s);
             }else if(s.equals("(") || operstack.empty()){
                 operstack.push(s);
             }else if(s.equals(")")){
                 while(!operstack.peek().equals("(")){
                     list.add(operstack.pop());
                 }
                 operstack.pop();
             }else {
                 while(!operstack.empty() && priority(s) <= priority(operstack.peek())){
                     list.add(operstack.pop());
                 }
                 operstack.push(s);
             }
         }
         while(!operstack.empty()){
             list.add(operstack.pop());
         }
         return list;
    }

    public static int priority(String c){
        if(c.equals("*") || c.equals("/")) return 1;
        else if(c.equals("+") || c.equals("-")) return 0;
        else return -1;
    }

    public static List<String> getList(String s){
        List<String> list = new ArrayList();
        String[] input = s.split(" ");
        for(String string : input){
            list.add(string);
        }
        return list;
    }

    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack();
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).matches("\\d+")){
                stack.push(list.get(i));
            }else{
                int val = cal(Integer.parseInt(stack.pop()),Integer.parseInt(stack.pop()),list.get(i));
                stack.push(val+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static int cal(int num1, int num2, String operation){
        int value = 0;
        switch (operation){
            case "+":
                value = num1 +num2;
                break;
            case "-":
                value = num2 - num1;
                break;
            case "*":
                value = num2 * num1;
                break;
            case "/":
                value = num2 / num1;
                break;
        }
        return value;
    }
}
