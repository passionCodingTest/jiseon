package programmers;

import java.util.*;
class s2 {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) {

    }
    public int[] solution(int index, int[] numbers) {
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                list.add(numbers[i]+numbers[j]);
            }
        }
        Integer[] temp = list.toArray(new Integer[list.size()]);
        int[] answer = Arrays.stream(temp).mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }
}