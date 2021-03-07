import java.io.IOException;
import java.util.Scanner;

public class s10974 {
    static int n;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        n = sc.nextInt();
        int[] s = new int[n];
        for(int i=0;i<n;i++) {
            s[i] = i + 1;
            sb.append(i+1+" ");
        }
        sb.append("\n");
        next(s);
        System.out.print(sb);
    }
    public static void next(int[] s){
        //오름차순
        int i = n-1;
        while(i>0 && s[i-1] >= s[i]){
            i--;
        }
        if(i<=0) return;
        int j=n-1;
        while(s[j] <= s[i-1]){
            j--;
        }
        swap(s,i-1,j);
        j=n-1;
        while(i<j){
            swap(s,i,j);
            i++;
            j--;
        }
        for(int k=0;k<n;k++){
            sb.append(s[k]+" ");
        }
        sb.append("\n");
        next(s);
    }
    public static void swap(int[] array, int i1, int i2){
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }

}
