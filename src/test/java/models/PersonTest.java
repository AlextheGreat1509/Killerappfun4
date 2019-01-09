package models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PersonTest {

    private Person person;

    @Before
    public void setUp() {
        person = new Person();
    }

    /*@Test
    public void addEntry() {
        person.setName("Alex");
        person.setEmail("testemail@test.com");
        List<WordEntry> listEntries = new ArrayList<>();
        wordList.setListEntries(listEntries);
        int beforeSize = wordList.getListEntries().size();
        listEntries.add(wordEntry);
        wordList.setListEntries(listEntries);
        Assert.assertEquals(wordList.getListEntries().size(), beforeSize + 1);
    }*/
}
