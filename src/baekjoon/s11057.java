package baekjoon;

import java.util.Scanner;

public class s11057 {
    static int n;
//    static Long[][] d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Long[][] d = new Long[n+1][10];
        System.out.println(go(n,d));
    }

    public static Long go(int n, Long[][] d) {
        for(int i=0;i<10;i++){
            d[1][i] = 1L;
        }
        for(int i=2;i<=n;i++){
            for(int j=0;j<10;j++){
                Long sum = 0L;
                for(int k=0;k<=j;k++){
                    sum += d[i-1][k] % 10007;
                }
                d[i][j] = sum;
            }
        }
        Long sum = 0L;
        for(int i=0;i<10;i++){
            sum += d[n][i] % 10007;
        }
        return sum % 10007;
    }
}
