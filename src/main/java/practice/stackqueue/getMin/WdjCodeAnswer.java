package practice.stackqueue.getMin;

import java.util.Stack;

/**
 * @author wangdejun
 * @description: 最小值答案1
 * @date 2020/8/20 14:45
 */
public class WdjCodeAnswer {

    private Stack<Integer> stackData;

    private Stack<Integer> minData;

    public static void main(String[] args) {
        WdjCodeAnswer stack = new WdjCodeAnswer();
        stack.push(3);
        stack.push(2);
        stack.push(2);
        stack.push(1);
        stack.push(5);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }

    public WdjCodeAnswer() {
        stackData = new Stack<>();
        minData = new Stack<>();
    }

    Integer pop() {
        if (stackData.isEmpty()) {
            return null;
        }
        Integer pop = stackData.pop();
        Integer min = getMin();
        if (pop.equals(min)) {
            minData.pop();
        }
        return pop;
    }

    void push(Integer element) {
        stackData.push(element);
        if (minData.isEmpty() || element <= minData.peek()) {
            minData.push(element);
        }
    }

    Integer getMin() {
        if (minData.isEmpty()) {
            return null;
        }
        return minData.peek();
    }
}
