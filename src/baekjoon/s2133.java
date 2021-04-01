package baekjoon;

import java.util.Scanner;

public class s2133 {
    static int n;
    static int[] d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d[] = new int[n + 1];
        d[0] = 1;

        for (int i = 2; i < n + 1; i = i + 2) {
            d[i] = d[i - 2] * 3;
            for (int j = 0; j < i - 2; j = j + 2) {
                d[i] = d[i] + d[j] * 2;
            }
        }
        System.out.println(d[n]);
    }
}
