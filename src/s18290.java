import java.io.IOException;
import java.util.Scanner;

public class s18290 {
    static int[] nx = {-1,1,0,0}; //인접행
    static int[] ny = {0,0,-1,1}; //인접열
    static boolean[][] check; //중복체크
    static int[][] board; //격자판
    static int n,m,k;
    static int max=Integer.MIN_VALUE; //격자판에 들어있는 수는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이다.
                                        //격자판에 음의 정수도 들어가기때문에 정수의 최소값으로 초기화
                                     //처음에 0으로 초기화했다가 틀림
    public static void go(int prev_x,int prev_y,int cnt,int sum){ //전에 사용했던 x,y를 사용하여 범위를 줄임
        if(cnt == k){
            if(max < sum) max=sum;
            return;
        }
        for(int i=prev_x; i<n; i++){ 
            for(int j=(i == prev_x ? prev_y : 0); j<m; j++){ 
                if(check[i][j]) continue;
                boolean ok = true;
                for(int k=0; k<4; k++){
                    int x = i+nx[k]; 
                    int y = j+ny[k];
                    if(0<=x && n>x && 0<=y && m>y){ //인접칸 검사
                        if(check[x][y]) ok=false; //인접칸이 한개라도 있다면 false
                    }
                }
                if(ok){ //인접칸이 없다면 선택한다
                    check[i][j]=true; //선택한칸 사용 체크
                    go(i,j,cnt+1,sum+board[i][j]);
                    check[i][j]=false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        board = new int[n][m];
        check = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j =0;j < m;j++){
                board[i][j] = sc.nextInt();
            }
        }
        go(0,0,0,0);
        System.out.println(max);
    }
}
