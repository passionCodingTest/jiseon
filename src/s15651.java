import java.io.IOException;
import java.util.Scanner;

public class s15651 {//브루트포스 n과 m//중복o
    static int[] list = new int[10]; //수열 저장
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        go(0,n,m);
        System.out.print(sb);
    }
    public static void go(int index, int n, int m){
        if(index ==  m){
            for(int i=0;i<m;i++){
                sb.append(list[i]+" ");
            }
            sb.append("\n");
            return;
        }
        if(index >  n){
        }
        for(int i=1;i<=n;i++){
            list[index] = i;
            go(index+1,n,m);
        }
    }
}
