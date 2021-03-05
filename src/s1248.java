import java.io.IOException;
import java.util.Scanner;

public class s1248 {
    static int n;
    static int[][] s;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String str = sc.next();
        s = new int[n][n];
        ans = new int[n];
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                char x = str.charAt(cnt);
                if(x == '0'){
                    s[i][j] = 0;
                }
                else if(x == '+'){
                    s[i][j] = 1;
                }
                else if(x == '-'){
                    s[i][j] = -1;
                }
                cnt++;
            }
        }
        go(0);
        for(int i =0;i<n;i++){
            System.out.print(ans[i]+" ");
        }

    }
    public static boolean go(int index){
        if(index == n){
            return true;
        }
        if (s[index][index] == 0) { //s[i][i]의 부호 == ans[i]
            ans[index] = 0;
            return check(index) && go(index+1);
        }
        for (int i=1; i<=10; i++) {
            ans[index] = s[index][index]*i;
            if (check(index) && go(index+1)) return true;
        }
        return false;
    }
    public static boolean check(int index){
        int sum = 0;
        for(int i = index;i>=0;i--){
            sum += ans[i];
            if (s[i][index] == 0) { //0일때
                if (sum != 0) return false; //아니면
            } else if (s[i][index] < 0) { //음수일때
                if (sum >= 0) return false; //아니면
            } else if (s[i][index] > 0) { //양수일때
                if (sum <= 0) return false; //아니면
            }
        }
        return true; //맞을때
    }
}
