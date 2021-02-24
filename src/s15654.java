import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class s15654 { //브루트포스 n과 m

    static boolean[] check = new boolean[10]; //중복체크
    static int[] nList; //n개의 수 리스트
    static int[] list = new int[10]; //수열 저장
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        nList = new int[n];
        for(int i=0;i<n;i++){
            nList[i] = sc.nextInt();
        }
        Arrays.sort(nList); //사전순 정렬
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
        for(int i=0;i<n;i++){
            if(check[i]) continue;
            list[index] = nList[i];
            check[i] = true;
            go(index+1,n,m);
            check[i] =false; //다음 수열
        }
    }
}
