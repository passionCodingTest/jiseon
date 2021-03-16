package programmers;

import java.util.ArrayList;
import java.util.Arrays;

class s3 {
    static String[] participant = {"mislav", "stanko", "mislav", "ana"};
    static String[] completion = {"stanko", "ana", "mislav"};

    public static void main(String[] args) {

        System.out.println(solution(participant, completion));
//        solution(participant,completion);
    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0;i<participant.length;i++){
                if(!participant[i].equals(completion[i])){
                    answer = participant[i];
                    break;
                }
        }
        return answer;
    }

}
