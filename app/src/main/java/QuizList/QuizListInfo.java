package QuizList;

public class QuizListInfo {
    String Lever;
    String Info;
    int img;

    public QuizListInfo(String lever, String info, int img) {
        Lever = lever;
        Info = info;
        this.img = img;
    }

    public String getLever() {
        return Lever;
    }

    public void setLever(String lever) {
        Lever = lever;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
