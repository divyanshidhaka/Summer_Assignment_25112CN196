import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;
    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public void displayQuestion(int questionNumber) {
        System.out.println("\nQ" + questionNumber + ". " + questionText);
        char optionLetter = 'A';
        for (String option : options) {
            System.out.println("  " + optionLetter + ") " + option);
            optionLetter++;
        }
    }

    public boolean checkAnswer(int userChoice) {
        return userChoice == correctAnswerIndex;
    }

    public String getCorrectAnswerText() {
        char letter = (char) ('A' + correctAnswerIndex - 1);
        return letter + ") " + options[correctAnswerIndex - 1];
    }
}

public class QuizApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Question> quizBank = new ArrayList<>();

        quizBank.add(new Question(
            "Which data type is used to create a variable that should store text in Java?",
            new String[]{"String", "char", "txt", "StringMemory"},
            1
        ));

        quizBank.add(new Question(
            "What is the correct way to create an object called 'myObj' of a class named 'MyClass'?",
            new String[]{"class MyClass = new myObj();", "MyClass myObj = new MyClass();", "new MyClass = myObj();", "myObj MyClass = new class();"},
            2
        ));

        quizBank.add(new Question(
            "Which operator can be used to compare two values in Java?",
            new String[]{"=", "<>", "==", "><"},
            3
        ));

        quizBank.add(new Question(
            "Which property is used to find the number of elements in a Java array?",
            new String[]{"size()", "count", "length()", "length"},
            4
        ));

        // 2. Start the Quiz
        System.out.println("=========================================");
        System.out.println("|     WELCOME TO THE JAVA MINI QUIZ     |");
        System.out.println("=========================================");
        System.out.println("Instructions: Answer by typing 1, 2, 3, or 4.");
        
        int score = 0;

        for (int i = 0; i < quizBank.size(); i++) {
            Question currentQuestion = quizBank.get(i);
            currentQuestion.displayQuestion(i + 1);
            
            int userChoice = 0;
            boolean validEntry = false;

            while (!validEntry) {
                System.out.print("Your choice (1-4): ");
                if (scanner.hasNextInt()) {
                    userChoice = scanner.nextInt();
                    if (userChoice >= 1 && userChoice <= 4) {
                        validEntry = true;
                    } else {
                        System.out.println("Please select a number between 1 and 4.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                }
            }

            // Grade the answer
            if (currentQuestion.checkAnswer(userChoice)) {
                System.out.println("✨ Correct!");
                score++;
            } else {
                System.out.println("❌ Incorrect.");
                System.out.println("The correct answer was: " + currentQuestion.getCorrectAnswerText());
            }
        }

        // 3. Final Performance Summary
        System.out.println("\n=========================================");
        System.out.println("|              QUIZ OVER!               |");
        System.out.println("=========================================");
        System.out.println("Your Final Score: " + score + " / " + quizBank.size());
        
        double percentage = ((double) score / quizBank.size()) * 100;
        System.out.printf("Success Rate: %.1f%%\n", percentage);

        if (percentage >= 75) {
            System.out.println("Status: Excellent job! You really know your fundamentals.");
        } else if (percentage >= 50) {
            System.out.println("Status: Good effort! A little revision and you'll ace it.");
        } else {
            System.out.println("Status: Keep practicing! Failure is just an opportunity to relearn.");
        }
        System.out.println("=========================================");

        scanner.close();
    }
}