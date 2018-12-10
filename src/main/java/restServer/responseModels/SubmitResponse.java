package restServer.responseModels;

import java.util.List;

public class SubmitResponse {

    private List<String> problemWords;
    private List<String> translationWords;

    public List<String> getProblemWords() {
        return problemWords;
    }

    public void setProblemWords(List<String> dutchWords) {
        this.problemWords = dutchWords;
    }

    public List<String> getTranslationWords() {
        return translationWords;
    }

    public void setTranslationWords(List<String> translationWords) {
        this.translationWords = translationWords;
    }
}
