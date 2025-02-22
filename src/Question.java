// This class represents a single survey question along with its answer options

public class Question {
    private String text; // The actual question text
    private String[] options; // Multiple-choice answer options (A/B/C/D)

    // Constructor to initialize the question and answer options
    public Question(String text, String[] options) {
        this.text = text;
        this.options = options;
    }

    // Displays the question and its answer options to the user
    public void display(int number) {
        System.out.println(number + ". " + text); // Print question number and text
        for (String option : options) {
            System.out.println(option); // Print each available answer options
        }
    }
}