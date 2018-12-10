package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "WordList")
public class WordList {
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST}, fetch=FetchType.LAZY)
    private List<WordEntry> listEntries;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "WordList_ID", unique = true, nullable = false)
    int id;

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
}
