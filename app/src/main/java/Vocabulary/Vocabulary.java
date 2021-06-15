package Vocabulary;

public class Vocabulary {

    private int image;
    private String word;
    private String mean;
    private String IPA;

    public  Vocabulary(){}
    public Vocabulary(int image, String word, String mean, String IPA) {
        this.image = image;
        this.word = word;
        this.mean = mean;
        this.IPA = IPA;
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
}
