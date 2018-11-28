package models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EntryListTest {

    private EntryList entryList;

    @Before
    public void setUp() {
        entryList = new EntryList();
    }

    @Test
    public void addEntry() {
        ListEntry listEntry = new ListEntry();
        List<ListEntry> listEntries = new ArrayList<>();
        entryList.setListEntries(listEntries);
        int beforeSize = entryList.getListEntries().size();
        listEntries.add(listEntry);
        entryList.setListEntries(listEntries);
        Assert.assertEquals(entryList.getListEntries().size(), beforeSize + 1);
    }
}
