package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class s1182 {
    static int n,s;
    static int[] a;
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        for(int i=1;i<(1<<n);i++){
            int sum = 0;
            for(int k=0;k<n;k++){
                if( (i&(1<<k)) != 0){
                    sum += a[k];
                }
            }
            if(sum == s) cnt++;
        }
        System.out.print(cnt);


    }

}
