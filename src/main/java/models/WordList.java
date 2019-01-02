package models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "WordList")
public class WordList {
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST}, fetch=FetchType.EAGER)
    private List<WordEntry> listEntries;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "WordList_ID", unique = true, nullable = false)
    int id;

    @NotNull
    private String title;

    @NotNull
    private String problemLanguage;

    @NotNull
    private String translationLanguage;

    public String getProblemLanguage() {
        return problemLanguage;
    }

    public void setProblemLanguage(String problemLanguage) {
        this.problemLanguage = problemLanguage;
    }

    public String getTranslationLanguage() {
        return translationLanguage;
    }

    public void setTranslationLanguage(String translationLanguage) {
        this.translationLanguage = translationLanguage;
    }

    public List<WordEntry> getListEntries() {
        return listEntries;
    }

    public void setListEntries(List<WordEntry> listEntries) {
        this.listEntries = listEntries;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
