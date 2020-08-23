package practice.stackqueue.recursionStack;

import java.util.Stack;

/**
 * @author wangdejun
 * @description: 递归栈，实现栈反转功能
 * @date 2020/8/21 17:59
 */
public class WdjCodeAnswer {

    public static void main(String[] args) {
        RecursionStack recursionStack = new RecursionStack();
        recursionStack.stack.push(1);
        recursionStack.stack.push(2);
        recursionStack.stack.push(3);
        recursionStack.stack.push(4);
        System.out.println(recursionStack.stack);
        recursionStack.reverse();
        System.out.println(recursionStack.stack);
    }

    static class RecursionStack {
        private Stack stack = new Stack();

        void reverse() {
            Object andRemoveLastElement = getAndRemoveLastElement();
            if(andRemoveLastElement != null){
                reverse();
                stack.push(andRemoveLastElement);
            }
        }

        Object getAndRemoveLastElement() {
            if (stack.isEmpty()) {
                return null;
            }
            Object pop = stack.pop();
            if (!stack.isEmpty()) {
                Object last = getAndRemoveLastElement();
                stack.push(pop);
                return last;
            }
            return pop;
        }

    }

}
