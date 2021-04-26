package hu.nive.ujratervezes.kepesitovizsga.dictionary;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private JdbcTemplate jdbc;
    private List<Word> words = new ArrayList<>();

    public Dictionary(DataSource ds) {
        jdbc = new JdbcTemplate(ds);
        loadData();
    }

    private void loadData() {
        words = jdbc.query("select * from words",
                (rs, index) -> new Word(
                        rs.getString("magyar"),
                        rs.getString("angol")
                ));
    }

    public String getEnglishWord(String s) {
        return words.stream()
                .filter(word -> word.getHun().equals(s))
                .findAny()
                .map(Word::getEng)
                .orElseThrow(() -> new IllegalArgumentException("No such word in dictionary."));
    }

    public String getHungarianWord(String s) {
        return words.stream()
                .filter(word -> word.getEng().equals(s))
                .findAny()
                .map(Word::getHun)
                .orElseThrow(() -> new IllegalArgumentException("No such word in dictionary."));
    }
}
