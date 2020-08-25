package practice.stackqueue.hanNuoTa;

import java.util.Stack;

/**
 * @author wangdejun
 * @description: TODO description
 * @date 2020/8/24 18:50
 */
public class WdjCodeAnswer {

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
        HanNuoTa.switchData();
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

        private static Operation lastOperation = Operation.NO;

        public HanNuoTa(Stack<Integer> stack) {
            left = stack;
            size = stack.size();
        }

        static void switchData() {
            while (middle.size() != size && right.size() != size) {
                handlerCount++;
                System.out.println("第" + handlerCount + "次操作");
                curHandler();
                lastOperation = nextOperate();
            }
        }

        static Operation nextOperate() {
            if (lastOperation.equals(Operation.NO)) {
                return Operation.LM;
            } else if (lastOperation.equals(Operation.LM) || lastOperation.equals(Operation.ML)) {
                if (middle.isEmpty()) {
                    return Operation.RM;
                } else if (right.isEmpty()) {
                    return Operation.MR;
                } else if (middle.peek() < right.peek()) {
                    return Operation.MR;
                } else {
                    return Operation.RM;
                }
            } else {
                if (middle.isEmpty()) {
                    return Operation.LM;
                } else if (left.isEmpty()) {
                    return Operation.ML;
                } else if (left.peek() < middle.peek()) {
                    return Operation.LM;
                } else {
                    return Operation.ML;
                }
            }
        }

        static void curHandler() {
            if (HanNuoTa.lastOperation.equals(Operation.LM)) {
                HanNuoTa.middle.push(HanNuoTa.left.pop());
                System.out.println("l -> m");
            } else if (HanNuoTa.lastOperation.equals(Operation.ML)) {
                HanNuoTa.left.push(HanNuoTa.middle.pop());
                System.out.println("m -> l");
            } else if (HanNuoTa.lastOperation.equals(Operation.RM)) {
                HanNuoTa.middle.push(HanNuoTa.right.pop());
                System.out.println("r -> m");
            } else if (HanNuoTa.lastOperation.equals(Operation.MR)) {
                HanNuoTa.right.push(HanNuoTa.middle.pop());
                System.out.println("m -> r");
            } else {
                HanNuoTa.middle.push(HanNuoTa.left.pop());
                lastOperation = Operation.LM;
                System.out.println("l -> m");
            }
        }

        static enum Operation {
            NO, LM, ML, MR, RM;
        }

    }


}
