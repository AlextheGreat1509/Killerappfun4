package restServer.handler;

import dbal.repository.WordListRepository;
import dbal.repository.WordEntryRepository;
import models.WordList;
import models.WordEntry;
import org.hibernate.Session;
import restServer.reply.Reply;
import restServer.reply.Status;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

public class ListHandler {

    private WordListRepository wordListRepository = new WordListRepository();
    private WordEntryRepository wordEntryRepository = new WordEntryRepository();

    public void SubmitEntry(List<String> problemWords, List<String> translationWords) {

        WordList wordList = new WordList();
        List<WordEntry> listEntries = new ArrayList<>();
        for (int i = 0; i < problemWords.size(); i++){
            if(!problemWords.get(i).trim().equals("") && !problemWords.get(i).isEmpty()) {
                WordEntry wordEntry = new WordEntry();
                wordEntry.setProblem(problemWords.get(i));
                wordEntry.setTranslation(translationWords.get(i));
                listEntries.add(wordEntry);
            }
        }
        wordList.setListEntries(listEntries);

        for (WordEntry entry: listEntries) {
            wordEntryRepository.save(entry);
        }
        wordListRepository.save(wordList);
    }

    public List<WordList> GetLists() {
        Session session = wordListRepository.openSession();
        List queryResult = session.createCriteria(WordList.class).list();
        ArrayList<WordList> resultList = new ArrayList<>();
        for (Object result : queryResult) {
            WordList wordList = (WordList) result;
            resultList.add(wordList);
        }
        return resultList;
    }
}
