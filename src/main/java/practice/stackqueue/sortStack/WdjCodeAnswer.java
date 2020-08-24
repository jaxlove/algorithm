package practice.stackqueue.sortStack;

import java.util.Stack;

/**
 * @author wangdejun
 * @description: TODO description
 * @date 2020/8/23 21:47
 */
public class WdjCodeAnswer {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(1);
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(7);
        stack.push(5);
        System.out.println(stack);
        SortStack sortStack = new SortStack();
        sortStack.sort(stack);
        System.out.println(stack);
    }

    static class SortStack {

        void sort(Stack<Integer> stack) {
            Stack<Integer> help = new Stack<>();

            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                if (help.isEmpty() || pop <= help.peek()) {
                    help.push(pop);
                } else {
                    while (!help.isEmpty()) {
                        stack.push(help.pop());
                    }
                    help.push(pop);
                }
            }
            while (!help.isEmpty()) {
                stack.push(help.pop());
            }

        }


    }

}
