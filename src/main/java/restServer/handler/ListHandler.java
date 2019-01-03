package restServer.handler;

import dbal.repository.PersonRepository;
import dbal.repository.WordListRepository;
import dbal.repository.WordEntryRepository;
import models.Person;
import models.WordList;
import models.WordEntry;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ListHandler {

    private WordListRepository wordListRepository = new WordListRepository();
    private WordEntryRepository wordEntryRepository = new WordEntryRepository();
    private PersonRepository personRepository = new PersonRepository();

    public void SubmitEntry(List<String> problemWords, List<String> translationWords, String title, String problemLanguage, String translationLanguage, String personName) {

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
        wordList.setTitle(title);

        Person person = new Person();
        person.setName(personName);
        person.setWordList(wordList);

        wordList.setProblemLanguage(problemLanguage);
        wordList.setTranslationLanguage(translationLanguage);

        for (WordEntry entry: listEntries) {
            wordEntryRepository.save(entry);
        }

        wordListRepository.save(wordList);
        personRepository.save(person);
    }

    public List<WordList> GetLists() {
        Session session = wordListRepository.openSession();
        List queryResult = session.createCriteria(WordList.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        ArrayList<WordList> resultList = new ArrayList<>();
        for (Object result : queryResult) {
            WordList wordList = (WordList) result;
            resultList.add(wordList);
        }
        return resultList;
    }

    public WordList GetListById(int id) {
        return wordListRepository.findOne(id);
    }
}
