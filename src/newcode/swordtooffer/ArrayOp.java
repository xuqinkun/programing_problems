package newcode.swordtooffer;

import java.util.ArrayList;

public class ArrayOp {

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if(size <= 0 || size > num.length) return new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> deque = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            while (!deque.isEmpty() && num[deque.get(deque.size() - 1)] <= num[i])
                deque.remove(deque.size() - 1);
            while (!deque.isEmpty() && i - deque.get(0) >= size)
                deque.remove(0);
            deque.add(i);
            if (i + 1 >= size)
                list.add(num[deque.get(0)]);
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayOp op = new ArrayOp();
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(op.maxInWindows(num, 3));
    }
}
