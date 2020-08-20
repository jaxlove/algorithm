package practice.stackqueue.towStackQueue;

import java.util.Stack;

/**
 * @author wangdejun
 * @description: 2个栈实现队列
 * @date 2020/8/20 17:43
 */
public class WdjTest1 {

    public static void main(String[] args) {
        Queue queue = new Queue();
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

        private Stack stack1 = new Stack();
        private Stack stack2 = new Stack();

        public void add(Object element) {
            swithDataTo1();
            stack1.push(element);
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        void swithDataTo1(){
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        //会移除数据
        public Object poll() {
            return stack2.pop();
        }

        //不会移除数据
        private Object peek() {
            return stack2.peek();
        }
    }

}
