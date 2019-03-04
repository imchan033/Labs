import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



class QuizInfo {
    String question;
    String answer;
    int result;
    
    public QuizInfo(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.result = 0;
    }
    
    public String toString() {
        return "����:"+this.question+" ����:"+this.answer+" ä��:"+this.result;
    }
}


public class Ex15_HashMap_Quiz_Object {
	public static void main(String[] args) {
		HashMap<String, QuizInfo> quiz = new HashMap<>();  //key ����,  value ���
        quiz.put("1+1", new QuizInfo("1+1", "2"));
        quiz.put("1+3", new QuizInfo("1+3", "4"));
        quiz.put("1+4", new QuizInfo("1+4", "5"));
        
        Scanner sc = new Scanner(System.in);
        String answer;
        
        for(Map.Entry m : quiz.entrySet()) {
        	System.out.print(m.getKey()+"=");
        	answer = sc.nextLine();
        	if(answer.equals(((QuizInfo)m.getValue()).answer)){
        		System.out.println("����!");
        		((QuizInfo)m.getValue()).result += 10;
        	}else {
        		System.out.println("����!");
        	}
        	
        }
        
       /*
        for(int i = 0 ; i < quiz.size() ; i++) {
            Set set =quiz.keySet();
            Object[] obj= set.toArray();
            System.out.println("���� : "+obj[i]);
            System.out.println(quiz.get(quiz.keySet().toArray()[i]));
            //System.out.println(quiz.keySet().toArray()[i]);
            Scanner sc = new Scanner(System.in);
            String answer = sc.nextLine().trim();
            
            if(answer.equals(quiz.get(quiz.keySet().toArray()[i]))) {
            	System.out.println("����!");
            	
            }else {
            	System.out.println("����!");
            }
        }
        */

	}

}
