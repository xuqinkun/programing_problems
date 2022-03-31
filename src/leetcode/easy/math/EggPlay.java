package leetcode.easy.math;

public class EggPlay {
    public int opNum(int x, int y) {
        if (x == y) return 0;
        if (x < y) {
            if (x % 3 == 0) {
                return Math.min(opNum(x + 1, y), opNum(x / 3, y)) + 1;
            } else {
                return opNum(x + 1, y) + 1;

            }
        } else if (x % 3 == 0) {
            return opNum(x / 3, y) + 1;
        } else {
            return opNum(x + 1, y) + 1;
        }
    }

    public static void main(String[] args) {
        EggPlay ep = new EggPlay();
        System.out.println(ep.opNum(4, 2));
        System.out.println(ep.opNum(4, 1));
        System.out.println(ep.opNum(2, 2));
        System.out.println(ep.opNum(9, 3));
    }
}
