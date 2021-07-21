package Vocabulary;

public class Vocabulary {

    private int image;
    private String word;
    private String mean;
    private String IPA;
    private String example;
    private String example1;
    private String example2;

    public  Vocabulary(){};
    public Vocabulary(int image, String word, String mean, String IPA, String example, String example1, String example2) {
        this.image = image;
        this.word = word;
        this.mean = mean;
        this.IPA = IPA;
        this.example = example;
        this.example1 = example1;
        this.example2 = example2;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getIPA() {
        return IPA;
    }

    public void setIPA(String IPA) {
        this.IPA = IPA;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getExample1() {
        return example1;
    }

    public void setExample1(String example1) {
        this.example1 = example1;
    }

    public String getExample2() {
        return example2;
    }

    public void setExample2(String example2) {
        this.example2 = example2;
    }




}
