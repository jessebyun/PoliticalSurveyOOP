# Testing Report: Political Affiliation Quiz Program

## **Overview**
This document details the testing process for the Political Affiliation Quiz program.  
The focus was on:
- **Valid Input Handling:** Ensuring scoring, classification, and early guess mechanisms work as intended.
- **Invalid Input Handling:** Ensuring the program properly skips invalid inputs without affecting the score.
- **Edge Cases:** Testing scenarios where inputs are extreme or unexpected.

To help with debugging, the program prints:
- `"DEBUG: Valid response count = "` - Valid response counter
- `"DEBUG: Score from current question = "` - Score from user's response
- `"DEBUG: Total score so far = "` - Cumulative total after each question
- `"DEBUG: Real-time average score = "` - Dynamic scoring logic
- `"DEBUG: Final calculation. Average score = "` - End-of-survey score

---

## **Test Cases and Results**

### ✔️ **Valid Input Handling**
| Test Case | Input | Expected Outcome                   | Actual Output | Pass/Fail |
|-----------|--------|------------------------------------|--------------|-----------|
| Normal input | A, B, C, D in sequence | Correct scoring and classification | Score updated correctly | ✅ PASS |
| All "A" answers | A for all questions | Liberal affiliation                | Score updated correctly, triggered early guess | ✅ PASS |
| All "D" answers | D for all questions | Conservative affiliation           | Score updated correctly, triggered early guess | ✅ PASS |
| Alternating answers | A, D, A, D... | Middle score (Undetermined)        | Score updated correctly, ran full survey with "Undetermined" classification | ✅ PASS |

### ❌ **Invalid Input Handling**
| Test Case | Input | Expected Outcome | Actual Output                                                                                 | Pass/Fail |
|-----------|--------|------------------|-----------------------------------------------------------------------------------------------|-----------|
| Invalid inputs | "X", "5", "hello" | Skip question, not counted toward score | Skips question and total score remains same                                                   | ✅ PASS |
| One valid response, rest invalid | "A", "X", "X", ... | No early guess should be made | Each invalid response skewed average toward 0, incorrectly triggered early guess as "Liberal" | ❌ FAIL |
| Only invalid responses | "X" for all | No affiliation guessed | Incorrectly triggered an early guess as "Liberal"                                             | ❌ FAIL |

---

## ⚡ **Edge Case Analysis**

### **1️⃣ Early Guess with Insufficient Valid Responses**
🔻 *Problem:* If only 1 valid response is given before a guess point, an early guess is made based on a single answer, leading to inaccurate results.

---

### **2️⃣ Invalid Inputs Skewing Liberal Scores**
🔻 *Problem:* Invalid answers were being counted as "0", artificially lowering the average score, making the program more likely to guess "Liberal."

---

### **3️⃣ All "A" or All "D" Answers (Extreme Cases)**
🔹 *Test:* Entering all "A" or all "D" should result in extreme liberal or conservative outcomes.  
🔹 *Validation:* Confirmed that **all "A" resulted in "Liberal"** and all "D" resulted in "Conservative" with no miscalculations.

---

### **4️⃣ Alternating Answers (A, D, A, D...)**
🔹 *Test:* Alternating responses should average out to an "Undetermined" score.  
🔹 *Validation:* Confirmed that **averages remained balanced** and resulted in "Undetermined."

---

## **Identified Issues and Fixes**
### **🔴 Issue: Invalid Inputs Skewing Early Guess**
- **Problem:**  
  If only **one** valid answer was provided while the rest were invalid, the **early guess was still triggered**.
    - The early guess system **checks after 50% of questions (10 questions)**.
    - Even with **9 invalid** and **1 valid** response, the system calculated an **incorrect** average and guessed **"Liberal."**

---

## **🔹 Before Fix: Incorrect Behavior**
### **Code Logic Before Fix (Pseudocode)**
```plaintext
initialize totalScore = 0
initialize earlyGuessMade = false

for each question in survey:
    display question with options
    get user input

    determine score from user input
    add score to totalScore

    if currentQuestionNumber matches an early guess point:
        calculate averageScore = totalScore / currentQuestionNumber // Uses total questions
        determine earlyGuess based on averageScore
        
        if earlyGuess is not "Undetermined":
            print "Our early guess is: " + earlyGuess
            earlyGuess = true
            break // Exit loop if early guess is made
            
if earlyGuessMade is false:
    calculate finalAverage = totalScore / totalQuestions // Uses total questions
    determine finalGuess based on finalAverage
    print "Our final guess is: " + finalGuess
    
```

## **🔺 Problem:**

- Invalid responses were not properly skipped, which made the average score lower.
- An early guess was made even if most responses were invalid, leading to incorrect predictions.

---

## **🔹 After Fix: Corrected Behavior**
### **Fix Applied**
- Skip invalid responses completely (they are no longer counted in scoring or early guesses).
- Ensure early guesses only trigger if enough valid responses exist.
- Only make a final classification if at least one valid response is given.

### Fixed Code Logic (Pseudocode)
```plaintext
initialize totalScore = 0
initialize validResponses = 0 // Track only valid answerws
initialize earlyGuessMade = false

for each question in survey:
    display question with options
    get user input
    determmine score from user input

    if input is invalid : // Now checks for valid input
        print "Invalid input, skipping question."
        continue  // Skip processing current iteration- bypass adding to totalScore and making early guess

    add score of userInput to totalScore
    increment validResponses counter // Count valid response

    if validResponses matches an early guess checkpoint: // Matches checkpoint by # of validResponses rather # of questions encountered
        calculate averageScore = totalScore / validResponses // Now uses valid responses
        determine earlyGuess based on averageScore
        
        if earlyGuess is not "Undetermined":
            print "Our early guess is: " + earlyGuess
            earlyGuessMade = true
            break  // Stop survey

if earlyGuessMade is false and validResponses > 0: // Now requires least one valid response for determination at end
    calculate finalAverage = totalScore / validResponses // Uses only valid responses
    determine finalGuess based on finalAverage
    print "Our final guess is: " + finalGuess
else if validResponses == 0:
    print "No valid responses given. Unable to determine affiliation."
```

---

## **🔹 Results After Fix**

| Test Case | Input | Expected Outcome | Actual Output          | Pass/Fail |
|-----------|--------|------------------|------------------------|----|
| One valid response, rest invalid | "A", "X", "X", ... | No early guess should be made | No early guess triggered | ✅ PASS |
| Only invalid responses | "X" for all | No affiliation guessed | No classification made | ✅ PASS |

---

## **🔹 Key Takeaways**
✅ Fix ensures only valid responses contribute to both early and final guesses.  
✅ Invalid responses no longer affect the scoring or classification.  
✅ Prevents misleading classifications when there are too few valid responses.  
✅ The final guess is only made if at least one valid answer is provided.

---
## ** 🔗 References **
📄 For actual implementation, refer to [`PoliticalSurvey.java`](https://github.com/jessebyun/PoliticalSurveyOOP/blob/main/src/PoliticalSurvey.java).  
📃 To view pseudocode, refer to [`docs/pseudocode`](https://github.com/jessebyun/PoliticalSurveyOOP/tree/main/docs/pseudocode).

[//]: # (Need to implement before and after pseudocode)