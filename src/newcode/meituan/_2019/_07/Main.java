package newcode.meituan._2019._07;

import java.util.Scanner;

public class Main {

    public boolean attack(int s, int n, int d, int x, int y, int t0, int t1, int t2) {
        int t = -1;
        while (s > 0) {
            t++;
            if (t % t0 == 0) {
                s -= n * d;
            }
            if (s <= 0) {
                return false;
            }
            if (t % t1 == 0) {
                s -= y;
            }
            if (t % t2 == 0) {
                s -= x;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int s, n, d, x, y, t0, t1, t2;
        while (num-- > 0) {
            s = sc.nextInt();
            n = sc.nextInt();
            d = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();
            t0 = sc.nextInt();
            t1 = sc.nextInt();
            t2 = sc.nextInt();
            if (new Main().attack(s, n, d, x, y, t0, t1, t2))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
