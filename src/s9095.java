import java.util.Scanner;

public class s9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        int n;
        int ans;
        for(int i=0; i<t; i++){
            n = sc.nextInt();
            ans = go(0,n);
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
    public static int go(int sum, int goal){
        if(goal == sum) return 1;
        else if (goal < sum) return 0;
        int ans = 0;
        for(int i=1;i<=3;i++){
            ans += go(sum+i,goal);
        }
        return ans;
    }

}
