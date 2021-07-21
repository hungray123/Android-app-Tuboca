package VocabularyFruits;

public class Fruits {
    private int imageFruits;
    private String word;
    private String ipa;
    private String mean;

    public  Fruits(){}
    public Fruits(int imageFruits, String word, String ipa, String mean) {
        this.imageFruits = imageFruits;
        this.word = word;
        this.ipa = ipa;
        this.mean = mean;
    }

    public int getImageFruits() {
        return imageFruits;
    }

    public void setImageFruits(int imageFruits) {
        this.imageFruits = imageFruits;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getIpa() {
        return ipa;
    }

    public void setIpa(String ipa) {
        this.ipa = ipa;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }
}
