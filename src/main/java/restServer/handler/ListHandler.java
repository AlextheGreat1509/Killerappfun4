package restServer.handler;

import dbal.repository.EntryListRepository;
import dbal.repository.ListEntryRepository;
import models.EntryList;
import models.ListEntry;

import java.util.ArrayList;
import java.util.List;

public class ListHandler {

    EntryListRepository entryListRepository = new EntryListRepository();
    ListEntryRepository listEntryRepository = new ListEntryRepository();

    public void SubmitEntry(String problem, String solution) {
        EntryList entryList = new EntryList();
        ListEntry listEntry = new ListEntry();
        listEntry.setProblem(problem);
        listEntry.setSolution(solution);
        listEntry.setEntryList(entryList);
        List<ListEntry> listEntries = new ArrayList<>();
        listEntries.add(listEntry);
        entryList.setListEntries(listEntries);

        entryListRepository.save(entryList);
        listEntryRepository.save(listEntry);
    }
}
