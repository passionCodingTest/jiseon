package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class s2529 {

    static int k;
    static String[] sign;
    static Long max = Long.MIN_VALUE;
    static Long min = Long.MAX_VALUE;
    public static void main(String[] args) throws  IOException,NumberFormatException {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        sign = new String[k];

        for(int i=0;i<k;i++){
            sign[i] = sc.next();
        }
        go(0,"");

        System.out.println(String.format("%0"+Integer.toString(k+1)+"d", max));
        System.out.println(String.format("%0"+Integer.toString(k+1)+"d", min));
    }

    public static void go(int index, String result){
        if(result.length() == k+1){

            if(max < Long.parseLong(result)) {
                max = Long.parseLong(result);
            }
            if(min > Long.parseLong(result)) {
                min = Long.parseLong(result);
            }
            return;
        }
        for(int i=0;i<10;i++){
            if(result.contains(Integer.toString(i))) continue;
            if(index == 0 || ok(result.charAt(index-1),(char)(i+'0'),sign[index-1])) {
                go(index + 1, result + Integer.toString(i));
            }
        }
    }
    public static boolean ok(char a, char b,String sign){
        if(a==b) return false;
        if(sign.equals(">")){
            if(a < b) {
                return false;
            }
        }
        if(sign.equals("<")){
            if(a > b) {
                return false;
            }
        }
        return true;
    }
}
