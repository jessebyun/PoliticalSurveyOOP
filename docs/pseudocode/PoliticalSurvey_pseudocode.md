# PoliticalSurvey Class - Conducts the Survey

## Overview
The `PoliticalSurvey` class manages the entire survey process, including displaying questions, collecting responses, and making predictions.

## Responsibilities
- Iterates through each question and records the user's response.
- Converts responses into numerical scores for political affiliation calculation.
- Implements an early guessing system based on score trends.
- Computes a final political affiliation if an early guess was not made.

## Pseudocode
```plaintext
BEGIN PoliticalSurvey
    INITIALIZE with `questions`, `guessPoints`, `liberalThreshold`, `conservativeThreshold`
    SET totalScore = 0
    SET earlyGuessMade = false

    LOOP THROUGH each question:
        DISPLAY question and options
        GET user input
        VALIDATE input
        CONVERT answer to score
        ADD score to totalScore

        IF question number is in `guessPoints`
            COMPUTE average score
            CALL `getAffiliation()` based on score
            IF early guess is possible:
                DISPLAY early guess
                SET earlyGuessMade = true
                EXIT loop

    IF no early guess was made:
        COMPUTE final average score
        CALL `getAffiliation()` based on score
        DISPLAY final guess

    ASK user for actual political affiliation
    DISPLAY user's entered affiliation
END

```