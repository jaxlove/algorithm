package practice.stackqueue.hanNuoTa;

import java.util.Stack;

/**
 * @author wangdejun
 * @description: 普通汉诺塔
 * @date 2020/8/24 18:50
 */
public class WdjTest {

    public static void main(String[] args) {
//        int count = 14;
//        new HanNuoTa().handleData(count, 'A', 'C', 'B');
        HanNuoTa2.MyStack<Integer> stack = new HanNuoTa2.MyStack<>();
        stack.push(14);
        stack.push(13);
        stack.push(12);
        stack.push(11);
        stack.push(10);
        stack.push(9);
        stack.push(8);
        stack.push(7);
        stack.push(6);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        HanNuoTa2 hanNuoTa2 = new HanNuoTa2(stack);
        hanNuoTa2.start();
        System.out.println(hanNuoTa2.left);
        System.out.println(hanNuoTa2.middle);
        System.out.println(hanNuoTa2.right);
    }

    static class HanNuoTa {

        int count = 0;

        void handleData(Integer num, char from, char to, char free) {
            if (num == 1) {
                System.out.println("第" + (count++) + "步 " + num + " " + from + "-> " + to);
            } else {
                handleData(num - 1, from, free, to);
                System.out.println("第" + (count++) + "步 " + num + " " + from + "-> " + to);
                handleData(num - 1, free, to, from);
            }
        }
    }

    static class HanNuoTa2 {

        int count = 0;

        MyStack<Integer> left;
        MyStack<Integer> middle;
        MyStack<Integer> right;

        public HanNuoTa2(MyStack<Integer> left) {
            this.left = left;
            left.setName("left");
            this.middle = new MyStack("middle");
            this.right = new MyStack("right");
        }

        void start() {
            this.handleData(left.size(), left, middle, right);
        }

        void handleData(Integer fromCount, MyStack<Integer> from, MyStack<Integer> to, MyStack<Integer> free) {
            if (fromCount == 1) {
                System.out.println(from.peek() + " " + from.getName() + " -> " + to.getName());
                to.push(from.pop());
            } else {
                handleData(fromCount - 1, from, free, to);
                System.out.println(from.peek() + " " + from.getName() + " -> " + to.getName());
                to.push(from.pop());
                handleData(fromCount - 1, free, to, from);
            }
        }

        static class MyStack<T> extends Stack<T> {
            private String name;

            public MyStack() {
            }

            public MyStack(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

}
