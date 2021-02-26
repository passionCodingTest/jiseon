import java.io.IOException;
import java.util.Scanner;

public class s14501 {
    static int[] t; //상담 일수
    static int[] p; //상담 페이
    static int max=0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        t = new int[n+1];
        p = new int[n+1];

        for(int i=1; i<=n; i++){
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        go(n,1,0);
        System.out.print(max);
    }
    public static void go(int n, int index, int sum){
        if(n+1 == index){ //n+1되는날 퇴사
            if(max<sum) max=sum;
            return;
        }
        if(index > n+1){ //퇴사일을 넘어가는 상담 일수
            return;
        }
        //일한다
        go(n,index+t[index],sum+p[index]);
        //일안한다
        go(n,index+1,sum);
    }
}
