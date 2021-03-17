package baekjoon;


import java.util.Arrays;
import java.util.Scanner;

public class s14002 {
    static int n;
    static int[] list;
    static int[] d;
    static int[] v;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        list = new int[n+1];
        d = new int[n+1];
        v = new int[n+1];
        for(int i=1;i<=n;i++){
            list[i] = sc.nextInt();
        }
        System.out.println(go(n));
        System.out.println(sb);

    }

    public static int go(int n) {
        d[1] = 1;
        if(n == 1){
            sb.append(list[n]);
            return d[n];
        }
        int max = 1;
        int last = 0;
        for(int i=2;i<=n;i++){
            d[i] = 1;
            v[i] = 0;
            for(int j=1;j<i;j++){
                if(list[j] < list[i] && d[j] >= d[i]){
                    d[i] = d[j] + 1;
                    v[i] = j;
                    if(d[i] > max){
                        max = d[i];
                        last = i;
                    }
                }
            }
        }

        lis(last);
        return max; //최대값
    }
    public static void lis(int index){
        if(index ==0) return;
        lis(v[index]);
        sb.append(list[index]+" ");
    }
}
