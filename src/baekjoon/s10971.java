package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class s10971 {
    static int n;
    static int[][] w;
    static int[] d;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = new int[n][n]; //i에서 j까지 방문하는 비용
        d = new int[n]; //i번째 방문하는 도시의 순서
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                w[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            d[i] = i;
        }
        tsp(d);
        System.out.print(min);
    }
    public static boolean next(int[] s){
        //오름차순
        int i = n-1;
        while(i>0 && s[i-1] >= s[i]){
            i--;
        }
        if(i<=0) return false;
        int j=n-1;
        while(s[j] <= s[i-1]){
            j--;
        }
        swap(s,i-1,j);
        j=n-1;
        while(i<j){
            swap(s,i,j);
            i++;
            j--;
        }
        return true;
    }
    public static void swap(int[] array, int i1, int i2){
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }

    public static void tsp(int[] d){

        do {
            boolean ok = true;
            int sum=0;
            //갈수있는방향인지 확인
            for (int i = 0; i < n - 1; i++) {
                if (w[d[i]][d[i + 1]] == 0) { //갈수없는방향일때
                    ok = false;
                } else { //갈수있는방향일때
                    sum += w[d[i]][d[i + 1]];
                }
            }
            //다시되돌아가는 방향 확인
            if (ok && w[d[n - 1]][d[0]] != 0) { //되돌아가는길이 가능할때
                sum += w[d[n - 1]][d[0]];
                min = Math.min(min,sum);
            }
        } while(next(d));
    }
}
