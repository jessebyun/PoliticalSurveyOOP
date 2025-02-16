# Main Class - Political Survey Program

## Overview
The `Main` class serves as the entry point for the political survey program. It initializes the key components and starts the survey process.

## Responsibilities
- Loads questions from the `QuestionBank`.
- Defines early guess points based on the number of questions.
- Initializes a `PoliticalSurvey` instance.
- Starts the survey execution.

## Pseudocode
```plaintext
BEGIN Main
    CREATE an instance of `QuestionBank`
    RETRIEVE questions from `QuestionBank`
    GET total number of questions

    DEFINE guess points as 50%, 70%, and 90% of total questions
    SET liberal threshold to 1.5
    SET conservative threshold to 3.5

    CREATE an instance of `PoliticalSurvey` with the retrieved questions, guess points, and thresholds
    CALL `runSurvey()` on `PoliticalSurvey`
END
```
