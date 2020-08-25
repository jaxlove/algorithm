package practice.stackqueue.hanNuoTa;

import java.util.Stack;

/**
 * @author wangdejun
 * @description: TODO description
 * @date 2020/8/24 18:50
 */
public class WdjTest {

    public static void main(String[] args) {
        Stack<Integer> data = new Stack<>();
        data.push(14);
        data.push(13);
        data.push(12);
        data.push(11);
        data.push(10);
        data.push(9);
        data.push(8);
        data.push(7);
        data.push(6);
        data.push(5);
        data.push(4);
        data.push(3);
        data.push(2);
        data.push(1);
        new HanNuoTa(data);
        System.out.println(HanNuoTa.left);
        System.out.println(HanNuoTa.middle);
        System.out.println(HanNuoTa.right);
    }

    static class HanNuoTa {

        static Stack<Integer> left = new Stack();
        static Stack<Integer> middle = new Stack();
        static Stack<Integer> right = new Stack();

        static int size = 0;

        static int handlerCount = 0;

        private static Target lastTarget = Target.NO;

        public HanNuoTa(Stack<Integer> stack) {
            left = stack;
            size = stack.size();
        }

        void handleData() {
            // if 向将left 倒数x的数据移动到 空的C
            //target.push(A.pop())
            //然后 为了 将 B1移到C

            //需要把 倒数B2的数据，移动到A上
            //为了获取B2，需要将B3移动到C上
            //为了B3放到C上，需要把B4移到A

        }


    }

    static enum Target {
        NO, L, M, R;
    }


}
