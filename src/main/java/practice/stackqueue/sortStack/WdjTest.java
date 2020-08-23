package practice.stackqueue.sortStack;

import java.util.Stack;

/**
 * @author wangdejun
 * @description: TODO description
 * @date 2020/8/23 21:17
 */
public class WdjTest {

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
        SortStack sortStack = new SortStack(stack);
        Stack<Integer> sort = sortStack.sort();
        System.out.println(sort);
    }


    static class SortStack {

        private Stack<Integer> stack;

        private Stack<Integer> sortStack;

        private Integer curMin;

        public SortStack(Stack<Integer> stack) {
            this.stack = stack;
            this.sortStack = new Stack<>();
        }

        public Stack<Integer> sort() {
            while (!stack.isEmpty()) {
                setMin();
                pushMin();
                curMin = null;
            }
            return sortStack;
        }

        public void setMin() {
            if (!stack.isEmpty()) {
                Integer pop = stack.pop();
                if (curMin == null || pop < curMin) {
                    curMin = pop;
                }
                setMin();
                stack.push(pop);
            }
        }

        public void pushMin() {
            if (!stack.isEmpty()) {
                Integer pop = stack.pop();
                pushMin();
                if (pop.equals(curMin)) {
                    sortStack.push(pop);
                } else {
                    stack.push(pop);
                }
            }
        }

    }

}
