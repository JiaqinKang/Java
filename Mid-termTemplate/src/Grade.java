public class Grade {
    private String subject;
    private double score;

    //constructor
    public Grade(String C_subject, double C_score) {
        subject = C_subject;
        score = C_score;
    }

    //getter method
    public String getSubject() {
        return subject;
    }

    public double getScore() {
        return score;
    }

    //setter method
    public void setGradeMethod(String subject, double score) {
        this.subject = subject;
        this.score = score;
    }

    public static char getLetterGrade(double score) {
        //An invalid score >100 return 'E' error
        if (score > 100){
            return 'E';
        }
        else if(score >= 70){
            return 'A';
        }
        else if(score >= 60){
            return 'B';
        }
        else if(score >= 50){
            return 'C';
        }
        else if(score >= 40){
            return 'D';
        }
        else if(score < 40 && score > 0){//grate between 0 < 40
            return 'F';
        }
        //An invalid score  < 0  returns ‘E” for error
        return 'E';
    }

    //toString method
    @Override
    public String toString() {
        return "Grade{" +
                "subject='" + subject + '\'' +
                ", score=" + getLetterGrade(score) +
                '}';
    }
}
