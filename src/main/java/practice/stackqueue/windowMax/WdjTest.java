package practice.stackqueue.windowMax;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class WdjTest {

    static class WindowMax {
        private Integer[] arr;
        private int windowSize;
        private Queue<Integer> max;

        public WindowMax(Integer[] arr, int windowSize) {
            this.arr = arr;
            this.windowSize = windowSize;
            max = new LinkedBlockingDeque<>();
        }

        private Integer[] getWindowMax() throws Exception {
            if (this.windowSize > this.arr.length) {
                throw new Exception("窗口太大");
            }
            getFirstMax(this.arr, this.windowSize);
            Integer[] returArr = new Integer[this.arr.length - this.windowSize + 1];
            if (this.windowSize == this.arr.length) {
                returArr[0] = max.peek();
                return returArr;
            }
            for (int i = this.windowSize; i < this.arr.length; i++) {
                int curMax;
                Integer newInt = arr[i];
                Integer oldInt = arr[i - this.windowSize];
                if(oldInt == max.peek()){
                    max.poll();
                }
                if (newInt < max.peek()) {
                    curMax = max.peek();
                } else if (newInt == max.peek()) {

                }
            }
        }

        private Integer getMax(Integer[] integers) {
            Integer max = integers[0];
            if (integers.length == 1) {
                return max;
            }
            for (int i = 1; i < integers.length; i++) {
                if (integers[i] > max) {
                    max = integers[i];
                }
            }
            return max;
        }

        private Integer getMax(Integer integer1, Integer integer2) {
            return integer1 > integer2 ? integer1 : integer2;
        }

        private void getFirstMax(Integer[] integers, int length) {
            max.add(integers[0]);
            for (int i = 1; i < length; i++) {
                if (integers[i] == max.peek()) {
                    max.add(integers[i]);
                } else if (integers[i] > max.peek()) {
                    max = new LinkedBlockingDeque();
                    max.add(integers[i]);
                }
            }
        }

    }
}
