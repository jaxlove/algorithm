package practice.stackqueue.hanNuoTa;

import java.util.Stack;

/**
 * @author wangdejun
 * @description: TODO description
 * @date 2020/8/24 18:50
 */
public class WdjTest {

    static class HanNuoTa {

        Stack<Integer> left = new Stack();
        Stack<Integer> middle = new Stack();
        Stack<Integer> right = new Stack();

        private Stack<Integer> curStack = left;
        private Integer curTop = null;

        public HanNuoTa(Stack<Integer> middle) {
            this.middle = middle;
        }

        private void switchData() {
            Integer pop = middle.pop();
            curStack.push(pop);
            curTop = pop;

            switchData();
        }

        private Integer getSecond() {

        }

    }

    static enum POSITION {
        RIGHT, LEFT;
    }

}
