package dbal.repository;

import models.WordEntry;

public class WordEntryRepository extends AbstractRepository<WordEntry, Integer> {
        @Override
        public Class<WordEntry> getDomainClass() {
            return WordEntry.class;
        }
}

