package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class s1759 {
    static String[] alpa; //알파벳저장
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        int l = sc.nextInt();
        int c = sc.nextInt();
        String[] alpa = new String[c];
        for(int i=0;i<c;i++){
            alpa[i] = sc.next();
        }

        Arrays.sort(alpa); 
        go(l,alpa,"",0);
        System.out.print(sb);
    }
    public static void go(int l,String[] alpa,String password,int index){
        if(l == password.length()) { //암호길이 완성
            check(password); //모음자음 검사
            return;
        }
        else if(index >= alpa.length) return; 
        go(l,alpa,password+alpa[index],index+1); //알파벳사용
        go(l,alpa,password,index+1); //알파벳사용x
    }
    public static void check(String password){ //모음자음검사
        char[] c = password.toCharArray();
        int m=0;
        int j=0;
        for(int i=0;i<c.length;i++){
            if(c[i] == 'a' || c[i] =='e'|| c[i] == 'i'|| c[i] == 'o'|| c[i] == 'u'){
                m++;
            }
            else j++;
        }
        if(m>=1 && j>=2)
            sb.append(password+"\n");
    }
}
