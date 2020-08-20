package practice.stackqueue.getMin;

/**
 * @author wangdejun
 * @description: getMin练习1
 * @date 2020/8/19 22:06
 */
public class WdjTest1 {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(2);
        stack.push(2);
        stack.push(1);
        stack.push(5);
        stack.pop();
        System.out.println(stack.getMin());
    }


    static class Stack {

        private Integer[] data;

        /**
         * 只保存不为空的排序好的数据
         */
        private Integer[] sortData;


        public Stack() {
            this.data = new Integer[0];
        }

        Integer getMin() {
            if (sortData == null || sortData.length == 0) {
                return null;
            }
            return sortData[0];
        }

        Integer pop() {
            if (data.length == 0) {
                return null;
            }
            Integer[] oldData = data;
            int oldLength = oldData.length;
            Integer element = data[oldLength - 1];
            data = new Integer[oldLength - 1];
            data = sub(oldData, oldLength - 1, 0, oldLength - 1);
            removeElementFromSort(element);
            return element;
        }

        void push(Integer element) {
            Integer[] oldData = data;
            int oldLength = oldData.length;
            data = sub(oldData, oldLength + 1, 0, oldLength);
            data[oldLength] = element;
            insertSorData(element);
        }


        private void removeElementFromSort(Integer element) {
            if (element != null) {
                Integer[] newSortData = new Integer[sortData.length - 1];
                int newIndex = 0;
                //是否已经移除数据
                boolean flag = false;
                for (int i = 0; i < sortData.length; i++) {
                    if (!sortData[i].equals(element) || flag) {
                        newSortData[newIndex] = sortData[i];
                        newIndex++;
                    }else {
                        flag = true;
                    }
                }
                sortData = newSortData;
            }
        }

        private void insertSorData(Integer element) {
            if (element != null) {
                int insertIndex = 0;
                if (sortData == null) {
                    sortData = new Integer[0];
                }
                if (sortData.length > 0) {
                    for (int i = 0; i < sortData.length; i++) {
                        if (sortData[i] <= element) {
                            i++;
                            insertIndex = i;
                        }
                    }
                }
                sortData = addElementAt(sortData, element, insertIndex);
            }
        }

        private Integer[] addElementAt(Integer[] data, Integer element, int index) {
            Integer[] newData = new Integer[data.length + 1];
            if (data.length == 0) {
                newData[0] = element;
                return newData;
            }

            int oldIndex = 0;
            for (int i = 0; i < newData.length; i++) {
                if (i == index) {
                    newData[i] = element;
                } else {
                    newData[i] = data[oldIndex];
                    oldIndex++;
                }

            }
            return newData;
        }

        private Integer[] sub(Integer[] oldData, int newLength, int start, int end) {
            if (start >= oldData.length) {
                return new Integer[newLength];
            }
            Integer[] newData = new Integer[newLength];
            for (int i = start; i < end; i++) {
                newData[i] = oldData[i];
            }
            return newData;
        }

    }

}


