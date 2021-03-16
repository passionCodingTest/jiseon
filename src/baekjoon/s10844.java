package baekjoon;

import java.util.Scanner;

public class s10844 {
    static int n;
    static Long[][] d = new Long[101][11];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println(go(n));
    }
    public static Long go(int n){
        if(n == 1) {
            return 9L;
        }
        d[1][0]=0L;
        for(int j=1;j<=9;j++){
            d[1][j] = 1L;
        }
        for(int i=2;i<=n;i++){
            for(int j=0;j<=9;j++){
                if(j == 0){
                    d[i][j] = d[i-1][j+1]%1000000000;
                }
                else if(j == 9){
                    d[i][j] = d[i-1][j-1]%1000000000;
                }
                else{
                    d[i][j] = (d[i-1][j-1] + d[i-1][j+1])%1000000000;
                }
            }
        }
        Long sum = 0L;
        for(int j=0;j<=9;j++){
            sum += d[n][j];
        }
        return sum%1000000000;
    }
}
