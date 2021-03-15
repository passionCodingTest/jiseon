import java.util.Scanner;

public class s11052 {

    static int[] d;
    static int[] p;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        p = new int[n+1];
        d = new int[n+1];
        for(int i=1;i<=n;i++){
            p[i] = sc.nextInt();
        }
        System.out.print(go(n));
    }
    public static int go(int n){
        d[0]=0;
        p[0]=0;
        if(n == 1) {
            return d[1];
        }
        for(int i=1;i<=n;i++){
            int temp;
            d[i] = 0 ;
            for(int j=0;j<=i;j++){
                temp = d[i-j]+p[j];
                if(d[i]<temp) {
                    d[i] = temp;
                }
            }
        }
        return d[n];
    }
}
