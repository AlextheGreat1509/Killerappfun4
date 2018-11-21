package dbal.repository;

import models.ListEntry;

public class ListEntryRepository extends AbstractRepository<ListEntry, Integer> {
        @Override
        public Class<ListEntry> getDomainClass() {
            return ListEntry.class;
        }
}

