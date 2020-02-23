package newcode.bytedance._2019._01;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public String checker(String src) {
        if (src == null || src.isEmpty()) return src;
        char[] chars = src.toCharArray();
        ArrayList<Character> elems = new ArrayList<>();
        int n = chars.length;
        int[] counts = new int[n];
        char c = chars[0];
        elems.add(c);
        int idx = 0;
        counts[idx]++;
        for (int i = 1; i < n; i++) {
            if (chars[i] != c) {
                c = chars[i];
                idx++;
                elems.add(c);
            }
            counts[idx]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (counts[i] >= 3) {
                counts[i] = 2;
            }
            if (i > 0 && counts[i] == 2 && counts[i - 1] == 2) {
                counts[i] = 1;
            }
            int len = counts[i];
            while (len-- > 0) {
                sb.append(elems.get(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        while (n-- > 0) {
            String src = sc.nextLine();
            System.out.println(new Main().checker(src));
        }
        sc.close();
    }
}
