import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApp {
    private final List<Question> questions;
    private int score;

    public QuizApp() {
        questions = new ArrayList<>();
        score = 0;
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question("What is the capital of France?", List.of("Paris", "London", "Berlin", "Madrid"), 0));
        questions.add(new Question("What is 2 + 2?", List.of("3", "4", "5", "6"), 1));
        questions.add(new Question("What is the capital of India?", List.of("Delhi", "Kolkata", "Chennai", "Banglore"), 0));
        questions.add(new Question("which language runs in web Browser?", List.of("java", "C", "Python", "JS"),3));
        
       

        // Add more questions here
    }

    public void startQuiz() {
        try (Scanner scanner = new Scanner(System.in)) {
            for (Question question : questions) {
                System.out.println(question.getQuestionText());
                List<String> options = question.getOptions();
                for (int i = 0; i < options.size(); i++) {
                    System.out.println((i + 1) + ". " + options.get(i));
                }
                System.out.print("Enter your answer (1-" + options.size() + "): ");
                int userAnswer = scanner.nextInt() - 1;
                if (userAnswer == question.getCorrectAnswerIndex()) {
                    score++;
                }
            }
            System.out.println("Your score: " + score + "/" + questions.size());
        }
    }

    public static void main(String[] args) {
        QuizApp quizApp = new QuizApp();
        quizApp.startQuiz();
    }
}