package baekjoon;

import java.util.Scanner;

public class s1149 {
    static int n;
    static int[][] d;
    static int[][] c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d = new int[n+1][3];
        c = new int[n+1][3];
        for(int i=1;i<c.length;i++){
            for(int j=0;j<c[0].length;j++){
                c[i][j] = sc.nextInt();
            }
        }
        System.out.println(go(n));
    }
    public static int go(int n){
        for(int i=1;i<c.length;i++){
            d[i][0] = c[i][0] + Integer.min(d[i-1][1],d[i-1][2]);
            d[i][1] = c[i][1] + Integer.min(d[i-1][0],d[i-1][2]);
            d[i][2] = c[i][2] + Integer.min(d[i-1][0],d[i-1][1]);
        }
        int result = Integer.min(d[n][0],Integer.min(d[n][1],d[n][2]));
        return result;
    }
}
