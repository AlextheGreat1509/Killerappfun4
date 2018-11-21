package dbal.repository;

import models.EntryList;

public class EntryListRepository extends AbstractRepository<EntryList, Integer> {
        @Override
        public Class<EntryList> getDomainClass() {
            return EntryList.class;
        }
}

