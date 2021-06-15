package com.example.english;

public  class Question{
    private String question;
    private String answer1;
    private String answer2;
    private String answerR;

    public Question(){}

    public Question(String question, String answer1, String answer2, String answerR) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answerR = answerR;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswerR() {
        return answerR;
    }

    public void setAnswerR(String answerR) {
        this.answerR = answerR;
    }
}


//public class Question {
//    private String question;
//    private String option1;
//    private String option2;
//    private int answerR;
//
//    public Question(){}
//    public Question(String question, String option1, String option2, int answerR) {
//        this.question = question;
//        this.option1 = option1;
//        this.option2 = option2;
//        this.answerR = answerR;
//    }
//
//    public String getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(String question) {
//        this.question = question;
//    }
//
//    public String getOption1() {
//        return option1;
//    }
//
//    public void setOption1(String option1) {
//        this.option1 = option1;
//    }
//
//    public String getOption2() {
//        return option2;
//    }
//
//    public void setOption2(String option2) {
//        this.option2 = option2;
//    }
//
//    public int getAnswerR() {
//        return answerR;
//    }
//
//    public void setAnswerR(int answerR) {
//        this.answerR = answerR;
//    }
//}




