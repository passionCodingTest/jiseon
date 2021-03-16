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
        list = new int[n];
        d = new int[n];
        v = new int[n];
        for(int i=0;i<n;i++){
            list[i] = sc.nextInt();
        }
        System.out.println(go(n));
        System.out.println(sb);

    }

    public static int go(int n) {
        d[0] = 1;
        for(int i=1;i<n;i++){
            d[i] = 1;
            v[i] = 0;
            for(int j=i-1;j>=0;j--){
                if(list[j] < list[i]){
                    int temp = d[j] + 1;
                    if(temp > d[i]){
                        d[i] = temp;
                        v[i] = j;
                    }
                }
            }
        }

        Arrays.sort(d);
        int index = 0;
        for(int i=0;i<n;i++){
            if(d[i] == d[d.length-1]){
                index = i;
            }
        }
        lis(index);


        return d[d.length-1]; //최대값
    }
    public static void lis(int index){
        if(index == 0) return;
        sb.append(list[v[index]]+" ");
        lis(v[v[index]]);
    }
}
