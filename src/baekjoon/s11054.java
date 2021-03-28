package baekjoon;

import java.util.Scanner;

public class s11054 {
    static int n;
    static int[] list;
    static int[] du;
    static int[] dd;
    static int[] d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new int[n+2];
        du = new int[n+1];
        dd = new int[n+1];
        d = new int[n+1];
        for(int i=1;i<=n;i++){
            list[i] = sc.nextInt();
        }
        System.out.println(go(n));
    }

    public static int go(int n) {
        du[0] = 1;
        dd[0] = 1;

        for (int i = 1; i <= n; i++) {
            dd[i] = 1;
            for (int j = 1; j < i; j++) {
                if (list[i] > list[j]) {
                    dd[i] = Math.max(dd[j] + 1, dd[i]);
                }
            }
        }

        for (int i = n; i > 0; i--) {
            du[i] = 1;
            for (int j = n; j > i; j--) {
                if (list[i] > list[j]) {
                    du[i] = Math.max(du[j] + 1, du[i]);
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dd[i] + du[i]);
        }

        return max-1; //최대값
    }
}
