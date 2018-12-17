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
