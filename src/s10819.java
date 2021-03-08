import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class s10819 {
    static int n;
    static int max=0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        compare(a);
        max = Math.max(max,compare(a));
        next(a);
        System.out.print(max);

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
        max = Math.max(max,compare(s));
        next(s);
    }
    public static void swap(int[] array, int i1, int i2){
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }
    public static int compare(int[] a){
        int sum=0;
        for(int i=0;i<n-1;i++){
            sum += Math.abs(a[i]-a[i+1]);
        }
        return sum;
    }
}
