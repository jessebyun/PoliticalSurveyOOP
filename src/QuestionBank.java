// Manages the list of all questions for the survey
public class QuestionBank {
    private Question[] questions; // Array to hold all survey questions

    // Constructor to initialize and store all survey questions
    public QuestionBank() {
        // Initialize the questions array
        questions = new Question[] {
                new Question("What is your view on the government's role in the economy?", new String[] {
                        "A. Increase regulation",
                        "B. Mixed approach",
                        "C. Free market policies",
                        "D. Minimize intervention"
                }),
                new Question("What is your stance on healthcare systems?", new String[]{
                        "A. Universal healthcare",
                        "B. Employer-based",
                        "C. Private insurance",
                        "D. Personal savings"
                }),
                new Question("How should education be funded?", new String[] {
                        "A. Public school funding",
                        "B. Charter schools",
                        "C. Private school vouchers",
                        "D. Parental responsibility"
                }),
                new Question("What are your thoughts on climate change?", new String[] {
                        "A. Strict regulations",
                        "B. Renewable energy",
                        "C. Private sector solutions",
                        "D. Climate change skepticism"
                }),
                new Question("What is your opinion on immigration policy?", new String[] {
                        "A. Open borders",
                        "B. Citizenship pathway",
                        "C. Strict controls",
                        "D. Merit-based system"
                }),
                new Question("What is your stance on gun control?", new String[] {
                        "A. Stricter laws",
                        "B. Moderate control",
                        "C. Some gun rights",
                        "D. Right to bear arms"
                }),
                new Question("What should be done about income inequality?", new String[] {
                        "A. Redistribution",
                        "B. Social programs",
                        "C. Tax incentives",
                        "D. Market solutions"
                }),
                new Question("How should the government handle social welfare?", new String[] {
                        "A. Expand programs",
                        "B. Reform programs",
                        "C. Limited support",
                        "D. Personal responsibility"
                }),
                new Question("What is your view on foreign policy and defense?", new String[] {
                        "A. Diplomacy focus",
                        "B. Economic sanctions",
                        "C. Military strength",
                        "D. Non-intervention"
                }),
                new Question("What is your stance on taxation?", new String[]  {
                        "A. Progressive taxation",
                        "B. Tax cuts",
                        "C. Flat tax",
                        "D. Minimal taxes"
                }),
                new Question("What is your opinion on abortion?", new String[]  {
                        "A. Pro-choice",
                        "B. Limited cases",
                        "C. Government out of it",
                        "D. Pro-life"
                }),
                new Question("How should the government approach housing policy?", new String[] {
                        "A. Government housing",
                        "B. Subsidies",
                        "C. Market solutions",
                        "D. Deregulation"
                }),
                new Question("What are your views on labor and employment laws?", new String[] {
                        "A. Union support",
                        "B. Stronger regulations",
                        "C. Free market",
                        "D. Minimal regulation"
                }),
                new Question("What is your stance on same-sex marriage?", new String[] {
                        "A. Full support",
                        "B. Civil unions",
                        "C. No government role",
                        "D. Oppose"
                }),
                new Question("How should the government handle environmental policies?", new String[] {
                        "A. Environmental protection",
                        "B. Balanced approach",
                        "C. Business-friendly",
                        "D. Skepticism"
                }),
                new Question("What is your opinion on international trade?", new String[] {
                        "A. Free trade",
                        "B. Protectionism",
                        "C. Fair trade",
                        "D. Self-sufficiency"
                }),
                new Question("How should national infrastructure be managed?", new String[]  {
                        "A. Government investment",
                        "B. Public-private partnerships",
                        "C. Private sector",
                        "D. Minimal spending"
                }),
                new Question("What is your stance on drug policy?", new String[] {
                        "A. Decriminalization",
                        "B. Medical use only",
                        "C. Strict enforcement",
                        "D. War on drugs"
                }),
                new Question("What are your views on privacy and surveillance?", new String[] {
                        "A. Privacy protection",
                        "B. Balanced approach",
                        "C. Security focus",
                        "D. Surveillance support"
                }),
                new Question("How should the government approach energy policy?", new String[] {
                        "A. Renewable energy",
                        "B. Mixed sources",
                        "C. Market-driven",
                        "D. Fossil fuels"
                })
        };
    }

    // Returns the list of all questions
    public Question[] getQuestions() {
        return questions;
    }

    // Returns the total number of questions in the survey
    public int getTotalQuestions() {
        return questions.length;
    }
}