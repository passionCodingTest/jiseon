package baekjoon;

import java.util.Scanner;

public class s15988 {
    static int t;
    static Long[] d;
    static int[] n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        t = sc.nextInt();
        n = new int[t];
        int max = 0;
        for(int i=0;i<t;i++){
            n[i] = sc.nextInt();
            max = Integer.max(n[i],max);
        }
        d = new Long[max+1];
        go(max);
        for(int i=0;i<n.length;i++){
            sb.append(d[n[i]]+"\n");
        }
        System.out.print(sb);
    }
    public static void go(int n){
        d[1] = 1L;
        d[2] = 2L;
        d[3] = 4L;
        for(int i=4;i<=n;i++){
            d[i] = (d[i-1] + d[i-2] + d[i-3])%1000000009;
        }
    }
}
