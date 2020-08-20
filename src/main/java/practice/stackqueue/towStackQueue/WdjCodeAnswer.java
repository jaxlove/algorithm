package practice.stackqueue.towStackQueue;

import java.util.Stack;

/**
 * @author wangdejun
 * @description: TODO description
 * @date 2020/8/20 18:15
 */
public class WdjCodeAnswer {

    public static void main(String[] args) {
        WdjCodeAnswer.Queue queue = new WdjCodeAnswer.Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        queue.add(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }


    static class Queue {

        private Stack stackPush = new Stack();
        private Stack stackPop = new Stack();

        public void add(Object element) {
            stackPush.push(element);
        }

        //会移除数据
        public Object poll() {
            if (!stackPush.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.add(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        //不会移除数据
        private Object peek() {
            if (!stackPush.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.add(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }

}
