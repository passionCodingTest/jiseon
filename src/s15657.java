import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class s15657 {
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
        go(0,0,n,m);
        System.out.print(sb);
    }
    public static void go(int index,int start, int n, int m){ //오름차순
        if(index ==  m){
            for(int i=0;i<m;i++){
                sb.append(list[i]+" ");
            }
            sb.append("\n");
            return;
        }
        if(index >  n){
        }
        for(int i=start;i<n;i++){
            list[index] = nList[i];
            go(index+1,i, n,m); //오른차순
        }
    }
}
