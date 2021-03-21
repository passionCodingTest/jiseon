package baekjoon;

import java.util.Scanner;

public class s2225 {
    static int n,k;
    static long[][] d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        d = new long[k+1][n+1];

        d[0][0] = 1l;
        for(int i=1;i<=k;i++){
            for(int j=0;j<=n;j++){
                for(int l=0;l<=j;l++){
                    d[i][j] += d[i-1][j-l];
                    d[i][j] %= 1000000000;
                }
            }
        }
        System.out.println(d[k][n]);

    }
}
