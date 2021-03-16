package baekjoon;

import java.util.Scanner;

public class s2193 {
    static int n;
    static Long[][] d = new Long[91][2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println(go(n));
    }
    public static Long go(int n) {
        if(n==1 || n == 2) return 1L;

        d[1][0] = 0L;
        d[1][1] = 1L;
        d[2][0] = 1L;
        d[2][1] = 0L;

        for(int i=3;i<=n;i++){
            for(int j=0;j<=1;j++){
                if(j==1){
                    d[i][j] = d[i-1][0];
                }
                else{
                    d[i][j] = d[i - 1][0] + d[i - 1][1];
                }
            }
        }
        Long sum=0L;

        for (int j = 0; j <= 1; j++) {
            sum += d[n][j];
        }
        return sum;
    }
}
