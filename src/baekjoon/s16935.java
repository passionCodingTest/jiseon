package baekjoon;

import java.util.Scanner;

public class s16935 {
    static int n,m,r;
    static int[][] a;
    static int[][] b;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        a = new int[n][m];
        b = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<r;i++){
            int a = sc.nextInt();
            if(a == 1){
                go1();
            }
            else if(a == 2){
                go2();
            }
            else if(a == 3){
                go3();
            }
            else if(a == 4){
                go4();
            }
            else if(a == 5){
                go5();
            }
            else if(a == 6){
                go6();
            }
        }

        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                sb.append(a[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    public static void go1(){
        int n = a.length;
        int m = a[0].length;
        int[][] b = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                b[n-1-i][j] = a[i][j];
            }
        }
        a = new int[b.length][b[0].length];
        a = b;
    }
    public static void go2(){
        int n = a.length;
        int m = a[0].length;
        int[][] b = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                b[i][m-1-j] = a[i][j];
            }
        }
        a = new int[b.length][b[0].length];
        a = b;
    }
    public static void go3(){
        int n = a.length;
        int m = a[0].length;
        int[][] b = new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                b[j][n-i-1] = a[i][j];
            }
        }
        a = new int[b.length][b[0].length];
        a = b;
    }
    public static void go4(){
        int n = a.length;
        int m = a[0].length;
        int[][] b = new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                b[m-1-j][i] = a[i][j];
            }
        }
        a = new int[b.length][b[0].length];
        a = b;
    }
    public static void go5(){
        int n = a.length;
        int m = a[0].length;
        int[][] b = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i<n/2 && j<m/2){  //1번그룹
                    b[i][j+m/2] = a[i][j];
                }
                else if(i<n/2 && j>=m/2){ //2번그룹
                    b[i+n/2][j] = a[i][j];
                }
                else if(i>=n/2 && j>=m/2){//3번그룹
                    b[i][j-m/2] = a[i][j];
                }
                else if(i>=n/2 && j<m/2){//4번그룹
                    b[i-n/2][j] = a[i][j];
                }
            }
        }
        a = new int[b.length][b[0].length];
        a = b;
    }
    public static void go6(){
        int n = a.length;
        int m = a[0].length;
        int[][] b = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i<n/2 && j<m/2){  //1번그룹
                    b[i+n/2][j] = a[i][j];
                }
                else if(i<n/2 && j>=m/2){ //2번그룹
                    b[i][j-m/2] = a[i][j];
                }
                else if(i>=n/2 && j>=m/2){//3번그룹
                    b[i-n/2][j] = a[i][j];
                }
                else if(i>=n/2 && j<m/2){//4번그룹
                    b[i][j+m/2] = a[i][j];
                }
            }
        }
        a = new int[b.length][b[0].length];
        a = b;
    }
}
