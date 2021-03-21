package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class s14501_d {
    static int[] t; //상담 일수
    static int[] p; //상담 페이
    static int[] d;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = new int[n+2];
        p = new int[n+2];
        d = new int[n+2];

        for(int i=1; i<=n; i++){
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        for (int i=n; i>0; i--) {
            int day = i + t[i];     // i번째 날의 상담기간

            if (day > n + 1)
                d[i] = d[i + 1];
            else    // 상담일 초과
                d[i] = Math.max(p[i] + d[day], d[i + 1]);
        }
        System.out.println(d[1]);
    }
}
