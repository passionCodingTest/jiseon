package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class s1932 {
    static int n;
    static int[][] d;
    static int[][] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][n];
        d = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println(go(n));
    }
    public static int go(int n){
        d[0][0] = a[0][0];
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    d[i][j] = d[i-1][j] + a[i][j];
                }
                else d[i][j] = Integer.max(d[i-1][j],d[i-1][j-1])+a[i][j];
            }
        }
        Arrays.sort(d[n-1]);
        return d[n-1][n-1];
    }
}
