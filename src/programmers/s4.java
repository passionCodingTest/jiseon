package programmers;

class s4 {
    public static void main(String[] args) {
        step1("ABNC");
        step2("@#$%^.1234-");
        step3("...f.......d..e.");
        step4(".abc.");
    }
    public String solution(String new_id) {
        String answer = "";
        return answer;
    }
    public static void step1(String new_id){
        System.out.println(new_id.toLowerCase());
    }
    public static void step2(String new_id){
        System.out.println(new_id.replaceAll("[^a-z\\d\\-\\_\\.]", ""));
    }
    public static void step3(String new_id){
        System.out.println(new_id.replaceAll("[.]{2,}", "."));
    }
    public static void step4(String new_id){
        System.out.println(new_id.replaceAll("^\\.", "").replaceAll("\\.$",""));
    }
    public static void step5(String new_id){
        if(new_id.equals(""))
            new_id = "a";
    }
    public static void step6(String new_id){
        if(new_id.length() >= 16){
            new_id.substring(0,15);
            new_id.replaceAll("[.]$","");
        }
    }
    public static void step7(String new_id){
        if(new_id.length() <= 2){
            while(new_id.length() < 3)
                new_id += new_id.charAt(new_id.length()-1);
        }
    }

}