package models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Result_ID", unique = true, nullable = false)
    int id;

    @NotNull
    int wordListId;

    @NotNull
    int score;

    @NotNull
    int total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWordListId() {
        return wordListId;
    }

    public void setWordListId(int wordListId) {
        this.wordListId = wordListId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
