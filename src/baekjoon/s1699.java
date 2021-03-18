package baekjoon;

import java.util.Scanner;

public class s1699 {
    static int n;
    static int[] d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d = new int[n+1];
        System.out.println(go(n));
    }
    public static int go(int n){
        d[1] = 1;
        for(int i=2;i<n+1;i++){
            int min = Integer.MAX_VALUE;
            for(int j=1;j<=n && i>=j*j;j++){
                if(min > d[i-j*j]){
                    min = d[i-j*j];
                }
            }
            d[i] = min + 1;
        }
        return d[n];
    }
}
