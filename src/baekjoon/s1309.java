package baekjoon;

import java.util.Scanner;

public class s1309 {
    static int n;
    static Long[][] d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d = new Long[n + 1][3]; // xx , xo, ox =>n번째 줄을 채우는 세가지 방법
        System.out.println(go(n));
    }
    public static Long go(int n){
        d[1][0] = 1L;
        d[1][1] = 1L;
        d[1][2] = 1L;
        for(int i=2;i<=n;i++){
            d[i][0] = (d[i - 1][0] + d[i - 1][1] + d[i - 1][2]) % 9901;
            d[i][1] = (d[i - 1][0] + d[i - 1][2]) % 9901;
            d[i][2] = (d[i - 1][0] + d[i - 1][1]) % 9901;
        }
        Long sum = 0L;
        for(int i=0;i<3;i++){
            sum += d[n][i] % 9901;
        }
        return sum % 9901;
    }
}
