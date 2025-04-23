public class Grade {
    private int kor;
    private int eng;
    private int math;
    private int total;
    private double avr;

    public Grade(int kor, int eng, int math) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.total = kor+eng+math;
        this.avr = (double) this.total/3;
    }

    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }

    public int getMath() {
        return math;
    }

    public int getTotal() {
        return total;
    }

    public double getAvr() {
        return avr;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setAvr(int avr) {
        this.avr = avr;
    }
}
