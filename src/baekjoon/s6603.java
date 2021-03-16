package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class s6603 {
    static final int PICK = 6;
    static boolean[] check; //중복체크
    static int[] list; //수열 저장
    static int k;
    static StringBuilder sb = new StringBuilder();
    static int[] ans;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while(true) {
            k = sc.nextInt();
            if(k == 0) break;
            list = new int[k];
            check = new boolean[k];
            ans = new int[k];
            for(int i=0;i<k;i++){
                list[i] = sc.nextInt();
            }
            go(0,0,PICK,list);
            sb.append("\n");

        }
        System.out.print(sb);
    }
    public static void go(int index, int start,int pick, int[] list){
        if(index ==  pick){
            for(int i=0;i<pick;i++){
                sb.append(ans[i]+" ");
            }
            sb.append("\n");
            return;
        }
        if(index >  k){
        }
        for(int i=start;i<k;i++){
            if(check[i]) continue;
            ans[index] = list[i];
            check[i] = true;
            go(index+1,i+1,pick,list);
            check[i] =false; //다음 수열
        }
    }
}
