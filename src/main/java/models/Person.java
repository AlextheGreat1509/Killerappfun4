package models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Person_ID", unique = true, nullable = false)
    int id;

    @OneToMany(cascade = {CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST}, fetch=FetchType.LAZY)
    private List<WordList> wordList = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST}, fetch=FetchType.LAZY)
    private List<Result> resultList = new ArrayList<>();

    private String name;

    @NotNull
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public List<WordList> getWordList() {
        return wordList;
    }

    public void setWordList(List<WordList> wordList) {
        this.wordList = wordList;
    }

    public void addWordList(WordList wordList) {
        this.wordList.add(wordList);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Result> getResultList() {
        return resultList;
    }

    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }

    public void addResult(Result result) {
        this.resultList.add(result);
    }
}
