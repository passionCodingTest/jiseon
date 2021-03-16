package baekjoon;


import java.util.Arrays;
import java.util.Scanner;

public class s654 {
    static int n;
    static int[] list;
    static int[] d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new int[n];
        d = new int[n];
        for(int i=0;i<n;i++){
            list[i] = sc.nextInt();
        }
        System.out.println(go(n));
    }

    public static int go(int n) {
        d[0] = 1;
        for(int i=1;i<n;i++){
            d[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(list[j] < list[i]){
                    int temp = d[j] + 1;
                    if(temp > d[i]){
                        d[i] = temp;
                    }
                }
            }
        }
        Arrays.sort(d);
        return d[d.length-1]; //최대값
    }
}
