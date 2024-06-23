import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Quiz {

  //The scanner to get user inputs
  public Scanner scanner = new Scanner(System.in);
  //The Questions/Answer map (the keys are the question and the values are the answer map)
  private Map<String, Map<Character, String>> QA = new HashMap<String, Map<Character, String>>();
  //The questions/goodAnswer map (the keys are the questions and the values are the good answer)
  private Map<String,Character> questionGoodAnswer = new HashMap<String, Character>();

  public Map<String, Map<Character, String>> getQA(){
    return this.QA;
  }

  public Quiz(){
    populateQuiz();
  }
  
  //Populate the quiz with questions/answers
  public void populateQuiz(){
    int questionNum = 0;
    do {
      System.out.print("Insert question #" + questionNum + ": ");
      String question = scanner.nextLine();
      QA.put(question, populateAnswer());
      System.out.print("Which letter is the good answer A/B/C ? ");
      questionGoodAnswer.put(question, scanner.next().charAt(0));
      scanner.nextLine();
      questionNum++;
      System.out.print("Do you wish to add question to the quiz ? (y/n)");
    } while (scanner.nextLine().equals("y"));
  }

  //Populate the answers map of a question (A/B/C are the keys and their values are answer string)
  public Map<Character, String> populateAnswer(){
    char abc[] = {'A','B', 'C'};
    Map<Character,String> answerSet = new HashMap<Character, String>();
    for(char letter : abc){
      System.out.print("Answer " + letter +": ");
      answerSet.put(letter, scanner.nextLine());
    }
    return answerSet;
  }
  //Method to validate a user answer
  public boolean validateAnswer(String question, char answer){
    scanner.nextLine();
    return (questionGoodAnswer.get(question) == answer);
  }

}
