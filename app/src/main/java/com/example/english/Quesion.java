package com.example.english;

import java.util.List;

public class Quesion {
    private  String content;
    private  int Number;
    private List<Anwser> listAnser;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public List<Anwser> getListAnser() {
        return listAnser;
    }

    public void setListAnser(List<Anwser> listAnser) {
        this.listAnser = listAnser;
    }

    public Quesion(String content, int number, List<Anwser> listAnser) {
        this.content = content;
        Number = number;
        this.listAnser = listAnser;
    }
}
