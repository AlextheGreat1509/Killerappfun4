package repository;

import dbal.repository.WordEntryRepository;
import models.WordEntry;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.logging.Level;

import static org.junit.Assert.assertEquals;

public class WordEntryRepoTest extends AbstractRepoTest {
    private WordEntryRepository repo;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void TestInitialize() {
        repo = new WordEntryRepository();
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
    }


    private WordEntry insertOneValidWordEntry() {
        WordEntry wordEntry = new WordEntry();
        wordEntry.setProblem("TestProblem");
        wordEntry.setTranslation("TestTranslation");
        repo.save(wordEntry);
        return wordEntry;
    }

    @Test
    public void testSaveValid() {
        int before = repo.findAll().size();
        insertOneValidWordEntry();
        int after = repo.findAll().size();
        assertEquals(before + 1, after);
    }

    @Test
    public void testFindAll() {
        int repoSize = repo.findAll().size();
        insertOneValidWordEntry();
        assertEquals(repoSize + 1, repo.findAll().size());

        for (int i = 0; i < 10; i++) {
            insertOneValidWordEntry();
        }
        int result = repo.findAll().size();
        assertEquals(repoSize + 11, result);
    }

    @Test
    public void testDelete() {
        WordEntry wordEntry = insertOneValidWordEntry();
        int repoSize = repo.findAll().size();

        repo.delete(wordEntry);
        int repoSizeAfter = repo.findAll().size();
        assertEquals(repoSize - 1, repoSizeAfter);
    }

}
