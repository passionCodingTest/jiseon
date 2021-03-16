package baekjoon;

import java.util.Scanner;

public class s11726 { //마지막 채워지는 직사각형을 생각
    static int[] d; //2*n 직사각형을 채우는 방법의 수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n+1];
        int result = go(n);
        System.out.print(result);
    }
    public static int go(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        d[1] = 1;
        d[2] = 2;
        for(int i=3;i<=n;i++){
            d[i] = (d[i-1] + d[i-2])%10007;
        }
        return d[n];
    }
}
