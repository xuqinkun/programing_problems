package newcode.swordtooffer;

import java.util.Arrays;

public class DP {

    public int cutRod(int[] prices, int size) {
        if(size == 0) return 0;
        int p = 0;
        for (int i = 1; i <= size; i++) {
            p = Math.max(p, prices[i - 1] + cutRod(prices, size - i));
        }
        return p;
    }

    public int cutRod(int[] prices, int n, int [] memory, int[] solution) {
        if (memory[n] > 0) return memory[n];
        int p = -1;
        if(n == 0) {
            p = 0;
        } else {
            for (int i = 1; i <= n; i++) {
                int temp = prices[i - 1] + cutRod(prices, n - i, memory, solution);
                if(p < temp) {
                    p = temp;
                    solution[n] = i;
                }
            }
        }
        memory[n] = p;
        return p;
    }

    public int bottomUpCutRod(int[] prices, int n) {
        int [] memory = new int[n + 1];
        memory[0] = 0;
        int max;
        for (int i = 1; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= i; j++) {
                max = Math.max(max, prices[j - 1] + memory[i - j]);
            }
            memory[i] = max;
        }
        return memory[n];
    }

    public int Fibonacci(int n, int [] fi) {
        int f;
        if (fi[n] != -1){
            return fi[n];
        }
        else if(n == 0) {
            f = 0;
        }
        else if (n == 1) {
            f = 1;
        }
        else {
            f = Fibonacci(n - 1, fi) + Fibonacci(n - 2, fi);
        }
        fi[n] = f;
        return f;
    }

    public int BottomUpFibonacci(int n, int [] fi) {
        fi[0] = 0;
        fi[1] = 1;
        for (int i = 2; i <= n; i++) {
            fi[i] = fi[i - 1] + fi[i -2];
        }
        return fi[n];
    }

    public static void main(String[] args) {
        DP dp = new DP();
//        int[] prices = new int[]{1,5,8,9,10,17,17,20,24,30};
//        int n = 10;
//        int[] mem = new int[n+1];
//        Arrays.fill(mem, -1);
//        System.out.println(dp.cutRod(prices, n));
//        int[] solution = new int[n+1];
//        dp.cutRod(prices,n,mem, solution);
//        System.out.println(dp.bottomUpCutRod(prices, 10));
        int n = 10;
        int[] fi = new int[n + 1];
        Arrays.fill(fi, -1);
        int f = dp.BottomUpFibonacci(n, fi);
        System.out.println(f);
    }
}
