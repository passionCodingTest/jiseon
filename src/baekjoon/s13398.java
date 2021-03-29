package baekjoon;


import java.util.Scanner;

public class s13398 {
    static int n;
    static int[] d1,d2; //i번째 수로 끝나는 가장 큰 연속합
    static int[] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        d1 = new int[n];
        d2 = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        System.out.println(go(n));
    }
    public static int go(int n){ //max(d[i-1]+a[i],a[i])
        d1[0] = a[0];
        int ans = d1[0];
        for(int i=1;i<n;i++){
            d1[i] = Math.max(d1[i-1]+a[i],a[i]); //i까지의 연속합
            ans = Math.max(ans, d1[i]);
        }
        d2[n - 1] = a[n - 1];
        for(int i=n-2;i>=0;i--){
            d2[i] = Math.max(d2[i + 1] + a[i], a[i]); //i이후의 연속합
        }
        for (int i = 1; i < n - 1; i++) {
            int temp = d1[i - 1] + d2[i + 1]; //i를 뺀 수열

            ans = Math.max(ans, temp); //i를 안 뺀 수열과 뺀 수열 비교
        }
        return ans;
    }
}
