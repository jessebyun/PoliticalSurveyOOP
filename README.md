# Political Survey OOP

## 🗳️ About the Project
This is a **Java-based Political Survey** program that predicts a user's political affiliation based on their responses to multiple-choice questions. The program uses **object-oriented programming (OOP)** principles to organize the questions, process user inputs, and make a political guess.

## 📌 Features
- **Interactive survey** with multiple-choice questions.
- **Early prediction system** that estimates political leaning before all questions are answered.
- **Final prediction** based on average scores from responses.
- **User-friendly interface** with simple question prompts.
- **Object-Oriented Design (OOP)** to ensure modularity and scalability.

## 🏗️ Project Structure
```shell
📂 PoliticalSurveyOOP/
│── 📂 src/                # Source code directory
│   │── 📄 Main.java           # Entry point for the program
│   │── 📄 PoliticalSurvey.java # Manages survey flow, scoring, and predictions
│   │── 📄 QuestionBank.java   # Stores all survey questions
│   │── 📄 Question.java       # Represents a single question with answer options
│── 📄 README.md          # Documentation for the project (located in the root directory)
```

---

### 🛠️ How to Navigate the Code:
1. **Clone the Repository**:
   ```sh
   git clone https://github.com/yourusername/PoliticalSurveyOOP.git



## 🛠️ Technologies Used
- **Java** (JDK 19+)
- **Object-Oriented Programming (OOP) Principles**
- **Git & GitHub** (for version control)

## 📥 Installation
### Prerequisites
- Install **Java JDK 19+** on your system.
- Set up **Git** if you plan to clone the repository.
- (Optional) Use **IntelliJ IDEA** for a better development experience.

### Steps
1. **Clone the repository**:
   ```sh
   git clone https://github.com/jessebyun/PoliticalSurveyOOP.git
   
2. **Navigate to the project directory**:
    ```sh
    cd PoliticalSurveyOOP
   
3. **Compile the project**:
    ```sh
    javac *.java
   
4. *Run the survey*:
    ```sh
   java Main

## 🎮 How to Use
1. Run the program using the java Main command.
2. Answer each question using A, B, C, or D.
3. The program will attempt an early prediction at certain points.
4. If no early guess is made, a final prediction will be given.
5. The user is then asked to confirm their actual political affiliation.

## 🔍 Example Output
```
1. What is your view on the government's role in the economy?
A. Increase regulation
B. Mixed approach
C. Free market policies
D. Minimize intervention
Your answer (A/B/C/D): A

2. What is your stance on healthcare systems?
A. Universal healthcare
B. Employer-based
C. Private insurance
D. Personal savings
Your answer (A/B/C/D): B

...
Our early guess is that you are: Liberal

Please enter your actual political affiliation for our survey: 
You identified as: Liberal
```

