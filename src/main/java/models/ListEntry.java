package models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ListEntry")
public class ListEntry {

    @NotNull
    private String problem;

    @NotNull
    private String solution;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    EntryList entryList;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ListEntry_ID", unique = true, nullable = false)
    int id;

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EntryList getEntryList() {
        return entryList;
    }

    public void setEntryList(EntryList entryList) {
        this.entryList = entryList;
    }
}
