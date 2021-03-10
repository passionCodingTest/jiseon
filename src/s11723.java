import java.io.IOException;
import java.util.Scanner;

public class s11723 {
    static int s=0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int m = sc.nextInt();
        String cal;
        int a;
        for(int i=0;i<m;i++){
            cal = sc.next();
            switch (cal){
                case "add" :
                    a = sc.nextInt();
                    add(a);
                    break;
                case "remove" :
                    a = sc.nextInt();
                    remove(a);
                    break;
                case "check" :
                    a = sc.nextInt();
                    sb.append(check(a)+"\n");
                    break;
                case "toggle" :
                    a = sc.nextInt();
                    toggle(a);
                    break;
                case "all" :
                    all();
                    break;
                case "empty" :
                    empty();
                    break;
            }
        }
        System.out.print(sb);
    }
    public static void add(int a){
        s = s | (1<<a);
    }
    public static void remove(int a){
        s = s & ~(1<<a);
    }
    public static int check(int a){
        int check = s & (1<<a);
        if(check == 0){
            return 0;
        }
        else return 1;
    }
    public static void toggle(int a){
        s = s ^ (1<<a);
    }
    public static void all(){
        s = ~0;
    }
    public static void empty(){
        s=0;
    }
}
