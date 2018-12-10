package models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "WordEntry")
public class WordEntry {

    @NotNull
    private String problem;

    @NotNull
    private String translation;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "WordEntry_ID", unique = true, nullable = false)
    int id;

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
