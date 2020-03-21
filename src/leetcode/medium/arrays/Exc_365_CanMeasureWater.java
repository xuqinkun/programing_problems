package leetcode.medium.arrays;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_365_CanMeasureWater
 * Author:   Xu Qinkun
 * Date:     2020/3/21 9:19
 * Description: 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。
 * 请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 */

public class Exc_365_CanMeasureWater {

     static class Pair {
         int remainX, remainY;

         public Pair(int remainX, int remainY) {
             this.remainX = remainX;
             this.remainY = remainY;
         }

         @Override
         public boolean equals(Object o) {
             if (this == o) return true;
             if (o == null || getClass() != o.getClass()) return false;
             Pair pair = (Pair) o;
             return remainX == pair.remainX &&
                     remainY == pair.remainY;
         }

         @Override
         public int hashCode() {
             return Objects.hash(remainX, remainY);
         }

         @Override
         public String toString() {
             return "Pair{" +
                     "remainX=" + remainX +
                     ", remainY=" + remainY +
                     '}';
         }
     }

    public boolean canMeasureWater(int x, int y, int z) {
         if (z == 0) return true;
        Stack<Pair> stack = new Stack<>();
        Set<Pair> pairSet = new HashSet<>();
        pourWater(stack, pairSet, new Pair(x, y));
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            int remainX = pair.remainX;
            int remainY = pair.remainY;
            if (remainX == z || remainY == z || remainX + remainY == z)
                return true;
            if (remainX == 0 && remainY == 0)
                continue;
            pourWater(stack, pairSet, new Pair(remainX, 0)); // empty y
            pourWater(stack, pairSet, new Pair(0, remainY)); // empty x
            pourWater(stack, pairSet, new Pair(x, remainY));  // pour x to full
            pourWater(stack, pairSet, new Pair(remainX, y));  // pour y to full
            if (x - remainX > remainY) { // pour remainY into x
                pourWater(stack, pairSet, new Pair(remainX + remainY, 0));
            } else if (remainY + remainX - x > 0) {
                pourWater(stack, pairSet, new Pair(x, remainY + remainX - x));
            }
            if (y - remainY > x) {
                pourWater(stack, pairSet, new Pair(0, remainX + remainY)); // pour remainX into y
            } else if (remainY + remainX - y > 0) {
                pourWater(stack, pairSet, new Pair(remainY + remainX - y, y));
            }
        }
        return false;
    }

    private void pourWater(Stack<Pair> stack, Set<Pair> pairSet, Pair pair) {
        if (pair != null && !stack.contains(pair) && !pairSet.contains(pair)) {
            stack.push(pair);
            pairSet.add(pair);
        }
    }

    public static void main(String[] args) {
        Exc_365_CanMeasureWater cw = new Exc_365_CanMeasureWater();
        System.out.println(cw.canMeasureWater(1, 3, 5));
    }
}
