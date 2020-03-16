package leetcode.easy.arrays;

import java.util.Arrays;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_1103_DistributeCandies
 * Author:   Xu Qinkun
 * Date:     2020/3/16 9:36
 * Description:
 */

public class Exc_1103_DistributeCandies {

    public int[] distributeCandies(int candies, int num_people) {
        int[] dist = new int[num_people];
        for (int i = 0, j = 1; candies > 0; i++, j++) {
            if (j < candies) {
                dist[i % num_people] += j;
                candies -= j;
            }
            else {
                dist[i % num_people] += candies;
                candies = 0;
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Exc_1103_DistributeCandies dc = new Exc_1103_DistributeCandies();
        System.out.println(Arrays.toString(dc.distributeCandies(10, 1)));
    }
}
