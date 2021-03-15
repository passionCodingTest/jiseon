import java.util.Scanner;

public class s9095_d {
    static int[] d = new int[11];

    public static void main(String[] args) {
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        d[4] = 7;
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n;
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            sb.append(go(n)+"\n");
        }
        System.out.print(sb);
    }

    public static int go(int n) {
        if (d[n] != 0) {
            return d[n];
        }
        for (int i = 5; i <= n; i++) {
            d[i] = d[i - 3] + d[i - 2] + d[i - 1];
        }
        return d[n];
    }
}
