import java.io.IOException;
import java.util.Scanner;

public class s15650 { //브루트포스 n과 m//오름차순

    static boolean[] check = new boolean[10]; //중복체크
    static int[] list = new int[10]; //수열 저장
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        go(0,1,n,m);
        System.out.print(sb);
    }
    public static void go(int index,int start, int n, int m){ //오름차순 - start 추가
        if(index ==  m){
            for(int i=0;i<m;i++){
                sb.append(list[i]+" ");
            }
            sb.append("\n");
            return;
        }
        if(index >  n){
        }
        for(int i=start;i<=n;i++){
            if(check[i]) continue;
            list[index] = i;
            check[i] = true;
            go(index+1,i+1,n,m); //start = i+1
            check[i] =false; //다음 수열을 위함
        }
    }
}
