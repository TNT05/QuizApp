import java.util.Iterator;

//This class orchestrate the process of a quiz 
public class QuizService {
  //The quiz (containing questions/answers and question/goodAnswer)
  private Quiz quiz;
  //The player score
  private int score = 0;

  //Upon instantiation, the user is required to populate the quiz
  public QuizService(){
    this.quiz = new Quiz();
  }

  //Process to play the Quiz
  public void playQuiz(){
    Iterator iterator = quiz.getQA().keySet().iterator();
    while(iterator.hasNext()){
      String question = (String) iterator.next();
      System.out.println(question);

      System.out.println(quiz.getQA().get(question));
      System.out.print("Which letter is the correct answer A/B/C ? ");
      if(quiz.validateAnswer(question, quiz.scanner.next().charAt(0))){
        this.score++;
      }
    }
    System.out.println("Quiz is over, this is your score: " + this.score);
  }



}
