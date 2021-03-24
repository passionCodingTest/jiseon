package baekjoon;

import java.util.Scanner;

public class s2156 {
    static int n;
    static int[][] d; //i번째 포도주를 j번 연속해서 마신 포도주 양
    static int[] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d = new int[n][3];
        a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        System.out.println(go(n));
    }
    public static int go(int n){
        d[0][0] = 0;
        d[0][1] = a[0];
        d[0][2] = a[0];
        for(int i=1;i<n;i++){
            d[i][0] = Integer.max(d[i - 1][0], Integer.max(d[i - 1][1], d[i - 1][2])); //i번째 포도주를 안마시기 때문에 i-1은 몇번 연속 마신든 상관x
            d[i][1] = d[i-1][0] + a[i]; //i번째 포도주를 1번 연속 마셔야하기 때문에 i-1은 마시면 안됨
            d[i][2] = d[i-1][1] + a[i]; //i번째 포도주를 2번 연속 마셔야하기 때문에 i-1은 1번 연속 마셨어야됨
        }
        return Integer.max(d[n - 1][0], Integer.max(d[n - 1][1], d[n - 1][2]));
    }
}
