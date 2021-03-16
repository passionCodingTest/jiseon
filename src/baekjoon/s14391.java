package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class s14391 {
    static int n,m;
    static int[][] list;
    static int bitmask;
    static int max = 0;
    //A[i][j] -> i*M+j
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        list = new int[n][m];
        for(int i=0;i<n;i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                list[i][j] = s.charAt(j)-'0';
            }
        }
        sum();
        System.out.println(max);
    }
    //가로0 세로1
    public static void sum(){
        for(int s=0;s<(1<<n*m);s++){
            int sum=0;
            for(int i=0;i<n;i++){
                int cul = 0;
                for(int j=0;j<m;j++){
                    int k = i*m+j;
                    if((s&(1<<k)) == 0){
                        cul = cul * 10 +list[i][j];
                    }
                    else{
                        sum += cul;
                        cul=0;
                    }
                }
                sum += cul;
            }
            for(int j=0;j<m;j++){
                int cul = 0;
                for(int i=0;i<n;i++){
                    int k = i*m+j;
                    if((s&(1<<k)) != 0){
                        cul = 10 * cul+list[i][j];
                    }
                    else{
                        sum += cul;
                        cul = 0;
                    }
                }
                sum += cul;
            }
            max = Math.max(max,sum);

        }
    }
}
