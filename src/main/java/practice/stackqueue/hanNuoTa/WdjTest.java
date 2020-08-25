package practice.stackqueue.hanNuoTa;

import java.util.Stack;

/**
 * @author wangdejun
 * @description: TODO description
 * @date 2020/8/24 18:50
 */
public class WdjTest {

    public static void main(String[] args) {
        int count = 3;
        new HanNuoTa().handleData(count,'A','C','B');
    }

    static class HanNuoTa {

        static Stack<Integer> left = new Stack();
        static Stack<Integer> middle = new Stack();
        static Stack<Integer> right = new Stack();


        void handleData(Integer num,char from ,char to,char free) {
            if(num == 1){
                System.out.println(num + " " + from + "-> "+ to);
            }else {
                handleData(num -1,from,free,to);
                System.out.println(num + " " + from + "-> "+ to);
                handleData(num-1,free,to,from);
            }
        }
    }

}
