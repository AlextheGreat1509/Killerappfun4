package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "EntryList")
public class EntryList {
    @OneToMany(mappedBy="entryList", cascade = {CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST})
    private List<ListEntry> listEntries;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "List_ID", unique = true, nullable = false)
    int id;

    public List<ListEntry> getListEntries() {
        return listEntries;
    }

    public void setListEntries(List<ListEntry> listEntries) {
        this.listEntries = listEntries;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
