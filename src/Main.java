public class Main {

    public static void main(String[] args) {
        // Create a QuestionBank to manage the survey questions
        QuestionBank questionBank = new QuestionBank();
        Question[] questions = questionBank.getQuestions(); // Retrieve the list of questions
        int totalQuestions = questionBank.getTotalQuestions(); // Get the total number of questions

        // Define guess points as fractions of total questions (ex. 50%, 70%, 90%)
        int[] guessPoints = {
                (int)(0.5 * totalQuestions),
                (int)(0.7 * totalQuestions),
                (int)(0.9 * totalQuestions)
        };

        // Define score thresholds for political affiliation determination
        double liberalThreshold = 1.5;
        double conservativeThreshold = 3.5;

        // Create a PoliticalSurvey object and start the survey
        PoliticalSurvey survey = new PoliticalSurvey(questions, guessPoints, liberalThreshold, conservativeThreshold);
        survey.runSurvey();
    }
}