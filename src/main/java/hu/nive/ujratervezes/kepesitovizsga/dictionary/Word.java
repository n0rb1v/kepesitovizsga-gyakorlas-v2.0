package hu.nive.ujratervezes.kepesitovizsga.dictionary;

public class Word {
    private String hun;
    private String eng;

    public Word(String hun, String eng) {
        this.hun = hun;
        this.eng = eng;
    }

    public String getHun() {
        return hun;
    }

    public String getEng() {
        return eng;
    }
}
