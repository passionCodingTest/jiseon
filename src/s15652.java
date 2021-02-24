import java.io.IOException;
import java.util.Scanner;

public class s15652 { //브루트포스 n과 m//중복o , 비내림차순 - 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
    
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
            list[index] = i;
            go(index+1,i,n,m); //start = i =>중복가능하기 때문
        }
    }
}
