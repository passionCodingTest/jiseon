import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class s10973 {
    static int n;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new int[n];
        String[] s = br.readLine().split(" ");
        list = Arrays.asList(s).stream().mapToInt(Integer::parseInt).toArray();
        if(next(list)) {
            for(int i=0;i<n;i++){
                System.out.print(list[i]+" ");
            }
        }
        else System.out.print(-1);
    }
    public static boolean next(int[] array){
        //뒤에서부터 비교- 내림차순
        int i = n-1;
        while(i>0 && array[i-1] <= array[i]) i--; //i-1 index가 바꿔야할
        //첫번째순열인 경우 false return
        if(i<=0) return  false;
        //오름차순아니면 i-1
        int j = n-1;
        while(array[j] >= array[i-1]){
            j--;
        }
        swap(array,i-1,j);

        j=n-1;

        while(i<j){
            swap(array,i,j);
            i++;
            j--;
        }
        return true;
    }
    public static void swap(int[] array, int i1, int i2){
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }
}
