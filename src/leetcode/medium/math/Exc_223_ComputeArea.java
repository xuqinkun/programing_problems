package leetcode.medium.math;

public class Exc_223_ComputeArea {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int overlapX = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int overlapY = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        return overlapX * overlapY;
    }

    public static void main(String[] args) {
        Exc_223_ComputeArea ca = new Exc_223_ComputeArea();
        System.out.println(ca.computeArea(0,0,200,100, 100,75,175,150));
    }
}
