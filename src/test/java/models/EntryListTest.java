package models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EntryListTest {

    private WordList wordList;

    @Before
    public void setUp() {
        wordList = new WordList();
    }

    @Test
    public void addEntry() {
        WordEntry wordEntry = new WordEntry();
        List<WordEntry> listEntries = new ArrayList<>();
        wordList.setListEntries(listEntries);
        int beforeSize = wordList.getListEntries().size();
        listEntries.add(wordEntry);
        wordList.setListEntries(listEntries);
        Assert.assertEquals(wordList.getListEntries().size(), beforeSize + 1);
    }
}
