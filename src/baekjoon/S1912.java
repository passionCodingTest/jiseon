package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class S1912 {
    static int n;
    static int[] d; //i번째 수로 끝나는 가장 큰 연속합
    static int[] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        d = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        System.out.println(go(n));
    }
    public static int go(int n){ //max(d[i-1]+a[i],a[i])
        d[0] = a[0];
        for(int i=1;i<n;i++){
            d[i] = Math.max(d[i-1]+a[i],a[i]);
        }

        Arrays.sort(d);
        return d[d.length-1];
    }
}
