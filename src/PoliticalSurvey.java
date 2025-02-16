import java.util.Scanner;

// Conducts the survey, collects responses, and makes a political affiliation guess
public class PoliticalSurvey {
    private Question[] questions; // Array of survey questions
    private int[] guessPoints; // Question numbers at which early guesses are made
    private double liberalThreshold; // Score threshold for Liberal determination
    private double conservativeThreshold; // Score threshold for Conservative determination

    // Constructor initializes the survey with questions, guess points, and thresholds
    public PoliticalSurvey(Question[] questions, int[] guessPoints, double liberalThreshold, double conservativeThreshold) {
        this.questions = questions;
        this.guessPoints = guessPoints;
        this.liberalThreshold = liberalThreshold;
        this.conservativeThreshold = conservativeThreshold;
    }

    // Runs the survey, collects responses, and determines political affiliation
    public void runSurvey() {
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0; // Scores cumulative score of answers
        boolean earlyGuessMade = false; // Tracks whether an early guess was made

        // Loop through each question and ask user for input
        for (int i = 0; i < questions.length; i++) {
            questions[i].display(i + 1); // Display the question with options
            System.out.println("Your answer (A/B/C/D): ");
            String answer = scanner.nextLine().toUpperCase(); // Convert user input to uppercase
            int points = getScoreFromAnswer(answer); // Convert response to a score
            totalScore += points; // Add to the total score

            // Check for an early guess at predetermined question numbers
            if (shouldMakeGuess(i + 1)) {
                double averageScore = (double) totalScore / (i + 1); // Calculate average score
                String earlyGuess = getAffiliation(averageScore); // Get political affiliation based from average score
                if (!earlyGuess.equals("Undetermined")) {
                    System.out.println("Our early guess is that you are: " + earlyGuess);
                    earlyGuessMade = true;
                    break; // Stop the survey if an early guess is made
                }
            }
        }

        // If no early guess was made, calculate a final guess at the end
        if (!earlyGuessMade) {
            double finalAverage = (double) totalScore / questions.length;
            String finalGuess = getAffiliation(finalAverage);
            System.out.println("Our final guess is that you are: " + finalGuess);
        }

        // Ask for the user's actual political affiliation
        System.out.println("Please enter your actual political affiliation for our survey: ");
        String actualAffiliation = scanner.nextLine();
        System.out.println("You identified as: " + actualAffiliation);

        scanner.close();
    }

    // Determines the score based on the user's answer
    private int getScoreFromAnswer(String answer) {
        switch (answer) {
            case "A": return 1; // Most Liberal choice
            case "B": return 2; // Moderate left
            case "C": return 3; // Moderate right
            case "D": return 4; // Most Conservative choice
            default:
                System.out.println("Invalid input, moving to next question");
                return 0; // If input is invalid, return 0 points
        }
    }

    // Checks whether the current question is a predetermined guess point
    private boolean shouldMakeGuess(int questionNumber) {
        for (int point : guessPoints) {
            if (questionNumber == point) {
                return true;
            }
        }
        return false;
    }

    // Determines political affiliation based on average score
    private String getAffiliation(double averageScore) {
        if (averageScore <= liberalThreshold)
            return "Liberal";
        else if (averageScore >= conservativeThreshold)
            return "Conservative";
        return "Undetermined"; // If score is in the middle, return undetermined
    }
}